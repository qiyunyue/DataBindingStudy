package com.example.databindingstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.databindingstudy.util.MyAsyncTask;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btn = (Button) findViewById(R.id.btn_my);
        WebView text = findViewById(R.id.webview_release_note);
        text.loadUrl("file:///C:/Users/%E8%A2%81%E6%B4%81/Desktop/local/test/test.html");
        text.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                Log.i("hehe","onPageStarted");
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Log.i("hehe","onPageFinished");
            }
        });

        btn.setOnKeyListener(new View.OnKeyListener(){

            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction() == KeyEvent.ACTION_DOWN){
                    Log.i("hehe","监听器的onKeyDown方法被调用");
                }
                return false;
            }
        });


        //4、
        pg_bar = findViewById(R.id.pg_bar);
        btn_download = findViewById(R.id.btn_download);
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyAsyncTask myAsyncTask = new MyAsyncTask(pg_bar);
                myAsyncTask.execute(1000);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode,event);
        Log.i("hehe","Activity的onKeyDown方法被调用");
        return false;
    }

    //4、
    private ProgressBar pg_bar;
    private Button btn_download;
}