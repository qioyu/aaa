package com.example.news.main;

import android.view.View;

import com.example.news.base.Basepresenter;
import com.example.news.base.ModelManager;

public class MainPresenter extends Basepresenter<MainView> {

    public void translate(String doctype, String type, String i){
        MainModel model = ModelManager.getInstance().getmodel(MainModel.class);
        model.translate(doctype, type, i, new MainCallback() {
            @Override
            public void onSuccess(WorkBean data) {
                if (isAttavh()){
                    view.onSuccess(data);
                }
            }

            @Override
            public void onFailure(String message) {
                if (isAttavh()){
                    view.onFailure(message);
                }
            }
        });


    }


}
