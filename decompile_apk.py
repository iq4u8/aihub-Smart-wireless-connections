from androguard.core.apk import APK
from androguard.misc import AnalyzeAPK
from androguard.decompiler.decompiler import DecompilerDAD
from loguru import logger
import os
import sys

logger.remove()
logger.add(sys.stderr, level='WARNING')

apk_path = 'DigiTap.apk'
output_dir = 'decompiled_output'
if not os.path.exists(output_dir):
    os.makedirs(output_dir)

print('Loading APK:', apk_path)
apk = APK(apk_path)
print('Package:', apk.get_package())
print('Main Activity:', apk.get_main_activity())
print('Activities:', len(list(apk.get_activities())))
print('Services:', len(list(apk.get_services())))
print('Receivers:', len(list(apk.get_receivers())))
print('Providers:', len(list(apk.get_providers())))
print('Permissions:', len(list(apk.get_permissions())))
dex_files = list(apk.get_all_dex())
print('Dex count:', len(dex_files))

app, dex_list, dx = AnalyzeAPK(apk_path)
print('Loaded DEX count:', len(dex_list))
print('Total classes:', sum(len(list(dex.get_classes())) for dex in dex_list))

# Write manifest info
manifest_info = [
    f'Package: {apk.get_package()}',
    f'MainActivity: {apk.get_main_activity()}',
    f'Activities: {apk.get_activities()}',
    f'Services: {apk.get_services()}',
    f'Receivers: {apk.get_receivers()}',
    f'Providers: {apk.get_providers()}',
    f'Permissions: {apk.get_permissions()}',
]
with open(os.path.join(output_dir, 'manifest_info.txt'), 'w', encoding='utf-8') as f:
    f.write('\n'.join(manifest_info))

# Save class list and decompile top classes
class_names = []
for dex in dex_list:
    for c in dex.get_classes():
        class_names.append(c.get_name())

with open(os.path.join(output_dir, 'class_list.txt'), 'w', encoding='utf-8') as f:
    f.write('\n'.join(class_names))

# Decompile a sample set of classes from the main dex and main activity classes
if dx is not None:
    # Choose a few classes to decompile
    targets = []
    main_cls = apk.get_main_activity()
    if main_cls:
        targets.append(main_cls)
    for name in class_names[:20]:
        if len(targets) >= 10:
            break
        targets.append(name)

    d = dex_list[0]
    print('Creating decompiler for DEX0...')
    decompiler = DecompilerDAD(d, dx)
    for name in targets:
        safe_name = name.strip('/').replace('/', '.').replace(';', '')
        safe_name = safe_name.replace('<', '').replace('>', '').replace('$', '_')
        out_path = os.path.join(output_dir, f'{safe_name}.java')
        try:
            cm = d.get_class(name)
            if cm is None:
                print('Class not found in DEX0:', name)
                continue
            source = decompiler.get_source_class(cm)
            with open(out_path, 'w', encoding='utf-8') as f:
                f.write(source)
            print('Decompiled:', name)
        except Exception as e:
            print('Failed to decompile', name, e)
else:
    print('DX analysis unavailable; skipping decompiler output.')

print('Output written to:', output_dir)
