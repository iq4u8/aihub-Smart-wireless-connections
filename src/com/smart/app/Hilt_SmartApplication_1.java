package com.smart.app;
 class Hilt_SmartApplication$1 implements dagger.hilt.android.internal.managers.ComponentSupplier {
    final synthetic com.smart.app.Hilt_SmartApplication a;

    Hilt_SmartApplication$1(com.smart.app.Hilt_SmartApplication p1)
    {
        this.a = p1;
        return;
    }

    public Object get()
    {
        return com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC.a().a(new dagger.hilt.android.internal.modules.ApplicationContextModule(this.a)).b();
    }
}
