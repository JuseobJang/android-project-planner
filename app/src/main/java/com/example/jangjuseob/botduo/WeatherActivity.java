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

        WebSettings webSettings = WebView01.getSettings();
        webSettings.setJavaScriptEnabled(true);
        WebView01.loadUrl("https://weather.com/weather/today/l/37.28,126.84");
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v){
                finish();

            }
        });
    }
}
