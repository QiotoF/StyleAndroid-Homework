package com.pericle.styleandroid_homework.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;
import com.pericle.styleandroid_homework.domain.interactor.CommentInteractor;
import com.pericle.styleandroid_homework.presentation.callback.IShowCommentsCallback;
import com.pericle.styleandroid_homework.presentation.view.CommentView;

import java.util.List;

@InjectViewState
public class CommentPresenter extends MvpPresenter<CommentView> implements IShowCommentsCallback {

    private CommentInteractor mInteractor;

    public CommentPresenter() {
        mInteractor = new CommentInteractor();
    }

    public void sendRequest(int postId) {
        mInteractor.sendRequest(postId, this);
    }

    @Override
    public void showCommentsCallback(List<CommentModel> list) {
        getViewState().showComments(list);
    }
}
