package com.example.databindingstudy.vm;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databindingstudy.dao.DataDao;

public class MyViewModel extends ViewModel {
    public MutableLiveData<Boolean> mCheckStatus = new MutableLiveData<Boolean>(false);

    public MutableLiveData<String> mName = new MutableLiveData<>("a");

    private int i=0;
    public MyViewModel() {
    }

    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if(currentName == null){
            currentName = new MutableLiveData<String>();
        }

        return currentName;
    }

    public void getTestName() {
        currentName.setValue("1111111111");
    }



    public void setCheckStatus(int val){
        System.out.println("--------"+val);
        mCheckStatus.setValue(val==2?true:false);
        System.out.println("--------"+i);


        mName.setValue(String.valueOf(i++));

    }
}
