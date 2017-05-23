package com.veryworks.android.calculator.util;

import android.util.Log;

import com.veryworks.android.calculator.BuildConfig;

/**
 * Created by pc on 5/23/2017.
 */

public class Logger {
    public static final boolean DEBUG = BuildConfig.DEBUG_MODE;

    public static void i(String tag, String msg){
        if(DEBUG) {
            Log.i(tag, msg);
        }
    }

    public static void d(String tag, String msg){
        if(DEBUG) {
            Log.d(tag, msg);
        }
    }

    public static void w(String tag, String msg){
        if(DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void e(String tag, String msg){
        if(DEBUG) {
            Log.e(tag, msg);
        }
    }

}
