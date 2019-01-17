# Killing Specific Process Introduction

Note: Regarding java package creation and usage, please refer to [the Guideline](https://github.com/picoxr/support/blob/master/How_to_use_JAR_file_in_Unity_project_on_Pico_device.docx)

## Introduction  
This demo shows how to kill a specific process

## Class Name  
android.name="com.picovr.killapplication.MainActivity"

## Permission  
add``android:sharedUserId="android.uid.system"``in manifest node.

## Interface  
```
void killapp(String pkgName)
```


