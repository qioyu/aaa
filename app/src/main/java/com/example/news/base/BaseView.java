package com.example.news.base;

public interface BaseView<D> {

    void  onSuccess(D data);


    void onFailure(String message);
}
