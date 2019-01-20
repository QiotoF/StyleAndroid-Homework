package com.pericle.styleandroid_homework.data.api;

import com.pericle.styleandroid_homework.domain.entity.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface NetworkApi {

    @GET("/posts")
    Call<List<PostModel>> getData();

    @POST("/posts")
    Call<PostModel> postData(@Body PostModel post);

}
