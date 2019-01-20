package com.pericle.styleandroid_homework.presentation.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    private List<CommentModel> comments;

    public CommentAdapter(List<CommentModel> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout root = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.comment_view, viewGroup, false);
        return new CommentViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder commentViewHolder, int i) {
        commentViewHolder.bodyTextView.setText(comments.get(i).getBody());
        commentViewHolder.emailTextView.setText(comments.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
