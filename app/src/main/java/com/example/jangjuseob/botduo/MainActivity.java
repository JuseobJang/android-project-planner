package com.example.jangjuseob.botduo;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

import static com.example.jangjuseob.botduo.R.id.editText;
import static com.example.jangjuseob.botduo.R.id.info;

public class MainActivity extends AppCompatActivity {

//    EditText edit = (EditText) findViewById(R.id.editText);
//    String info  = edit.getText().toString();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit = (EditText) findViewById(R.id.editText);
        String info  = edit.getText().toString();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });
        final Button button2 = (Button) findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,edit.getText().toString());
                startActivity(intent);

            }
        });




//
    }
//    EditText edit = (EditText) findViewById(R.id.editText);
//    String info = edit.getText().toString();
//
//
//    String info = edit.getText().toString();
//    TextInfo inf = new TextInfo(info);



//    public void onButton2Clicked(View v){
//
//
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(inf.getText()));
////        intent.putExtra(SearchManager.QUERY,edit.getText().toString());
//        startActivity(intent);
//    }

//public class TextInfo{
//    String info;
//    public TextInfo(String s){
//        info = s;
//    }
//
//    public String getText(){
//        return info;
//    }
//}




}
