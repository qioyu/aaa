package com.example.news.utils;

import android.content.Context;

public class ContentHelper  {

    private static Context context;

    public static void setContext(Context context){
        ContentHelper.context = context.getApplicationContext();
    }

    /** 获取ApplicationContext对象； */
    public static Context getContext(){
        return context;
    }
}
