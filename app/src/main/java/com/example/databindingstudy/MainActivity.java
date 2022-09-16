package com.example.databindingstudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import com.example.databindingstudy.dao.DataDao;
import com.example.databindingstudy.databinding.ActivityMainBinding;
import com.example.databindingstudy.vm.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private Button btn3;
    private MyViewModel model;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        DataDao dataDao = new DataDao();
        dataDao.setName("11111");
        binding.setData(dataDao);
        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = "魈";
                model.getCurrentName().setValue(name);
            }
        });


        model = new ViewModelProvider(this).get(MyViewModel.class);
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btn3.setText(s);
            }
        };

        model.getCurrentName().observe(this,nameObserver);
    }


    public void testBtn3(View view){
        model.getTestName();
    }

}