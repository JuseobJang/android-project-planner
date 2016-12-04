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

//import static com.example.jangjuseob.botduo.R.id.editText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        final EditText edit = (EditText) findViewById(R.id.editText);
        String info  = edit.getText().toString();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);

            }
        });

        Button button3 = (Button) findViewById(R.id.button6);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QueryActivity.class);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY,edit.getText().toString());
                startActivity(intent);

            }
        });

        Button button7 = (Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HtmlActivity.class);
                startActivity(intent);

            }
        });

        Button plan = (Button) findViewById(R.id.plan);
        plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PlanActivity.class);
                startActivity(intent);

            }
        });

    }
    /* Exit popup event method*/
    @Override
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
            public void onClick(DialogInterface dialog, int which) {
                moveTaskToBack(true);
                finish();
            }
        });
        builder.show();
    }


}
