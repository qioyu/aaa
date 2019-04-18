package com.example.news;

import android.app.Application;

import com.example.news.utils.ContentHelper;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ContentHelper.setContext(this);
    }
}
