package com.example.jangjuseob.botduo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlanActivity extends ListActivity {
    ArrayList<String> arraylist;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arraylist = new ArrayList<String>();
        arraylist.add("12월 7일 중국어 기초 시험");
        arraylist.add("12월 9일 이산수학 시험");
        arraylist.add("12월 21일 오픈소스 프로젝트 발표");
        arraylist.add("12월 19일 회계정보의 활용 시험");
        arraylist.add("12월 20일 글과삶 시험");

        ArrayAdapter<String> Adapter;
        Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arraylist);

        setListAdapter(Adapter);
    }

    public void onListItemClick(ListView list, View view, int position, long id) {
        String mes;
        mes = "Select Item = " + arraylist.get(position);
        Toast.makeText(PlanActivity.this, mes, Toast.LENGTH_SHORT).show();
    }

}
