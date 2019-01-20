package com.pericle.styleandroid_homework.data.repository;

import android.support.annotation.NonNull;

import com.pericle.styleandroid_homework.App;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.domain.repository.IPostRepository;
import com.pericle.styleandroid_homework.presentation.callback.INewPostCallback;
import com.pericle.styleandroid_homework.presentation.callback.IShowPostCallback;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostRepository implements IPostRepository {

    private List<PostModel> posts;
    private IShowPostCallback iShowPostCallback;
    private INewPostCallback mPostCallback;

    @Override
    public void showPosts(IShowPostCallback callback) {
        iShowPostCallback = callback;

        App.getApi().getData().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<PostModel>> call, @NonNull Response<List<PostModel>> response) {
                posts = response.body();
                iShowPostCallback.showPostCallback(posts);
            }

            @Override
            public void onFailure(@NonNull Call<List<PostModel>> call, @NonNull Throwable t) {
                t.printStackTrace();
                posts = new ArrayList<>();
            }
        });
    }

    @Override
    public void addPost(PostModel postModel, INewPostCallback iNewPostCallback) {
        mPostCallback = iNewPostCallback;

        App.getApi().postData(postModel).enqueue(new Callback<PostModel>() {
            @Override
            public void onResponse(@NonNull Call<PostModel> call, @NonNull Response<PostModel> response) {
                PostModel post = new PostModel();
                post.setTitle(response.body().getTitle());
                post.setBody(response.body().getBody());
                mPostCallback.newPostCallback(post);
            }

            @Override
            public void onFailure(@NonNull Call<PostModel> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
