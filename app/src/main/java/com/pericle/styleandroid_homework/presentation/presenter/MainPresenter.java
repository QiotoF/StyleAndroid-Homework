package com.pericle.styleandroid_homework.presentation.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.domain.interactor.Interactor;
import com.pericle.styleandroid_homework.presentation.view.MainView;

import java.util.List;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> implements ICallback {

    private final String LOG_TAG = this.getClass().getSimpleName();

    Interactor interactor;
    List<PostModel> lista;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.i("Repository", "onFirstViewAttach");

        interactor = new Interactor();
//        if (interactor.someFun() == null)
//            Log.i("Repository", "nullInPresenter");
//        else
//            Log.i("Repository", "notNullPresenter");
//        getViewState().setList(interactor.someFun());

        interactor.someFun(this);
    }

//    public void test() {
//        Log.i("vlad", "MainPresenter.test");
//        getViewState().test();
//    }

    @Override
    public void callback(List<PostModel> posts) {
        lista = posts;
        getViewState().setList(lista);
    }
/*
    @Override
    public void callback(List<PostModel> list) {
        this.list = list;
    }*/
}
