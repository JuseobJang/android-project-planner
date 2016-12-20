package com.example.jangjuseob.botduo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
//        String source = "<table cellpadding=0 cellspacing=0 width=500 style=\"border:solid 1px #fe2020;font-family:Arial;font-size:12px;background-color:#fedf20\"><tr><td><table width=100% cellpadding=0 cellspacing=0><tr><td width=8 height=30 background=\"http://rp5.ru/informer/htmlinfa/topshl.png\"  bgcolor=#fe2020> </td><td width=* align=center background=\"http://rp5.ru/informer/htmlinfa/topsh.png\" bgcolor=#fe2020><a style=\"color:#ffffff; font-family:Arial;font-size: 12px;\" href=\"http://rp5.ru/292213/ko\"><b>상록 / 안산시</b></a></td><td width=8 height=30 background=\"http://rp5.ru/informer/htmlinfa/topshr.png\" bgcolor=#fe2020> </td></tr></table></td></tr><tr><td valign=top style=\"padding:0;\"><iframe src=\"http://rp5.ru/htmla.php?id=292213&lang=ko&um=00000&bg=%23fedf20&ft=%23ffffff&fc=%23fe2020&c=%23000000&f=Arial&s=12&sc=4\" width=100% height=272 frameborder=0 scrolling=no style=\"margin:0;\"></iframe></td></tr></table>";
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
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}
