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
import android.widget.CheckBox;


import com.example.databindingstudy.dao.DataDao;
import com.example.databindingstudy.databinding.ActivityMainBinding;
import com.example.databindingstudy.vm.MyViewModel;

public class MainActivity extends AppCompatActivity {

    private Button btn3;
    private MyViewModel viewModel;
    private CheckBox cb_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        viewModel = new MyViewModel();
        binding.setViewModel(viewModel);

        binding.setLifecycleOwner(this);

        btn3 = findViewById(R.id.btn3);
        cb_1 = findViewById(R.id.cb_1);



        viewModel.mCheckStatus.observe(this,s->cb_1.setText(s?"true":"false"));

        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                btn3.setText(s);
            }
        };

        viewModel.getCurrentName().observe(this,nameObserver);
    }


    public void testBtn3(View view){
        viewModel.getTestName();
    }

}