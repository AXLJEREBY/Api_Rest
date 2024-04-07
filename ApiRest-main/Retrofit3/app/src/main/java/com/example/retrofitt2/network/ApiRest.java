package com.example.retrofitt2.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiRest {
    private static Retrofit retrofit;
    public static Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http:192.168.1.2//8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
