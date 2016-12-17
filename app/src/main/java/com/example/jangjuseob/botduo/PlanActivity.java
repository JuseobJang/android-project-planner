package com.example.jangjuseob.botduo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
//    ArrayList<String> arraylist;

//    String plantext;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        final EditText addplan = (EditText)findViewById(R.id.editText2);

        //빈데이터 리스트 생성
        final ArrayList<String> items = new ArrayList<String>();

        // ArrayAdapter 생성. 아이템 View를 선택(single choice)가능하도록 만듦.
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, items);

        // listview 생성 및 adapter 지정.
        final ListView listview = (ListView) findViewById(R.id.listview1);
        listview.setAdapter(adapter);

        // add button에 대한 이벤트 처리.
        Button addButton = (Button)findViewById(R.id.add);
        addButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                //아이템 추가.
                items.add(Integer.toString(count + 1)+") " + addplan.getText().toString());

                //Listview 갱신
                adapter.notifyDataSetChanged();
            }
        });

        // modify button에 대한 이벤트 처리.
        Button modifyButton = (Button)findViewById(R.id.modify);
        modifyButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count, checked;
                count = adapter.getCount();

                if (count > 0) {
                    checked = listview.getCheckedItemPosition();
                    if (checked > -1 && checked < count) {
                        //아이템 수정
                        items.set(checked, Integer.toString(checked + 1) + "번 아이템 수정");

                        //Listview 갱신
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });

        // delete button에 대한 이벤트 처리.
        Button deleteButton = (Button)findViewById(R.id.delete);
        deleteButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v){
                int count, checked;
                count = adapter.getCount();

                if (count > 0){
                    //현재 선택된 아이템의 position 획득
                    checked = listview.getCheckedItemPosition();

                    if (checked > -1 && checked < count){
                        //아이템 삭제
                        items.remove(checked);

                        //listview 선택 초기화
                        listview.clearChoices();

                        //listview 갱신
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });
    }

//        arraylist = new ArrayList<String>();
//        arraylist.add("12월 7일 중국어 기초 시험");
//        arraylist.add("12월 9일 이산수학 시험");
//        arraylist.add("12월 21일 오픈소스 프로젝트 발표");
//        arraylist.add("12월 19일 회계정보의 활용 시험");
//        arraylist.add("12월 20일 글과삶 시험");



//    public void addList(){
////        arraylist = new ArrayList<String>();
//            plantext = addtext.getText().toString();
//            arraylist.add(plantext);
//    }

//    public void onListItemClick(ListView list, View view, int position, long id) {
//        String mes;
//        mes = "Select Item = " + arraylist.get(position);
//        Toast.makeText(PlanActivity.this, mes, Toast.LENGTH_SHORT).show();
//    }

}
