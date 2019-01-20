package com.pericle.styleandroid_homework.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.adapter.MainAdapter;
import com.pericle.styleandroid_homework.presentation.callback.IOnButtonClickCallback;
import com.pericle.styleandroid_homework.presentation.callback.IOnCommentClickCallback;
import com.pericle.styleandroid_homework.presentation.presenter.MainPresenter;
import com.pericle.styleandroid_homework.presentation.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MvpActivity implements MainView, IOnButtonClickCallback, IOnCommentClickCallback {

    @InjectPresenter
    MainPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private MainAdapter mAdapter;

    private List<PostModel> posts;

    private LinearLayout newPostLayout;
    private EditText titleEditText;
    private EditText bodyEditText;

    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();
        newPostLayout = findViewById(R.id.newPostLayout);
        titleEditText = findViewById(R.id.titleEditText);
        bodyEditText = findViewById(R.id.bodyEditText);
        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new MainAdapter(posts, this, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setList(List<PostModel> list) {
        if (list != null) {
            posts.addAll(list);
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }
    }

    @Override
    public void addPost(PostModel post) {
        posts.add(0, post);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (newPostLayout.getVisibility() == View.VISIBLE) {
            newPostLayout.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }
    }

    public void newPostClick(View view) {
        String title = titleEditText.getText().toString();
        String body = bodyEditText.getText().toString();
        titleEditText.getText().clear();
        bodyEditText.getText().clear();
        newPostLayout.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mPresenter.addPost(title, body);
    }

    @Override
    public void OnCommentClick(int postId) {
        Intent intent = new Intent(MainActivity.this, CommentActivity.class);
        intent.putExtra("postId", postId);
        startActivity(intent);
    }

    @Override
    public void onButtonClick() {
        mRecyclerView.setVisibility(View.GONE);
        newPostLayout.setVisibility(View.VISIBLE);
    }
}
