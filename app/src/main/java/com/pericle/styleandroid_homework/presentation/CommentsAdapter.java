package com.pericle.styleandroid_homework.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.pericle.styleandroid_homework.R;
import com.pericle.styleandroid_homework.domain.entity.CommentModel;

import java.util.List;

public class CommentsAdapter extends RecyclerView.Adapter<CommentsViewHolder> {

    private List<CommentModel> comments;

    public CommentsAdapter(List<CommentModel> comments) {
        this.comments = comments;
    }

    @NonNull
    @Override
    public CommentsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout root = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.comment_view, viewGroup, false);
        return new CommentsViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentsViewHolder commentsViewHolder, int i) {
        commentsViewHolder.bodyTextView.setText(comments.get(i).getBody());
        commentsViewHolder.emailTextView.setText(comments.get(i).getEmail());
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}
