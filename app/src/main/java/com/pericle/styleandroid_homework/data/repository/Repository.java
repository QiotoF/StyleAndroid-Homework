package com.pericle.styleandroid_homework.data.repository;

import android.widget.Toast;

import com.pericle.styleandroid_homework.App;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.domain.repository.IRepository;
import com.pericle.styleandroid_homework.presentation.MainActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository implements IRepository {

    List<PostModel> posts;

    @Override
    public List<PostModel> someFun() {
        App.getApi().getData().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List< PostModel >> call, Response<List<PostModel>> response) {
                posts = response.body();
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {
                t.printStackTrace();
                posts = null;
            }
        });

        return posts;
    }



}
