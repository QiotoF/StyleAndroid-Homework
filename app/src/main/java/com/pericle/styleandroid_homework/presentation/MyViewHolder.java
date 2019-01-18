package com.pericle.styleandroid_homework.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.pericle.styleandroid_homework.R;

public class MyViewHolder extends RecyclerView.ViewHolder {

    TextView tv1;
    TextView tv2;
    Button button;
    LinearLayout linearLayout;

    public MyViewHolder(@NonNull LinearLayout itemView) {
        super(itemView);
        button = itemView.findViewById(R.id.btn);
        tv1 = itemView.findViewById(R.id.text_view_1);
        tv2 = itemView.findViewById(R.id.text_view_2);
        linearLayout = itemView.findViewById(R.id.linear_layout);

    }
}
