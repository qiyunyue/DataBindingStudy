package com.example.databindingstudy.databinding;

import android.view.View;
import android.widget.Button;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapter {
    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int padding){
        System.out.println("-------------------------------------" + padding);
        view.setPadding(padding,view.getPaddingTop(),view.getPaddingRight(),view.getPaddingBottom());
    }


    @BindingAdapter(value = "myName", requireAll = false)
    public static void setMyName(View view, String myName){
        System.out.println("-------------------------------------" + myName);
    }
}
