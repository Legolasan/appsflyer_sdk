# appsflyer_sdk
1st commit- entire android project

I'm keep receiving error on building it. Below are files as mentioned in the support article:

**AndroidManifest.xml**

```java
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="com.arunsunderraj.appsflyer">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <!-- Optional : -->
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />


    <application
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/AppTheme">
        <receiver android:name="com.appsflyer.SingleInstallBroadcastReceiver" android:exported="true">
            <intent-filter>
                <action android:name="com.android.vending.INSTALL_REFERRER" />
            </intent-filter>
        </receiver>
        <activity android:name=".MainActivity">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>
```

**MainActivity.java**
```java
package com.arunsunderraj.appsflyer;

import android.support.v7.app.AppCompatActivity;

import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerConversionListener;

public class MainActivity extends AppCompatActivity {

    private static final String AF_DEV_KEY = "pAv7C56eg6z58sqgiGKxxg";
    @Override
    public void onCreate() {
        super.onCreate();
        AppsFlyerConversionListener conversionDataListener =
                new AppsFlyerConversionListener() {
                };
        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionDataListener, getApplicationContext());
        AppsFlyerLib.getInstance().startTracking(this);   }
}
```

**App**

```java
apply plugin: 'com.android.application'

android {
    compileSdkVersion 28
    defaultConfig {
        applicationId "com.arunsunderraj.appsflyer"
        minSdkVersion 26
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }
}

repositories {
    mavenCentral()
}


dependencies {
    implementation fileTree(include: ['*.jar'], dir: 'libs')
    implementation 'com.android.support:appcompat-v7:28.0.0'
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'

    implementation 'com.android.installreferrer:installreferrer:1.0'
    implementation files('/Users/arunsundarajan/Downloads/AF-Android-SDK.jar')
}
```


And I have uploaded the Appsflyer SDK into project path. Like I went into "Project Structure" and click on App -> Dependencies and added the sdk jar file as implementation. 

