package com.pericle.styleandroid_homework.domain.interactor;

import com.pericle.styleandroid_homework.data.repository.CommentRepository;
import com.pericle.styleandroid_homework.presentation.callback.IShowCommentsCallback;

import javax.inject.Inject;

public class CommentInteractor {

    @Inject
    public CommentRepository mRepository;

    @Inject
    public CommentInteractor() {
//        mRepository = new CommentRepository();
    }

    public void sendRequest(int postId, IShowCommentsCallback iShowCommentsCallback) {
        mRepository.sendRequest(postId, iShowCommentsCallback);
    }

}
