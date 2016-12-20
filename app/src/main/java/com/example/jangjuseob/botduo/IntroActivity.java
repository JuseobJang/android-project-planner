package com.example.jangjuseob.botduo;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *  <pre>
 *  <b>History:</b>
 *      최재영,장주섭 2016.12.20 중간작성
 *
 *  <b>설명:</b>
 *      어플이 실행하면 초기 인트로를 일정시간 동안 띄어주고 MainActivity로 넘어가는 기능을 하는 클래스
 *  </pre>
 * @author wntjq68(장주섭), chlwodud77(최재영)
 * @version 1.0
 */

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);


        /*Handler 의 postDelayed 기능을 사용하여 초기 앱을 실행하면 IntroActivity를 실행하고 1.5초 뒤에
        * MainActivity를 실행하도록 함.*/
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 1500);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}
