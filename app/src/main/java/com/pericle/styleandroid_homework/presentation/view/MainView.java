package com.pericle.styleandroid_homework.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.pericle.styleandroid_homework.domain.entity.PostModel;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface MainView extends MvpView {

    void setList(List<PostModel> list);
//    void test();
}
