package com.picovr.killapplication;


import java.lang.reflect.Method;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity {

    private static final String TAG = "KillAppActivity";
    private static final String PACKAGENAME = "com.picovr.gallery";
    private static int pid = -1;
//		setprop picovr.factorytest.cmd


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void killapp(String pkgName) {
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> mRunningProcess = am.getRunningAppProcesses();
        Log.e(TAG, mRunningProcess.size() + " ");
        for (ActivityManager.RunningAppProcessInfo amProcess : mRunningProcess) {
            Log.e(TAG, amProcess.processName);
            Log.e(TAG, "pid:" + amProcess.pid);
            if (amProcess.processName.equals(pkgName)) {
                pid = amProcess.pid;
                break;
            }
        }

        Log.e(TAG, "picovr.factorytest.cmd" + "kill " + pid);

        setSystemProperties("picovr.factorytest.cmd", "kill " + pid);

    }
    public void killAPPClick(View view){
        killapp(PACKAGENAME);
    }

    public static void setSystemProperties(String key, String value) {
        try {
            final Class<?> systemProperties = Class.forName("android.os.SystemProperties");
            final Method set = systemProperties.getMethod("set", String.class,
                    String.class);
            set.invoke(null, key, value);
//            LogUtils.i("setSystemProperties--->key=" + key + " value=" + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
