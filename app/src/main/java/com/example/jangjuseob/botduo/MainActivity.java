package com.example.jangjuseob.botduo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        WebView WebView01 (WebView) findViewById(R.id.WebView_weather);
//        WebView01.setWebViewClient(new WebViewClient());
//
//        WebSettings webSettings = WebView01.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        WebView01.loadUrl("http://m.naver.com");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });
//
    }
}
