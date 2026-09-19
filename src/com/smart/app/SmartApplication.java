package com.smart.app;
public class SmartApplication extends com.smart.app.Hilt_SmartApplication {

    public SmartApplication()
    {
        return;
    }

    private String c(android.content.Context p4)
    {
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
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        try {
            String v0_2 = p4.getPackageManager().getApplicationInfo(p4.getPackageName(), 128);
        } catch (android.content.pm.PackageManager$NameNotFoundException) {
            v0_2 = 0;
        }
        String v0_4;
        if (v0_2 != null) {
            v0_4 = v0_2.metaData.getString("UMENG_CHANNEL");
        } else {
            v0_4 = this.getResources().getString(2131951619);
        }
        try {
            if (p4.getResources().getBoolean(2131034194)) {
                v0_4 = "hw_international";
            }
        } catch (android.content.res.Resources$NotFoundException) {
        }
        return v0_4;
    }

    private void d()
    {
        com.thingclips.smart.initializer.ResourceInitializer.a(this, 2132017431, 2131232190, 2131232189, 2131956039, 2131956038);
        com.thingclips.smart.initializer.ResourceInitializer.b(this, 2131957249, 2131957254, 2131957252, 2131957253, com.thingclips.smart.utils.ResourceUtils.a(this, 2131101105), com.thingclips.smart.utils.ResourceUtils.a(this, 2131101556));
        return;
    }

    private void e()
    {
        com.thingclips.smart.android.network.ThingSmartNetWork.mSdk = 1;
        com.thingclips.smart.android.network.ThingSmartNetWork.mNTY = 0;
        com.thingclips.smart.android.network.ThingSmartNetWork.mSecurity = 1;
        com.thingclips.smart.android.network.ThingSmartNetWork.setNeutralDomainSwitch(1);
        boolean v2_4 = this.getResources().getIdentifier("managementWay", "integer", this.getPackageName());
        if ((v2_4) && (this.getResources().getInteger(v2_4) == 3)) {
            com.thingclips.smart.android.network.ThingSmartNetWork.useHttpsDns = 0;
        }
        String v5_2;
        String v6;
        com.thingclips.smart.android.base.ThingSmartSdk.init(this);
        com.thingclips.smart.android.base.ThingSmartSdk.setLocationSwitch(0);
        com.thingclips.stencil.app.ApiConfig v7 = com.thingclips.smart.initializer.AppInitializer.b(0, this);
        if (v7.a() != com.thingclips.stencil.app.ApiConfig$EnvConfig.DAILY) {
            v5_2 = "y8jmjg9xv34sw7krxarj";
            v6 = "awhyjan3v3kxq9aa8srdtq5wm4pj4gny";
        } else {
            com.thingclips.smart.android.network.ThingSmartNetWork.mD = 1;
            com.thingclips.smart.android.network.ThingSmartNetWork.mNTY = 0;
            v5_2 = "";
            v6 = "";
        }
        com.thingclips.smart.android.network.ThingSmartNetWork.setThingSmartNetWorkConfig(new com.thingclips.smart.android.network.request.ThingSmartNetWorkConfig$Builder().businessExecutor(com.thingclips.smart.asynclib.schedulers.ThreadEnv.c(4, "networkBizThreadPool")).netWorkExecutor(com.thingclips.smart.asynclib.schedulers.ThreadEnv.h()).supportSSLPinning(this.getResources().getBoolean(2131034340)).build());
        com.thingclips.smart.initializer.AppInitializer.c(this, v5_2, v6, v7, this.getString(2131951883), this.c(this), 0);
        com.thingclips.smart.dynamicrouter.DynamicRouter.init(this, new com.thingclips.smart.dynamicrouter.DynamicRouter$Config$Builder().log(com.thingclips.stencil.app.GlobalConfig.a).build());
        boolean v2_22 = new java.util.HashSet();
        String v3_17 = ((com.thingclips.smart.api.loginapi.LoginGuideService) com.thingclips.smart.api.MicroContext.a(com.thingclips.smart.api.loginapi.LoginGuideService.getName()));
        if (v3_17 == null) {
            v2_22.add(com.thingclips.smart.login.base.activity.GuideActivity.getName());
        } else {
            v2_22.add(v3_17.Z1());
        }
        v2_22.add(com.thingclips.smart.hometab.activity.FamilyHomeActivity.getName());
        com.thingclips.app.AppGuarder.a().b(this, com.thingclips.app.AppGuarderConfig.f(v2_22));
        boolean v2_2 = this.getResources().getIdentifier("ap_encrypted_only", "bool", this.getPackageName());
        if (v2_2) {
            com.thingclips.smart.android.base.utils.PreferencesUtil.set("is_ap_config_encrypt", this.getResources().getBoolean(v2_2));
        }
        com.thingclips.smart.android.network.ThingSmartNetWork.setDeviceCacheOpen(1);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
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
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
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
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
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
        com.ai.ct.Tz.b(0);
        return;
    }

    public void attachBaseContext(android.content.Context p1)
    {
        super.attachBaseContext(com.thingclips.smart.dynamic.resource.DynamicResource.m(p1));
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
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        return;
    }

    public android.content.Context getBaseContext()
    {
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        return com.thingclips.smart.dynamic.resource.DynamicResource.c();
    }

    public void onCreate()
    {
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
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.b(0);
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
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        com.ai.ct.Tz.a();
        com.ai.ct.Tz.b(0);
        super.onCreate();
        if (!com.smart.app.MultiProcessInit.b(this)) {
            com.thingclips.smart.crashcaught.thing.SmartCrashReportInit.startInitApp(this, 0);
            com.thingclips.check.SecretToolUtil.n(this);
            com.thingclips.smart.android.thirdparty.duck.ThirdPartyTool.digSource(this);
            this.e();
            this.d();
            com.thingclips.smart.crashcaught.thing.SmartCrashReportInit.endInitApp();
            return;
        } else {
            return;
        }
    }
}
