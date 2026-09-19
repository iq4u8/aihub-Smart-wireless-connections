package com.smart.app;
final class DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl$SwitchingProvider implements javax.inject.Provider {
    private final com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl a;
    private final int b;

    DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl$SwitchingProvider(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl p1, int p2)
    {
        this.a = p1;
        this.b = p2;
        return;
    }

    public Object get()
    {
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
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
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
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
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        switch (this.b) {
            case 0:
                return com.thingclips.smart.device.net.usecase.provider.UsecaseProvider_ProviderNetSettingUsecaseFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.J(this.a));
            case 1:
                return com.thingclips.smart.device.offlinereminder.usecase.api.di.provider.DispatcherProvider_ProviderIoDispatcherFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.K(this.a));
            case 2:
                return com.thingclips.smart.device.offlinereminder.usecase.provider.UsecaseProvider_ProviderOfflineReminderUsecaseFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.L(this.a), ((com.thingclips.smart.device.offlinereminder.usecase.api.repository.IOfflineReminderRepository) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.M(this.a).get()));
            case 3:
                return com.thingclips.smart.device.offlinereminder.data.provider.RepositoryProvider_ProviderOfflineReminderRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.N(this.a), new com.thingclips.smart.device.offlinereminder.data.OfflineBusiness());
            case 4:
                return com.thingclips.smart.scene.core.di.AppModule_ProvidesApplicationScopeFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.W(this.a));
            case 5:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProviderPreferenceStorageFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a));
            case 6:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideSceneRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()), ((com.thingclips.smart.scene.repository.db.SceneDataBase) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.Q(this.a).get()), dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.H(this.a)), ((com.thingclips.smart.scene.pedestal.repo.api.ScenePedestalRepository) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.R(this.a).get()));
            case 7:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideSceneServiceFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a));
            case 8:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideSceneDbFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.H(this.a)));
            case 9:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideScenePedestalRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()), ((com.thingclips.smart.scene.repository.db.SceneDataBase) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.Q(this.a).get()), dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.H(this.a)));
            case 10:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideEditScenePedestalRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a));
            case 11:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideEditSceneRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.pedestal.repo.api.EditScenePedestalRepository) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.S(this.a).get()));
            case 12:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideDeviceRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()), ((com.thingclips.smart.scene.source.DeviceDataSource) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.T(this.a).get()));
            case 13:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideDeviceDataSourceFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a));
            case 14:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideRecommendRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()));
            case 15:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideConditionRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()), ((com.thingclips.smart.scene.repository.db.SceneDataBase) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.Q(this.a).get()));
            case 16:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideFamilyRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.repository.db.SceneDataBase) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.Q(this.a).get()));
            case 17:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideActionRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()));
            case 18:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideExtRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()));
            case 19:
                return new com.thingclips.smart.light.scene.core.repository.DefaultLightSceneDimmingRepository();
            case 20:
                return com.thingclips.smart.scene.repository.di.RepositoryModule_ProvideLogRepositoryFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.P(this.a), ((com.thingclips.smart.scene.api.ISceneService) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.g0(this.a).get()), ((com.thingclips.smart.scene.repository.db.SceneDataBase) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.Q(this.a).get()));
            case 21:
                return new com.thingclips.smart.light.scene.core.repository.DefaultLightSceneLocationRepository();
            case 22:
                return new com.thingclips.smart.light.scene.core.repository.DefaultLightSceneIconRepository(((kotlinx.coroutines.CoroutineScope) com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.U(this.a).get()));
            case 23:
                return com.thingclips.smart.light.scene.core.di.CoroutinesModule_ProvidesCoroutineScopeFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.V(this.a), com.thingclips.smart.light.scene.core.di.CoroutinesModule_ProvidesDefaultDispatcherFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.V(this.a)));
            case 24:
                return new com.thingclips.smart.light.scene.core.repository.DefaultLightSceneVasRepository();
            case 25:
                return new com.thingclips.smart.light.scene.core.repository.DefaultLightSceneRoomRepository(com.thingclips.smart.light.scene.core.di.CoroutinesModule_ProvidesDefaultDispatcherFactory.b(com.smart.app.DaggerSmartApplication_HiltComponents_SingletonC$SingletonCImpl.V(this.a)));
            case 26:
                return new com.thingclips.smart.light.scene.core.repository.DefaultLightSceneDetailRepository();
            case 27:
                return new com.thingclips.smart.light.scene.core.repository.DefaultLightSceneRhythmRepository();
            default:
                throw new AssertionError(this.b);
        }
    }
}
