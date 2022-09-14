package com.example.databindingstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;


import com.example.databindingstudy.dao.DataDao;
import com.example.databindingstudy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        DataDao dataDao = new DataDao();
        dataDao.setName("11111");
        binding.setData(dataDao);
    }


}