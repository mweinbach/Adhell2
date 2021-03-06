package com.fiendfyre.AdHell2.dagger.module;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;

import com.fiendfyre.AdHell2.dagger.scope.AdhellApplicationScope;
import com.fiendfyre.AdHell2.receiver.CustomDeviceAdminReceiver;

import dagger.Module;
import dagger.Provides;

@Module(includes = {AppModule.class})
public class AdminModule {
    @Provides
    @AdhellApplicationScope
    DevicePolicyManager providesDevicePolicyManager(Context appContext) {
        return (DevicePolicyManager) appContext.getSystemService(Context.DEVICE_POLICY_SERVICE);
    }

    @Provides
    @AdhellApplicationScope
    ComponentName providesComponentName(Context appContext) {
        return new ComponentName(appContext, CustomDeviceAdminReceiver.class);
    }
}
