package com.pericle.styleandroid_homework.presentation.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.domain.interactor.PostInteractor;
import com.pericle.styleandroid_homework.presentation.callback.INewPostCallback;
import com.pericle.styleandroid_homework.presentation.callback.IShowPostCallback;
import com.pericle.styleandroid_homework.presentation.view.MainView;

import java.util.List;

import javax.inject.Inject;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> implements IShowPostCallback, INewPostCallback {


    @Inject
    PostInteractor postInteractor;

    private List<PostModel> list;

    @Inject
    public MainPresenter() {

    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.i("fucking", "onFirstViewAttach()");

        //postInteractor = new PostInteractor();
        postInteractor.showPosts(this);
    }

    @Override
    public void showPostCallback(List<PostModel> posts) {
        list = posts;
        getViewState().setList(list);
    }

    public void addPost(String title, String body) {
        postInteractor.addPost(title, body, this);
    }

    @Override
    public void newPostCallback(PostModel postModel) {
        getViewState().addPost(postModel);
    }
}
