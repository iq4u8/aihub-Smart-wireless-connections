package com.smart.app;
final class DaggerSmartApplication_HiltComponents_SingletonC$ActivityRetainedCImpl$SwitchingProvider implements javax.inject.Provider {
    private final com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl a;
    private final com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$ActivityRetainedCImpl b;
    private final int c;

    DaggerSmartApplication_HiltComponents_SingletonC$ActivityRetainedCImpl$SwitchingProvider(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl p1, com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$ActivityRetainedCImpl p2, int p3)
    {
        this.a = p1;
        this.b = p2;
        this.c = p3;
        return;
    }

    public Object get()
    {
        if (this.c != 0) {
            throw new AssertionError(this.c);
        } else {
            return dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_Lifecycle_Factory.b();
        }
    }
}
