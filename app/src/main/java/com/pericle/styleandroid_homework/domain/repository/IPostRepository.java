package com.pericle.styleandroid_homework.domain.repository;

import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.callback.INewPostCallback;
import com.pericle.styleandroid_homework.presentation.callback.IShowPostCallback;

public interface IPostRepository {
    void showPosts(IShowPostCallback iShowPostCallback);
    void addPost(PostModel postModel, INewPostCallback iNewPostCallback);
}
