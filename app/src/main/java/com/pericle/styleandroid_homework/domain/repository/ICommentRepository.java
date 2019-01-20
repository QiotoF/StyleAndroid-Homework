package com.pericle.styleandroid_homework.domain.repository;

import com.pericle.styleandroid_homework.presentation.callback.IShowCommentsCallback;

public interface ICommentRepository {
    void sendRequest(int postId, IShowCommentsCallback iShowCommentsCallback);
}
