package com.pericle.styleandroid_homework.data.api;

import com.pericle.styleandroid_homework.domain.entity.CommentModel;
import com.pericle.styleandroid_homework.domain.entity.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface NetworkApi {

    @GET("/posts")
    Call<List<PostModel>> getData();

    @GET("/posts/{id}/comments")
    Call<List<CommentModel>> getComments(@Path("id") int id);

    @POST("/posts")
    Call<PostModel> postData(@Body PostModel post);

}
