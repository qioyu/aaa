package com.example.news.main;

import com.example.news.base.BaseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel extends BaseModel {
    public void translate(String doctype, String type, String i, final MainCallback callback){
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://fanyi.youdao.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TranslateService service = retrofit.create(TranslateService.class);
        Call<WorkBean> call = service.translate(doctype, type, i);
        call.enqueue(new Callback<WorkBean>() {
            @Override
            public void onResponse(Call<WorkBean> call, Response<WorkBean> response) {
                if (callback!=null){
                    if (response.isSuccessful()){
                        WorkBean bean = response.body();
                        callback.onSuccess(bean);
                    }
                }else {
                    throw new NullPointerException("callback can not be null");
                }
            }

            @Override
            public void onFailure(Call<WorkBean> call, Throwable t) {
                if (callback != null){
                    callback.onFailure(t.getMessage());
                }else {
                    throw new NullPointerException("callback can not be null");
                }
            }
        });
    }
}
