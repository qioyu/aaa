package com.example.news.base;

public interface BaseCallback<D> {

    void  onSuccess(D data);


    void onFailure(String message);

}
