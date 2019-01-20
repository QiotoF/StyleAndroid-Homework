package com.pericle.styleandroid_homework.domain.interactor;

import com.pericle.styleandroid_homework.data.repository.Repository;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.presenter.ICallback;
import com.pericle.styleandroid_homework.presentation.presenter.IPostCallback;

public class Interactor {

    Repository repository;

    public void someFun(ICallback iCallback) {
        repository = new Repository(); //TODO: make repository initialize int constructor
//        if (repository.someFun() == null)
//            Log.i("Repository", "nullInInteractor");
//        else
//            Log.i("Repository", "notNullInteractor");
//        return repository.someFun();

        repository.someFun(iCallback);
    }

    public void addPost(String title, String body, IPostCallback iPostCallback) {
        PostModel post = stringToPost(title, body);
        repository.addPost(post, iPostCallback);
    }

    private PostModel stringToPost(String title, String body) {
        PostModel post = new PostModel();
//        post.setId(1);
//        post.setUserId(1);
        post.setTitle(title);
        post.setBody(body);
        return post;
    }
}
