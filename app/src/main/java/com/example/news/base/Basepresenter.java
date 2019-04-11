package com.example.news.base;

public class Basepresenter<V extends BaseView> {

    protected V view;

    public V getview(){
        return view;
    }

    //绑定view
    public void attachview(V view){
        this.view = view;
    }

    //解除view
    public void detachview(){
        this.view = null;
    }

    //判断是否绑定
    public boolean isAttavh(){
        return view != null;
    }

}
