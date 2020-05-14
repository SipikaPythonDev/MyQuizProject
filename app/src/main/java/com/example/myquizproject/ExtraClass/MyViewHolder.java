package com.example.myquizproject.ExtraClass;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class MyViewHolder extends RecyclerView.ViewHolder {

    private View view = null;
    public Text txt1;
    public Text txt2;

    public MyViewHolder() {
        this(null);

        Text txt1=this.txt1;
        Text txt2=this.txt2;

    }

    public MyViewHolder(View view) {


        super(view);
        this.view = view;

    }}



