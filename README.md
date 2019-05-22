# Killing Specific Process Introduction

JAR file, demo APK are in /resource.    
Note: Regarding java package creation and usage, please refer to [the Guideline](https://github.com/picoxr/support/blob/master/How%20to%20Use%20JAR%20file%20in%20Unity%20project%20on%20Pico%20device.docx)

## Introduction  
This demo shows how to kill a specific process.

## Class Name  
```
com.picovr.killapplication.KillAppClass
```

## Permission 
Add shardUserId property: 
```
android:sharedUserId="android.uid.system"
```
![](https://github.com/picoxr/LauncherWebVR/blob/master/01.png)

## Interface  
```
void killapp(String pkgName, Context context)
```

## Sample Code
```
AndroidJavaObject killApp = new AndroidJavaObject("com.picovr.killapplication.KillAppClass");
AndroidJavaObject context = new AndroidJavaClass("com.unity3d.player.UnityPlayer").GetStatic<AndroidJavaObject>("currentActivity");

killApp.Call("killapp", "com.picovr.store", context);
```

## Note
This demo requires system signature. About how to sign a apk, you can refer to this [Customize Launcher on Pico Device](https://github.com/picoxr/support/blob/master/Customize%20Launcher%20on%20Pico%20Device.docx?raw=true).


