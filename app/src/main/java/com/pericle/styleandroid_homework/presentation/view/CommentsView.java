package com.pericle.styleandroid_homework.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;

import java.util.List;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface CommentsView extends MvpView {

    void showComments(List<CommentModel> list);

}
