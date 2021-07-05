package com.custom.kioskapp.kiosk;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/***************************************************************************************************
 *                                  Copyright (C), Nexgo Inc.                                      *
 *                                    http://www.nexgo.cn                                          *
 ***************************************************************************************************
 * date: 2021/5/21
 * author: bruce
 * description:
 ***************************************************************************************************/

public class AdminReceiver extends DeviceAdminReceiver {
    @Override
    public void onEnabled(@NonNull Context context, @NonNull Intent intent) {
        super.onEnabled(context, intent);
    }

    @Nullable
    @Override
    public CharSequence onDisableRequested(@NonNull Context context, @NonNull Intent intent) {
        return super.onDisableRequested(context, intent);
    }

    @Override
    public void onDisabled(@NonNull Context context, @NonNull Intent intent) {
        super.onDisabled(context, intent);
    }

    @Override
    public void onLockTaskModeEntering(@NonNull Context context, @NonNull Intent intent, @NonNull String pkg) {
        super.onLockTaskModeEntering(context, intent, pkg);
    }

    @Override
    public void onLockTaskModeExiting(@NonNull Context context, @NonNull Intent intent) {
        super.onLockTaskModeExiting(context, intent);
    }
}
