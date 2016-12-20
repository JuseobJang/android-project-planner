package com.example.jangjuseob.botduo;

import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 *  <pre>
 *  <b>History:</b>
 *      최재영,장주섭 2016.12.20 중간작성
 *
 *  <b>설명:</b>
 *      어플의 메인화면을 구성하고 제어하는 클래스
 *  </pre>
 * @author wntjq68(장주섭), chlwodud77(최재영)
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        final EditText edit = (EditText) findViewById(R.id.editText);



        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            /**
             * MainActivity 화면에 Weather 버튼을 누르면 WeatherActivity로 넘어가게 해주는 메소드*/
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });


        Button button2 = (Button) findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * MainActivity 화면에 검색버튼을 누르면 EditText에 입력된 내용을 받아
             * 인텐트 객체에 전달하고 웹서치 기능을 불러와 입력된 내용을 검색해주는 메소드*/
            public void onClick(View v) {
                String info  = edit.getText().toString(); // EditText 로부터 String info 변수에 입력된 내용을 저장
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,info);
                startActivity(intent);

            }
        });

//        Button button7 = (Button) findViewById(R.id.button7);
//        button7.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,HtmlActivity.class);
//                startActivity(intent);
//
//            }
//        });


        Button plan = (Button) findViewById(R.id.plan);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * MainAcitivity의 PLAN 버튼을 누르면 PlanActivity로 넘어가게 해주는 메소드 */
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlanActivity.class);
                startActivity(intent);

            }
        });

    }

    @Override
    /**
     *  Exit popup event method*/
    public void onBackPressed() {
        String alertTitle = getResources().getString(R.string.app_name);

        String buttonMessage = getResources().getString(R.string.msg);

        String buttonYes = getResources().getString(R.string.btn_yes);

        String buttonNo = getResources().getString(R.string.btn_no);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage(buttonMessage);
        builder.setNegativeButton(buttonNo, null);
        builder.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            @Override
            /**
             * '예'를 터치하면 앱을 종료해주는 메소드
             * @param dialog
             * @param which
             */
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
            }
        });
        builder.show();
    }


}
