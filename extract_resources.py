import os
import zipfile
import sys
from loguru import logger
logger.remove()

from androguard.core.apk import APK
from lxml import etree

apk_path = 'DigiTap.apk'
output_dir = 'decompiled_output'

if not os.path.exists(apk_path):
    print(f"Error: {apk_path} not found!")
    sys.exit(1)

os.makedirs(output_dir, exist_ok=True)

print(f"Opening {apk_path} to check existing vs missing files...")

already_exists_count = 0
newly_extracted_count = 0
skipped_dex_count = 0

with zipfile.ZipFile(apk_path, 'r') as z:
    infolist = z.infolist()
    total_files = len(infolist)
    print(f"Total entries in APK: {total_files}")

    for idx, item in enumerate(infolist, 1):
        filename = item.filename
        
        # Skip directories
        if item.is_dir() or filename.endswith('/'):
            continue
            
        target_path = os.path.join(output_dir, filename.replace('/', os.sep))
        
        # Check if file already extracted
        if os.path.exists(target_path):
            already_exists_count += 1
            continue
            
        # Ensure parent directory exists
        os.makedirs(os.path.dirname(target_path), exist_ok=True)
        
        # Extract the missing file
        try:
            with z.open(item) as source, open(target_path, 'wb') as target:
                target.write(source.read())
            newly_extracted_count += 1
            
            if newly_extracted_count % 500 == 0:
                print(f"  Extracted {newly_extracted_count} missing files... (progress: {idx}/{total_files})")
        except Exception as e:
            print(f"  Failed to extract {filename}: {e}")

print(f"\nExtraction summary:")
print(f"  Already existed on disk : {already_exists_count}")
print(f"  Newly extracted files   : {newly_extracted_count}")
print(f"  Total files in output   : {already_exists_count + newly_extracted_count}")

# Check AndroidManifest.xml
manifest_path = os.path.join(output_dir, 'AndroidManifest.xml')
if not os.path.exists(manifest_path) or os.path.getsize(manifest_path) == 0:
    print("\nDecoding AndroidManifest.xml to human-readable XML...")
    try:
        apk = APK(apk_path)
        manifest_xml_element = apk.get_android_manifest_xml()
        manifest_str = etree.tostring(manifest_xml_element, pretty_print=True, encoding='utf-8').decode('utf-8')
        with open(manifest_path, 'w', encoding='utf-8') as f:
            f.write(manifest_str)
        print(f"Successfully decoded AndroidManifest.xml -> {manifest_path}")
    except Exception as e:
        print(f"Error decoding manifest: {e}")
else:
    print(f"\nDecoded AndroidManifest.xml already present ({os.path.getsize(manifest_path)} bytes).")

print("\nAll missing files have been successfully added to decompiled_output!")
