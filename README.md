# Killing Specific Process Introduction

Note: Regarding java package creation and usage, please refer to [the Guideline](https://github.com/picoxr/support/blob/master/How_to_use_JAR_file_in_Unity_project_on_Pico_device.docx)

## Introduction  
This demo shows how to kill a specific process

## Class Name  
```
android.name="com.picovr.killapplication.MainActivity"
```

## Permission  
add sharedUserId property in manifest 
```
android:sharedUserId="android.uid.system"
```

## Interface  
```
void killapp(String pkgName)
```

## Note
This demo requires system signature. About how to sign a apk, you can refer to this [Customize Launcher on Pico Device](https://github.com/picoxr/support/blob/master/Customize%20Launcher%20on%20Pico%20Device.docx?raw=true).


