package com.pericle.styleandroid_homework.presentation.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.pericle.styleandroid_homework.domain.interactor.Interactor;
import com.pericle.styleandroid_homework.presentation.view.MainView;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {

    private final String LOG_TAG = this.getClass().getSimpleName();

    Interactor interactor;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.i(LOG_TAG, "onFirstViewAttach");

        interactor = new Interactor();
        getViewState().setList(interactor.someFun());
    }
}
