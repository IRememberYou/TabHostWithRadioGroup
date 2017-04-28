package com.example.myapplication.utils;

import android.widget.Toast;

import com.example.myapplication.app.MyApplication;

/**
 * Created by pinan on 2017/4/28.
 */

public class ToastUtil {
    public static void show(String message) {
        Toast.makeText(MyApplication.sContext,message,Toast.LENGTH_SHORT).show();
    }
}
