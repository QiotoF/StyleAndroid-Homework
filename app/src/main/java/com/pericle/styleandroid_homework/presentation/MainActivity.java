package com.pericle.styleandroid_homework.presentation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.presenter.MainPresenter;
import com.pericle.styleandroid_homework.presentation.view.MainView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends MvpActivity implements MainView, View.OnClickListener {

    @InjectPresenter
    MainPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

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
        mAdapter = new MyAdapter(posts, this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setList(List<PostModel> list) {
        //posts = new ArrayList<>();
        if (list != null) {
            posts.addAll(list);
            mRecyclerView.getAdapter().notifyDataSetChanged();
        }
        Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
    }

    @Override
    public void addPost(PostModel post) {
        Log.i("vlad.before", posts.get(0).getTitle());
        posts.add(0, post);
        mRecyclerView.getAdapter().notifyDataSetChanged();
        Log.i("vlad.after", posts.get(0).getTitle());
    }

    @Override
    public void onClick(View view) {
        mRecyclerView.setVisibility(View.GONE);
        newPostLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onBackPressed() {
        if (newPostLayout.getVisibility() == View.VISIBLE) {
            newPostLayout.setVisibility(View.GONE);
            mRecyclerView.setVisibility(View.VISIBLE);
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

//    @Override
//    public void test() {
//        Log.i("vlad", "MainActivity.test");
//    }

}
