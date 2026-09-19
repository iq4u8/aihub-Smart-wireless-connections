package com.smart.app;
public final class DaggerSmartApplication_HiltComponents_SingletonC$Builder {
    private com.thingclips.smart.scene.core.di.AppModule a;
    private dagger.hilt.android.internal.modules.ApplicationContextModule b;
    private com.thingclips.smart.light.scene.core.di.CoroutinesModule c;
    private com.thingclips.smart.device.offlinereminder.usecase.api.di.provider.DispatcherProvider d;
    private com.thingclips.smart.scene.repository.di.RepositoryModule e;
    private com.thingclips.smart.device.offlinereminder.data.provider.RepositoryProvider f;
    private com.thingclips.smart.device.net.usecase.provider.UsecaseProvider g;
    private com.thingclips.smart.device.offlinereminder.usecase.provider.UsecaseProvider h;

    private DaggerSmartApplication_HiltComponents_SingletonC$Builder()
    {
        return;
    }

    synthetic DaggerSmartApplication_HiltComponents_SingletonC$Builder(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$1 p1)
    {
        return;
    }

    public com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$Builder a(dagger.hilt.android.internal.modules.ApplicationContextModule p1)
    {
        this.b = ((dagger.hilt.android.internal.modules.ApplicationContextModule) dagger.internal.Preconditions.b(p1));
        return this;
    }

    public com.smart.app.SmartApplication_HiltComponents$SingletonC b()
    {
        if (this.a == null) {
            this.a = new com.thingclips.smart.scene.core.di.AppModule();
        }
        dagger.internal.Preconditions.a(this.b, dagger.hilt.android.internal.modules.ApplicationContextModule);
        if (this.c == null) {
            this.c = new com.thingclips.smart.light.scene.core.di.CoroutinesModule();
        }
        if (this.d == null) {
            this.d = new com.thingclips.smart.device.offlinereminder.usecase.api.di.provider.DispatcherProvider();
        }
        if (this.e == null) {
            this.e = new com.thingclips.smart.scene.repository.di.RepositoryModule();
        }
        if (this.f == null) {
            this.f = new com.thingclips.smart.device.offlinereminder.data.provider.RepositoryProvider();
        }
        if (this.g == null) {
            this.g = new com.thingclips.smart.device.net.usecase.provider.UsecaseProvider();
        }
        if (this.h == null) {
            this.h = new com.thingclips.smart.device.offlinereminder.usecase.provider.UsecaseProvider();
        }
        com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl v0_20 = new com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl;
        v0_20(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, 0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        return v0_20;
    }
}
