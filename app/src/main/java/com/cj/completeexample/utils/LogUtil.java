package com.cj.completeexample.utils;

import android.text.TextUtils;
import android.util.Log;

import com.cj.completeexample.BuildConfig;

/**
 * Created by chenjing on 2017/6/30.
 */

public class LogUtil {

    private static final String LOG_TAG = "cjj";
    private static boolean DEBUG = BuildConfig.DEBUG;

    private LogUtil() {
    }

    public static void error(String log) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.e(LOG_TAG, "" + log);
    }

    public static void d(String log) {
        if (DEBUG && !TextUtils.isEmpty(log)) Log.d(LOG_TAG, log);
    }

    public static void log(String tag, String log) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.i(tag, log);
    }

    public static void d(String tag, String log) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.d(tag, log);
    }

    public static void e(String tag, String log) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.e(tag, log);
    }

    public static void i(String tag, String log) {
        if (DEBUG && !TextUtils.isEmpty(tag) && !TextUtils.isEmpty(log)) Log.i(tag, log);
    }
}
