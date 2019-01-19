package com.pericle.styleandroid_homework.domain.interactor;

import com.pericle.styleandroid_homework.data.repository.Repository;
import com.pericle.styleandroid_homework.presentation.presenter.ICallback;

public class Interactor {

    Repository repository;

    public void someFun(ICallback iCallback) {
        repository = new Repository();
//        if (repository.someFun() == null)
//            Log.i("Repository", "nullInInteractor");
//        else
//            Log.i("Repository", "notNullInteractor");
//        return repository.someFun();

        repository.someFun(iCallback);
    }
}
