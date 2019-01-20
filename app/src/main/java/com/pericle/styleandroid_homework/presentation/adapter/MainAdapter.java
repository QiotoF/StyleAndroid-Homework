package com.pericle.styleandroid_homework.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.PostModel;
import com.pericle.styleandroid_homework.presentation.callback.IOnButtonClickCallback;
import com.pericle.styleandroid_homework.presentation.callback.IOnCommentClickCallback;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private List<PostModel> posts;
    private IOnButtonClickCallback buttonListener;
    private IOnCommentClickCallback postListener;

    public MainAdapter(List<PostModel> posts, IOnButtonClickCallback buttonListener, IOnCommentClickCallback postListener) {
        this.posts = posts;
        this.buttonListener = buttonListener;
        this.postListener = postListener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout root;
        if (i == 1) {
            root = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.btn_view, viewGroup, false);
        } else {
            root = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_view, viewGroup, false);
        }
        return new MainViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, final int i) {
        if (i != 0) {
            mainViewHolder.tv1.setText(posts.get(i - 1).getTitle());
            mainViewHolder.tv2.setText(posts.get(i - 1).getBody());
            mainViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    postListener.OnCommentClick(i);
                }
            });
        } else {
            mainViewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonListener.onButtonClick();
                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        else return 2;
    }
}
