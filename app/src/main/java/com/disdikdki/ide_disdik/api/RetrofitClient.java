package com.disdikdki.ide_disdik.api;

//import com.disdikdki.ide_disdik.api.SharedPrefManager;
import okhttp3.Cache;
import okhttp3.CacheControl;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.sidebar.pusdatikomdik.id/ide/";
    private static RetrofitClient mInstance;
    private Retrofit retrofit;

    private RetrofitClient(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .addInterceptor(chain -> {
                    Request original = chain.request();
                    Request.Builder builder = original.newBuilder().method(original.method(), original.body());
                    builder.header("Accept", "application/json");
//                    if (!SharedPrefManager.getInstance(context).getStr("token").equals("null")) {
//                        builder.header("Authorization", SharedPrefManager.getInstance(context).getStr("token"));
//                    }
                    return chain.proceed(builder.build());
                })
                .build();

        return client;
    }


    public static synchronized RetrofitClient getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitClient();
        }
        return mInstance;
    }

    public BaseApi getAPI(){
        return retrofit.create(BaseApi.class);
    }

}
