package com.pericle.styleandroid_homework.presentation.presenter;

import com.pericle.styleandroid_homework.domain.entity.CommentModel;

import java.util.List;

public interface ICommentsCallback {
    void showComments(List<CommentModel> list);
}
