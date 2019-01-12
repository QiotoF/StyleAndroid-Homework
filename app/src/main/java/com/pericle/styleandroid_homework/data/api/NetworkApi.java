package com.pericle.styleandroid_homework.data.api;

import com.pericle.styleandroid_homework.data.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NetworkApi {

    @GET("/posts")
    Call<List<PostModel>> getData();

}
