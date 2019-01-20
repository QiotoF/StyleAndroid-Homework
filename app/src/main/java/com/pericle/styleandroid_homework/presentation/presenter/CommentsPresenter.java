package com.pericle.styleandroid_homework.presentation.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;
import com.pericle.styleandroid_homework.domain.interactor.CommentsInteractor;
import com.pericle.styleandroid_homework.presentation.view.CommentsView;

import java.util.List;

@InjectViewState
public class CommentsPresenter extends MvpPresenter<CommentsView> implements ICommentsCallback {

    private CommentsInteractor mInteractor;

    public CommentsPresenter() {
        mInteractor = new CommentsInteractor();
    }

    public void sendRequest(int postId) {
        mInteractor.sendRequest(postId, this);
    }

    @Override
    public void showComments(List<CommentModel> list) {
        getViewState().showComments(list);
    }
}
