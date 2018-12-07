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