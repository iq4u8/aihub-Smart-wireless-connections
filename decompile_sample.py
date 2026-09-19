import os
import sys
from loguru import logger
logger.remove()
logger.add(sys.stderr, level='WARNING')

from androguard.core.apk import APK
from androguard.core.dex import DEX
from androguard.core.analysis.analysis import Analysis
from androguard.decompiler.decompiler import DecompilerDAD

apk_path = 'DigiTap.apk'
output_dir = 'decompiled_sample'
if not os.path.exists(output_dir):
    os.makedirs(output_dir)

print('Loading APK:', apk_path)
apk = APK(apk_path)
print('Package:', apk.get_package())
print('Main Activity:', apk.get_main_activity())
dex_blobs = list(apk.get_all_dex())
print('Dex count:', len(dex_blobs))
for idx, blob in enumerate(dex_blobs):
    print(f' dex[{idx}] size = {len(blob)}')

if not dex_blobs:
    raise SystemExit('No dex files found')

first_dex = dex_blobs[0]
print('Parsing first DEX...')
dex = DEX(first_dex)
classes = [c.get_name() for c in dex.get_classes()]
print('Classes in first DEX:', len(classes))
with open(os.path.join(output_dir, 'first_dex_class_list.txt'), 'w', encoding='utf-8') as f:
    f.write('\n'.join(classes))

print('Analyzing first DEX...')
analysis = Analysis(dex)
print('Analysis complete')

dex.set_analysis(analysis)

print('Decompiling sample classes...')
decompiler = DecompilerDAD(dex, analysis)
for i, class_name in enumerate(classes[:5]):
    safe_name = class_name.strip('/').replace('/', '.').replace(';', '')
    safe_name = safe_name.replace('<', '').replace('>', '').replace('$', '_')
    out_path = os.path.join(output_dir, f'sample_{i}_{safe_name}.java')
    try:
        cls = dex.get_class(class_name)
        if cls is None:
            print('Class not found:', class_name)
            continue
        source = decompiler.get_source_class(cls)
        with open(out_path, 'w', encoding='utf-8') as f:
            f.write(source)
        print('Decompiled:', class_name, '->', out_path)
    except Exception as e:
        print('Failed to decompile', class_name, e)

print('Output written to', os.path.abspath(output_dir))
