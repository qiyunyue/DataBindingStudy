package com.example.databindingstudy.util;

import android.os.AsyncTask;
import android.widget.ProgressBar;

public class MyAsyncTask extends AsyncTask<Integer,Integer,String> {
    private ProgressBar pg_bar;

    public MyAsyncTask(ProgressBar pg_bar) {
        this.pg_bar = pg_bar;
    }

    @Override
    protected String doInBackground(Integer... integers) {
        DelayOperator delayOperator = new DelayOperator();
        int i = 0;
        for(i=10;i<=100;i+=10){
            delayOperator.delay();
            publishProgress(i);
        }
        return i + integers[0].intValue() +"";
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int value = values[0];
        pg_bar.setProgress(value);
    }
}
