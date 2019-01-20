package com.pericle.styleandroid_homework.data.repository;

import com.pericle.styleandroid_homework.App;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;
import com.pericle.styleandroid_homework.domain.repository.ICommentsRepository;
import com.pericle.styleandroid_homework.presentation.presenter.ICommentsCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentsRepository implements ICommentsRepository {
    @Override
    public void sendRequest(int postId, final ICommentsCallback iCommentsCallback) {
        App.getApi().getComments(postId).enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                iCommentsCallback.showComments(response.body());
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {

            }
        });
    }
}
