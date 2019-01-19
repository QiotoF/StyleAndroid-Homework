package com.pericle.styleandroid_homework.data.repository;

import android.util.Log;

import com.pericle.styleandroid_homework.App;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.domain.repository.IRepository;
import com.pericle.styleandroid_homework.presentation.presenter.ICallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements IRepository {

    List<PostModel> posts;
    ICallback iCallback;

    @Override
    public void someFun(ICallback callback) {
        iCallback = callback;

        App.getApi().getData().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                Log.i("Repository", "onResponse");
                posts = response.body();

                if (posts == null)
                    Log.i("Repository", "nullInOnResponse");
                else
                    Log.i("Repository", "notNullOnResponse");

                iCallback.callback(posts);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                t.printStackTrace();
                Log.i("Repository", "onFailure");
                posts = new ArrayList<>();
            }
        });

        //return posts;
    }


}
