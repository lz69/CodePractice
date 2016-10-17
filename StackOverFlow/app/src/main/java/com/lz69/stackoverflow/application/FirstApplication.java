package com.lz69.stackoverflow.application;

import android.app.Application;
import android.util.Log;

public class FirstApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("lz69", "first_application");
    }
}
