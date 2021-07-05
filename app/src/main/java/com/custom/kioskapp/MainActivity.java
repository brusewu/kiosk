package com.custom.kioskapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.custom.kioskapp.kiosk.AdminReceiver;

import java.io.DataOutputStream;

public class MainActivity extends AppCompatActivity {
    private DevicePolicyManager dpm;
    private boolean inKioskMode;
    private ComponentName deviceAdmin;
    private Process process = null;
    private DataOutputStream os = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lockScreen();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dislockScreen();
            }
        });


    }

    private boolean doLockScreen() {
        if (dpm.isLockTaskPermitted(this.getPackageName())) {
            Log.i("yunji.HotelAPP", "start lock screen");
            startLockTask();
            inKioskMode = true;
            Log.i("yunji.HotelAPP", "lock screen success");
            return true;
        }
        Log.w("yunji.HotelAPP", "cannot lock screen");
        return false;
    }

    private void lockScreen() {
        try {
            if (!inKioskMode) {
                dpm = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
                deviceAdmin = new ComponentName(this, AdminReceiver.class);
                Log.e("TAG", "isAdminActive: " + dpm.isAdminActive(deviceAdmin) + "\tisDeviceOwnerApp: " + dpm.isDeviceOwnerApp(getPackageName()));
                if (dpm.isDeviceOwnerApp(getPackageName())) {
                    //如果这里失效，请使用adb shell命令设置deviceOwnerAPP为当前app $ adb shell dpm set-device-owner com.honghe.screenlocktest/.AdminReceiver
                    //参考 https://juejin.im/entry/578f873dd342d30058e99c51
                    dpm.setLockTaskPackages(deviceAdmin,
                            new String[]{getPackageName()});
                    Log.e("TAG", "setLockTaskPackages: ");
                }
                doLockScreen();
            }
        } catch (Exception e) {
            Log.e("yunji.HotelAPP", "Exception: " + e);
        }
    }

    private void dislockScreen() {
        try {
            if (inKioskMode) {
                stopLockTask();
                inKioskMode = false;
            }
        } catch (Exception e) {
            Log.e("yunji.HotelAPP", "Exception: " + e);
        }
    }
}
