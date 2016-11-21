package com.example.jangjuseob.botduo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class WeatherActivity extends AppCompatActivity {
    WebView WebView01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        WebView01 =  (WebView) findViewById(R.id.WebView_weather);
        WebView01.setWebViewClient(new WebViewClient());
//        String source = "<a href=\"http://www.google.com\"><img src=\"https://pbs.twimg.com/profile_images/762369348300251136/5Obhonwa.jpg\"\n" +
//                "     alt=\"W3Schools.com\" width=\"150\" height=\"150\"></a>";
//        WebView01.loadData(source,"text/html","UTF-8");
        WebSettings webSettings = WebView01.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebView01.loadUrl("http://m.rp5.ru/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%EC%9D%98_%EB%82%A0%EC%94%A8");
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                finish();

            }
        });
    }
}
