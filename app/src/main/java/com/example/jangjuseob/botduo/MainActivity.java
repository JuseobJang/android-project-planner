package com.example.jangjuseob.botduo;

import android.app.SearchManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import static com.example.jangjuseob.botduo.R.id.editText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edit = (EditText) findViewById(R.id.editText);
//        String editText.getText().toString();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });

//        public void onButton2Clicked(View v){
//
//
//
//            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//            intent.putExtra(SearchManager.QUERY,editText.getText().toString());
//            startActivity(intent);
//        }


//
    }


//    Button button2 = (Button) findViewById(R.id.button5);
//    button2.setOnClickListener(new View.OnClickListener()
//
//    {
//        public void onClick (View v)
//        {
//            String data = edit.getText().toString();
//            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
//            intent.putExtra(SearchManager.QUERY, data);
//            startActivity(intent);
//
//        }
//    }
//
//    );

}
