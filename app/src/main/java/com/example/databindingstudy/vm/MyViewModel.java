package com.example.databindingstudy.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.databindingstudy.dao.DataDao;

public class MyViewModel extends ViewModel {
    public MyViewModel() {
    }
    private MutableLiveData<String> currentName;

    public MutableLiveData<String> getCurrentName() {
        if(currentName == null){
            currentName = new MutableLiveData<String>();
        }

        return currentName;
    }

    public MutableLiveData<String> getTestName() {
        currentName.setValue("1111111111");
        return currentName;
    }
}
