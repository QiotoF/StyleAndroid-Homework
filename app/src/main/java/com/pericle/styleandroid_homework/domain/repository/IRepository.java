package com.pericle.styleandroid_homework.domain.repository;

import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.presenter.ICallback;
import com.pericle.styleandroid_homework.presentation.presenter.IPostCallback;

public interface IRepository {
    void someFun(ICallback iCallback);
    void addPost(PostModel postModel, IPostCallback iPostCallback);
}
