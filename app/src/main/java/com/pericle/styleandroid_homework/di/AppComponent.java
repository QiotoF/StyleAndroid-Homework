package com.pericle.styleandroid_homework.di;

import android.content.Context;

import com.pericle.styleandroid_homework.presentation.activity.CommentActivity;
import com.pericle.styleandroid_homework.presentation.activity.MainActivity;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
    void inject(CommentActivity commentActivity);

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder context(Context context);
    }
}
