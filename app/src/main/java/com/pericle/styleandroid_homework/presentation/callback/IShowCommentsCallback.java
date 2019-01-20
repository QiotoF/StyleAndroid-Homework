package com.pericle.styleandroid_homework.presentation.callback;

import com.pericle.styleandroid_homework.domain.entity.CommentModel;

import java.util.List;

public interface IShowCommentsCallback {
    void showCommentsCallback(List<CommentModel> list);
}
