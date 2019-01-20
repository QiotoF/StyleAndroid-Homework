package com.pericle.styleandroid_homework.domain.interactor;

import com.pericle.styleandroid_homework.data.repository.CommentsRepository;
import com.pericle.styleandroid_homework.presentation.presenter.ICommentsCallback;

public class CommentsInteractor {

    private CommentsRepository mRepository;

    public void sendRequest(int postId, ICommentsCallback iCommentsCallback) {
        mRepository = new CommentsRepository(); //TODO: initialize in costructor
        mRepository.sendRequest(postId, iCommentsCallback);
    }

}
