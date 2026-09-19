import os
import sys
import json
import argparse
import zipfile
import traceback
from loguru import logger

# Suppress androguard debug logs
logger.remove()

from androguard.core.dex import DEX
from androguard.core.analysis.analysis import Analysis
from androguard.decompiler.decompiler import DecompilerDAD

def parse_args():
    parser = argparse.ArgumentParser(description="Memory-safe batch DEX decompiler for DigiTap.apk")
    parser.add_argument("--apk", default="DigiTap.apk", help="Path to APK file")
    parser.add_argument("--dex", default="classes2.dex", help="DEX file to process (e.g., classes.dex, classes2.dex, or 'all')")
    parser.add_argument("--filter", default="com/smart", help="Package or class name substring to filter (e.g. com/smart, thingclips)")
    parser.add_argument("--batch-size", type=int, default=30, help="Number of classes to decompile in one run")
    parser.add_argument("--output", default="decompiled_output/src", help="Output directory for java files")
    parser.add_argument("--list-only", action="store_true", help="Only list matching classes without decompiling")
    parser.add_argument("--reset-checkpoint", action="store_true", help="Reset previous progress")
    return parser.parse_args()

def get_checkpoint_path(out_dir):
    return os.path.join(out_dir, "decompile_checkpoint.json")

def load_checkpoint(out_dir):
    path = get_checkpoint_path(out_dir)
    if os.path.exists(path):
        try:
            with open(path, "r", encoding="utf-8") as f:
                return json.load(f)
        except Exception:
            pass
    return {"decompiled": [], "failed": []}

def save_checkpoint(out_dir, checkpoint_data):
    os.makedirs(out_dir, exist_ok=True)
    path = get_checkpoint_path(out_dir)
    with open(path, "w", encoding="utf-8") as f:
        json.dump(checkpoint_data, f, indent=2)

def main():
    args = parse_args()
    if not os.path.exists(args.apk):
        print(f"Error: APK not found at {args.apk}")
        sys.exit(1)

    os.makedirs(args.output, exist_ok=True)
    checkpoint = load_checkpoint(args.output)
    if args.reset_checkpoint:
        checkpoint = {"decompiled": [], "failed": []}
        save_checkpoint(args.output, checkpoint)
        print("Checkpoint reset.")

    decompiled_set = set(checkpoint.get("decompiled", []))
    failed_set = set(checkpoint.get("failed", []))

    with zipfile.ZipFile(args.apk, "r") as z:
        all_dex = sorted([f for f in z.namelist() if f.endswith(".dex")])
        if args.dex != "all":
            if args.dex in all_dex:
                target_dex_list = [args.dex]
            else:
                print(f"Error: {args.dex} not found in APK. Available: {', '.join(all_dex)}")
                sys.exit(1)
        else:
            target_dex_list = all_dex

        print(f"Scanning {len(target_dex_list)} DEX file(s) for filter '{args.filter}'...")
        
        # Discover all candidate classes
        candidates = []
        for dex_name in target_dex_list:
            dex_data = z.read(dex_name)
            dex = DEX(dex_data)
            for c in dex.get_classes():
                cname = c.get_name()
                if not args.filter or args.filter.lower() in cname.lower():
                    candidates.append((dex_name, cname))

    print(f"Total matching classes found: {len(candidates)}")
    already_done = sum(1 for _, cname in candidates if cname in decompiled_set)
    pending = [item for item in candidates if item[1] not in decompiled_set and item[1] not in failed_set]

    print(f"Already decompiled: {already_done}")
    print(f"Remaining pending: {len(pending)}")

    if args.list_only:
        print("\nFirst 20 pending classes:")
        for dex_name, cname in pending[:20]:
            print(f"  [{dex_name}] {cname}")
        return

    if not pending:
        print("No pending classes to decompile with the current filter!")
        return

    batch = pending[:args.batch_size]
    print(f"\nProcessing next batch of {len(batch)} classes...")

    # Group batch by DEX file so we only load and analyze each DEX once per run
    dex_batches = {}
    for dex_name, cname in batch:
        dex_batches.setdefault(dex_name, []).append(cname)

    success_count = 0
    fail_count = 0

    with zipfile.ZipFile(args.apk, "r") as z:
        for dex_name, class_names in dex_batches.items():
            print(f"\n--- Loading and analyzing {dex_name} ({len(class_names)} target classes in this batch) ---")
            dex_data = z.read(dex_name)
            dex = DEX(dex_data)
            analysis = Analysis(dex)
            dex.set_analysis(analysis)
            decompiler = DecompilerDAD(dex, analysis)

            for cname in class_names:
                # Format relative path: Lcom/smart/app/Main; -> com/smart/app/Main.java
                clean_pkg = cname.lstrip("L").rstrip(";")
                parts = clean_pkg.split("/")
                filename = parts[-1].replace("$", "_") + ".java"
                pkg_dir = os.path.join(args.output, *parts[:-1]) if len(parts) > 1 else args.output
                os.makedirs(pkg_dir, exist_ok=True)
                out_path = os.path.join(pkg_dir, filename)

                try:
                    cls_obj = dex.get_class(cname)
                    if not cls_obj:
                        print(f"  [MISSING] {cname}")
                        checkpoint.setdefault("failed", []).append(cname)
                        fail_count += 1
                        continue

                    source = decompiler.get_source_class(cls_obj)
                    with open(out_path, "w", encoding="utf-8") as f:
                        f.write(source)
                    
                    print(f"  [OK] {cname} -> {out_path}")
                    checkpoint.setdefault("decompiled", []).append(cname)
                    success_count += 1
                except Exception as e:
                    print(f"  [FAIL] {cname}: {e}")
                    checkpoint.setdefault("failed", []).append(cname)
                    fail_count += 1

            # Save checkpoint after each DEX
            save_checkpoint(args.output, checkpoint)

    print(f"\nBatch completed: {success_count} succeeded, {fail_count} failed.")
    total_decompiled = len(checkpoint.get("decompiled", []))
    print(f"Total decompiled so far: {total_decompiled} / {len(candidates)}")
    print(f"Next batch can be run with the same command!")

if __name__ == "__main__":
    main()
