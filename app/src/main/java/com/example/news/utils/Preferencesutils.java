package com.example.news.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencesutils {


    /**
     *从SharedPreferences获取boolean的值
     */
    public static boolean getboolean(String key, boolean defaultValue){
        Context context = ContentHelper.getContext();
        SharedPreferences sp = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
        boolean values = sp.getBoolean(key, defaultValue);
        return values;
    }

    public static boolean putBoolean(String key,boolean values){
        Context context = ContentHelper.getContext();
        SharedPreferences sp = context.getSharedPreferences(context.getPackageName(),Context.MODE_PRIVATE);
        return sp.edit().putBoolean(key,values).commit();
    }
}
