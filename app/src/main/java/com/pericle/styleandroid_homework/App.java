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

    @Override
    public void onCreate() {
        super.onCreate();

        configureDagger();
    }

    private void configureDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .context(this)
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

}
