package com.example.databindingstudy.databinding;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.databindingstudy.MainActivity;

public class DataBindingAdapter {
    @BindingAdapter("android:paddingLeft")
    public static void setPaddingLeft(View view, int padding){
        System.out.println("-------------------------------------" + padding);
        view.setPadding(padding,view.getPaddingTop(),view.getPaddingRight(),view.getPaddingBottom());
    }


    @BindingAdapter(value = "myName", requireAll = false)
    public static void setMyName(Button view, String myName){
        System.out.println("-------------------------------------" + myName);
        view.setText(myName);
    }


}
