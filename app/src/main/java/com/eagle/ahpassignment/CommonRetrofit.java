package com.eagle.ahpassignment;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommonRetrofit {
    static CommonRetrofit instance=null;
    static ApiInterface apiInterface;
    private CommonRetrofit(){
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/") // Replace with your API base URL
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        apiInterface = retrofit.create(ApiInterface.class);


    }
    public synchronized static CommonRetrofit getInstance(){
        if(instance==null){
            instance=new CommonRetrofit();
        }
        return instance;
    }
    public  ApiInterface getApiInterface(){
        return apiInterface;
    }
}
