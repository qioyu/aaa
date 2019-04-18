package com.example.news.main.Service;

import com.example.news.main.Avatar_Bean;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface SmmsService {

    @Multipart
    @Headers("User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:66.0) Gecko/20100101 Firefox/66.0")
    @POST("https://sm.ms/api/upload")

    Call<Avatar_Bean> getcall(@Part("smfile") RequestBody smfile, @Part MultipartBody.Part file);
}
