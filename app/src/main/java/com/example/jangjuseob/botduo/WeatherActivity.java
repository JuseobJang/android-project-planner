package com.example.jangjuseob.botduo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
/**
 *  <pre>
 *  <b>History:</b>
 *      최재영,장주섭 2016.12.20 중간작성
 *
 *  <b>설명:</b>
 *      Webview 를 통해 날씨 사이트 Url 을 연결해 날씨 정보를 보여주는 기능을 하는 클래스.
 *  </pre>
 * @author wntjq68(장주섭), chlwodud77(최재영)
 * @version 1.0
 */
public class WeatherActivity extends AppCompatActivity {
    WebView WebView01; //Webview 인스턴스 생성.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        WebView01 =  (WebView) findViewById(R.id.WebView_weather);
        WebView01.setWebViewClient(new WebViewClient());
        WebSettings webSettings = WebView01.getSettings();
        webSettings.setJavaScriptEnabled(true); // javascript를 실행할 수 있도록 설정
        WebView01.loadUrl("http://m.rp5.ru/%EC%84%9C%EC%9A%B8%ED%8A%B9%EB%B3%84%EC%8B%9C%EC%9D%98_%EB%82%A0%EC%94%A8");// WebView 에 해당 url의 내용을 로드해줌

        /*뒤로가기 버튼을 누르면 MainActivity로 돌아가는 기능을 하는 메소드*/
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            /**
             * 버튼을 누르면 finish() 를 수행하여 WeatherActivity를 종료함. 실행되고 있던
             * MainActivity로 돌아가게 되는것.
             * @param v
             */
            public void onClick(View v){
                finish();

            }
        });
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}
