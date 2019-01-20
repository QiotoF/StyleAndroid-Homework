package com.pericle.styleandroid_homework;

import android.app.Application;

import com.pericle.styleandroid_homework.data.api.NetworkApi;
import com.pericle.styleandroid_homework.di.AppComponent;
import com.pericle.styleandroid_homework.di.DaggerAppComponent;

import retrofit2.Retrofit;

public class App extends Application {

    private static NetworkApi networkApi;
    private Retrofit retrofit;

    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    private void configureDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .context(this)
                .build();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        configureDagger();
/*
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client.build())
                .build();
        networkApi = retrofit.create(NetworkApi.class);*/
    }

//    public static NetworkApi getApi() {
////        return networkApi;
////    }

}
