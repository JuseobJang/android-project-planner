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
/**
 *  <pre>
 *  <b>History:</b>
 *      최재영,장주섭 2016.12.20 중간작성
 *
 *  <b>설명:</b>
 *      일정 리스트를 추가하고 삭제는 기능을 수행하는 클래스
 *  </pre>
 * @author wntjq68(장주섭), chlwodud77(최재영)
 * @version 1.0
 */

public class PlanActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);

        final EditText addplan = (EditText)findViewById(R.id.editText2); //EditText 객체

        /**
         * SharedPreferences 는 간단한 값 저장에 DB를 사용하기에는 복잡하기 때문에 사용.
         * 어플리케이션에 파일 형태로 데이터를 저장함. 어플리케이션이 삭제 되기전이나 초기화
         * 메소드를 사용하지 않는 이상 데이터가 보존됨.SharedPreferences의 plandata 인스턴스를 생성하고
         * pref 이란 파일이름, MODE_PRIVATE 용도로 설정해줌. 그리고 이 pref 파일에 내용을 추가하거나
         * 삭제하기 위해 plandata 인스턴스를 수정할 수 있는 editor 인스턴스를 생성해줌.
         */
        final SharedPreferences plandata = getSharedPreferences("pref",MODE_PRIVATE);
        final SharedPreferences.Editor editor = plandata.edit();

        //일정 데이터를 저장할 빈데이터 리스트 생성
        final ArrayList<String> items = new ArrayList<String>();

        int i = 1;

        /**
         * 초기에 plandata에 저장된 값을 불러와 값이 존이하면 items 리스트에 아래와 같은
         * 형식으로 추가해줌.
         */
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
            /**
             * add 버튼을 누르면 items 리스트에 addplan 에서 받아온 내용을 추가한뒤
             * editor 를 이용해 Plandata에 저장함.
             * @param v
             */
            public void onClick(View v) {
                int count;
                count = adapter.getCount();

                //아이템 추가.
                items.add("* "+ addplan.getText().toString());

                //아이템 PlanData 에 저장
                editor.putString(Integer.toString(count + 1), addplan.getText().toString());
                editor.commit();
                Toast.makeText(getApplicationContext(),"추가되었습니다",Toast.LENGTH_SHORT).show();//내용이 추가되었음을 알려주는 메세지

                //Listview 갱신
                adapter.notifyDataSetChanged();
            }
        });

        /* clearall button에 대한 이벤트를 처리해주는 메소드.*/
        Button modifyButton = (Button)findViewById(R.id.clearall);
        modifyButton.setOnClickListener(new Button.OnClickListener() {
            /**
             * clearall 버튼을 누르면 editor의 clear()메소드를 사용하여
             * Plandata 에 있는 데이터들을 초기화함.
             * @param v
             */
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
            /**
             * delete 버튼을 누르면 제어문을 통해 Plandata에 선택한 리스트뷰에 해당하는 아이템 데이터를 삭제함.
             * @param v
             */
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
