package com.pericle.styleandroid_homework.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pericle.styleandroid_homework.R;

public class CommentsViewHolder extends RecyclerView.ViewHolder {

    TextView bodyTextView;
    TextView emailTextView;
    LinearLayout linearLayout;

    public CommentsViewHolder(@NonNull LinearLayout itemView) {
        super(itemView);
        linearLayout = itemView.findViewById(R.id.linear_layout);
        bodyTextView = itemView.findViewById(R.id.body_text_view);
        emailTextView = itemView.findViewById(R.id.email_text_view);
    }
}
