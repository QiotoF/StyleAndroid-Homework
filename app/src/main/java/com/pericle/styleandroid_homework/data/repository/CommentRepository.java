package com.pericle.styleandroid_homework.data.repository;

import android.support.annotation.NonNull;

import com.pericle.styleandroid_homework.data.api.NetworkApi;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;
import com.pericle.styleandroid_homework.domain.repository.ICommentRepository;
import com.pericle.styleandroid_homework.presentation.callback.IShowCommentsCallback;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentRepository implements ICommentRepository {

    @Inject
    NetworkApi networkApi;

    @Inject
    public CommentRepository() {

    }

    @Override
    public void sendRequest(int postId, final IShowCommentsCallback iShowCommentsCallback) {
        networkApi.getComments(postId).enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(@NonNull Call<List<CommentModel>> call, @NonNull Response<List<CommentModel>> response) {
                iShowCommentsCallback.showCommentsCallback(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<List<CommentModel>> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
