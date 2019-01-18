package com.pericle.styleandroid_homework.domain.interactor;

import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.domain.repository.IRepository;

import java.util.List;

public class Interactor {

    IRepository iRepository;

    public List<PostModel> someFun() {
        return iRepository.someFun();
    }
}
