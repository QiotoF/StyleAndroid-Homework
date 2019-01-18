package com.pericle.styleandroid_homework.presentation;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.pericle.styleandroid_homework.App;
import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.presenter.MainPresenter;
import com.pericle.styleandroid_homework.presentation.view.MainView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends MvpActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;

    private List<PostModel> posts;

    @ProvidePresenter
    MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        posts = new ArrayList<>();



        mRecyclerView = findViewById(R.id.recycler_view);
        mAdapter = new MyAdapter(posts);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void setList(List<PostModel> list) {
        posts.addAll(list);
        mRecyclerView.getAdapter().notifyDataSetChanged();
    }

}
