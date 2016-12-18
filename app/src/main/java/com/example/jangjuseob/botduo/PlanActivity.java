package com.example.jangjuseob.botduo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {
//    ArrayList<String> arraylist;

//    String plantext;
//    PlanData plandata = new PlanData();




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        final EditText addplan = (EditText)findViewById(R.id.editText2);

        final SharedPreferences plandata = getSharedPreferences("pref",MODE_PRIVATE);
        final SharedPreferences.Editor editor = plandata.edit();


        //빈데이터 리스트 생성
        final ArrayList<String> items = new ArrayList<String>();

        int i = 1;
//        !plandata.getString(Integer.toString(i),"none").equals("none")
        while(i < 10){
            if (!plandata.getString(Integer.toString(i),"none").equals("none")) {
                items.add("* "+plandata.getString(Integer.toString(i), "none"));
            }
            i++;
        }

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
                items.add("* "+ addplan.getText().toString());

                //아이템 PlanData 에 저장
                editor.putString(Integer.toString(count + 1), addplan.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"추가되었습니다",Toast.LENGTH_SHORT).show();

                //Listview 갱신
                adapter.notifyDataSetChanged();
            }
        });

        // clearall button에 대한 이벤트 처리.
        Button modifyButton = (Button)findViewById(R.id.clearall);
        modifyButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                editor.clear();
                editor.commit();
                Toast.makeText(getApplicationContext(),"모든 데이터가 삭제되었습니다. 다시 나갔다 들어오세요",Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
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

                    Toast.makeText(getApplicationContext(),"선택된 데이터가 삭제되었습니다.",Toast.LENGTH_SHORT).show();

                    if (checked > -1 && checked < count){
                        //plandata에 선택한 아이템 삭제
                        editor.remove(Integer.toString(checked+1));
                        editor.commit();

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

}
