package com.example.kkbox;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRequst {

    public static RetrofitRequst mInstance = new RetrofitRequst();
    Song songs = null;
    RetrofitInterface retrofitInterface;

    public RetrofitRequst()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitInterface.base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitInterface = retrofit.create(RetrofitInterface.class);
    }
    public static RetrofitRequst getInstance()
    {
        if(mInstance == null)
            mInstance = new RetrofitRequst();
        return mInstance;
    }

    public RetrofitInterface getRetrofitInterface() {
        return retrofitInterface;
    }


}
