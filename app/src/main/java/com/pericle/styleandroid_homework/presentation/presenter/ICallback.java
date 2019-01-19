package com.pericle.styleandroid_homework.presentation.presenter;

import com.pericle.styleandroid_homework.domain.entity.PostModel;

import java.util.List;

public interface ICallback {
    void callback(List<PostModel> list);
}
