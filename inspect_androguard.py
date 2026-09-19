import sys
import androguard
import androguard.core as core
import androguard.decompiler as dec
print('androguard', androguard.__file__)
print('core', core.__file__)
print('dec', dec.__file__)
print('core package attrs:', [name for name in dir(core) if name in ['dex','bytecode','analysis','apk','axml']])
print('core module names:', [name for name in dir(core) if name.lower().startswith(('d','b','a'))][:100])
print('decompiler attrs:', [name for name in dir(dec) if 'Decompiler' in name or 'decompiler' in name.lower()][:50])
import inspect
for name in ['dalvik','dvm','Dex','DalvikVMFormat','DecompilerDAD','Decompiler']:
    try:
        obj = getattr(core, name)
        print('core has', name, obj)
    except Exception as e:
        print('core missing', name, type(e).__name__, e)
    try:
        obj = getattr(dec, name)
        print('dec has', name, obj)
    except Exception as e:
        print('dec missing', name, type(e).__name__, e)

import androguard.core.dex as dexmod
print('dexmod file', dexmod.__file__)
print('dexmod attrs', [name for name in dir(dexmod) if 'VM' in name or 'Dalvik' in name or 'Format' in name or 'Dex' in name][:100])
