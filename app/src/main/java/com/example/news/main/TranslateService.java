package com.example.news.main;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TranslateService {

    @GET("translate")
    Call<WorkBean> translate(@Query("doctype")String doctype,@Query("type")String type,@Query("i")String i);

}
