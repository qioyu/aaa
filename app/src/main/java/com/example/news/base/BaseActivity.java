package com.example.news.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

public abstract class BaseActivity<V extends BaseView,P extends Basepresenter<V>,D> extends FragmentActivity implements BaseView<D> {

    protected P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createpresenter();
        presenter.attachview((V) this);
    }

    protected abstract P createpresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachview();
    }
}
