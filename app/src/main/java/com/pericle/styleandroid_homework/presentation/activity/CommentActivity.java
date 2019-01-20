package com.pericle.styleandroid_homework.presentation.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;
import com.pericle.styleandroid_homework.presentation.adapter.CommentAdapter;
import com.pericle.styleandroid_homework.presentation.presenter.CommentPresenter;
import com.pericle.styleandroid_homework.presentation.view.CommentView;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends MvpActivity implements CommentView {

    @InjectPresenter
    CommentPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private CommentAdapter mAdapter;
    private List<CommentModel> comments;

    @ProvidePresenter
    CommentPresenter provideCommentsPresenter() {
        return new CommentPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        comments = new ArrayList<>();
        mRecyclerView = findViewById(R.id.comments_recycler_view);
        mAdapter = new CommentAdapter(comments);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.sendRequest(getIntent().getExtras().getInt("postId", 0));
    }

    @Override
    public void showComments(List<CommentModel> list) {
        if (list != null) {
            comments.addAll(list);
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }

    }
}
