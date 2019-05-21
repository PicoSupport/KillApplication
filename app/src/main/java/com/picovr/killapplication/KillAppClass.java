package com.picovr.killapplication;

import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.lang.reflect.Method;
import java.util.List;

public class KillAppClass {
    private static final String TAG = "KillAppClass";
    private static int pid = -1;

    /**
     * Kill specific app.
     * @param pkgName The package name of app to kill. eg: com.picovr.store
     * @param context Context
     */
    public void killApp(String pkgName, Context context) {
        Log.e(TAG, "killapp: ");
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> mRunningProcess = am.getRunningAppProcesses();
        Log.e(TAG, mRunningProcess.size() + "");
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

    public static void setSystemProperties(String key, String value) {
        try {
            final Class<?> systemProperties = Class.forName("android.os.SystemProperties");
            final Method set = systemProperties.getMethod("set", String.class,
                    String.class);
            set.invoke(null, key, value);
            Log.e(TAG, "setSystemProperties--->key=" + key + " value=" + value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
