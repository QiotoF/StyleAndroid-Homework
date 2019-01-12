package com.pericle.styleandroid_homework;

import android.app.Application;
import android.net.NetworkInfo;

import com.pericle.styleandroid_homework.data.api.NetworkApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static NetworkApi networkApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        networkApi = retrofit.create(NetworkApi.class);
    }

    public static NetworkApi getApi() {
        return networkApi;
    }

}
