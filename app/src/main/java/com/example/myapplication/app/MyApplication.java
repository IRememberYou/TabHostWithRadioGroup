package com.example.myapplication.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by pinan on 2017/4/28.
 */

public class MyApplication extends Application {
    public static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
}
