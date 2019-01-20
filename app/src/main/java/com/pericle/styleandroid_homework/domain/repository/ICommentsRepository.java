package com.pericle.styleandroid_homework.domain.repository;

import com.pericle.styleandroid_homework.presentation.presenter.ICommentsCallback;

public interface ICommentsRepository {
    void sendRequest(int postId, ICommentsCallback iCommentsCallback);
}
