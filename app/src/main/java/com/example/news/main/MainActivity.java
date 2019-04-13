package com.example.news.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.news.R;
import com.example.news.base.MvpActivity;

public class MainActivity extends MvpActivity<MainView,MainPresenter,WorkBean> implements MainView{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter.translate("json","auto","神经病");
    }

    @Override
    protected MainPresenter createpresenter() {
        return new MainPresenter();
    }


    @Override
    public void onSuccess(WorkBean data) {
        String tgt = data.getTranslateResult().get(0).get(0).getTgt();
        Toast.makeText(this, tgt, Toast.LENGTH_SHORT).show();
        Log.e( "----: ",tgt );
    }

    @Override
    public void onFailure(String message) {
        Log.e( "----: ",message );
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
