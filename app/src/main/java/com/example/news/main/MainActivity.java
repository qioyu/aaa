package com.example.news.main;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.news.R;
import com.example.news.main.Service.SmmsService;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okhttp3.internal.http.RealResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private long lasttime = 0;
    private NavigationView navigationView;
    ImageView ima;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        View headerView = navigationView.getHeaderView(0);
        ima = headerView.findViewById(R.id.ima);
        ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            Uri uri = data.getData();
            ContentResolver resolver = getContentResolver();
            Cursor query = resolver.query(uri, null, null, null, null);
            query.moveToFirst();
            String path = query.getString(query.getColumnIndex("_data"));
            System.out.println(path);
            upload(path);
            query.close();


        }
    }

    private void upload(String path) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://sm.ms/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        SmmsService service = retrofit.create(SmmsService.class);

        MediaType type_tv = MediaType.parse("multipart/form-data");

        RequestBody smfile = RequestBody.create(type_tv, "json");

        MediaType type_ima = MediaType.parse("application/otcet-stream");
        File f = new File(path);
        RequestBody requestBody = RequestBody.create(type_ima, f);
        MultipartBody.Part file = MultipartBody.Part.createFormData("smfile", f.getName(), requestBody);

        Call<Avatar_Bean> getcall = service.getcall(smfile, file);
        getcall.enqueue(new Callback<Avatar_Bean>() {
            @Override
            public void onResponse(Call<Avatar_Bean> call, Response<Avatar_Bean> response) {
                System.out.println(response.code());
                if (response.isSuccessful()) {
                    System.out.println(response.body());
                    String url = response.body().getData().getUrl();
                    Glide.with(context).load(url).into(ima);
//                    ima.setImageURI(Uri.parse(url));
                }

            }

            @Override
            public void onFailure(Call<Avatar_Bean> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

    private void initView() {
        navigationView = (NavigationView) findViewById(R.id.navigationView);
    }

    //手机点返回键吐司，再按一次与上一次间隔大于2秒在吐司，小于2秒就直接退出
    @Override
    public void onBackPressed() {
        long currenttime = System.currentTimeMillis();
        if (currenttime - lasttime > 2000) {
            Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
            lasttime = currenttime;
        } else {
            super.onBackPressed();
        }
    }
}
