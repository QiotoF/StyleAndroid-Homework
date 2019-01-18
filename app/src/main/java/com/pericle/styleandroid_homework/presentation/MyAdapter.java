package com.pericle.styleandroid_homework.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.PostModel;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private static final String LOG_TAG = "MyAdapter";

    private List<PostModel> posts;

    public MyAdapter(List<PostModel> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout root;
        if (i == 1) {
            root = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.btn_view, viewGroup, false);
        } else {
            root = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.item_view, viewGroup, false);
        }
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        Log.i(LOG_TAG, String.valueOf(i));
        if (i != 0) {
            myViewHolder.tv1.setText(posts.get(i).getTitle());
            myViewHolder.tv2.setText(posts.get(i).getBody());
            myViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        Log.i(LOG_TAG, "getItemCount() " + posts.size());
        return posts.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) return 1;
        else return 2;
    }
}
