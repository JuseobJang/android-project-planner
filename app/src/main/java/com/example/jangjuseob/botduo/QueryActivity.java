package com.example.jangjuseob.botduo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.TextExtractor;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class QueryActivity extends AppCompatActivity {

    TextView textView;  // 제목을 표시해줄 텍스트뷰
    private static Thread thread = null;
    String parsing_url;  // 파싱해오고자 하는 URL
    String get_data;  // 파싱해서 가져온 데이터를 저장할 스트링 변수
    ArrayList<String> array;  // get_data 변수의 값을 순차적으로 저장할 배열
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        textView = (TextView)findViewById(R.id.textView1);
        parsing_url = "http://www.naver.com/";

        Runnable task = new Runnable(){
            public void run(){
                getData(parsing_url);
            }
        };

        thread = new Thread(task);
        thread.start();  // 반드시 쓰레드를 해줘야함 그 이유는 아래에서 설명

        try{
            thread.join();  // 쓰레드 작업 끝날때까지 다른 작업들은 대기
        }catch(Exception e){

        }
        for(int i = 0; i < array.size(); i++){
            textView.append(array.get(i) + "\n");  // 쓰레드 작업 끝나면 텍스트뷰에 가져온 데이터를 입력
        }
    }

    // 파싱 작업을 하는 메서드

    public ArrayList<String> getData(String strURL){
        Source source;
        get_data = "";
        array = new ArrayList();
        try{
            URL url = new URL(strURL);
            source = new Source(url);  // 쓰레드를 사용 안하면 여기에서 예외 발생함 그 이유는 아래에서 설명
            Element element = null;

            List<Element> list = source.getAllElements(HTMLElementName.OPTION); // option 태그의 엘리먼트 가져옴

            for(int i = 0; i < list.size(); i++){
                element = list.get(i);
                String attributevalue = element.getAttributeValue("type");  // title 태그의 속성값이 type을 찾는다
                if(attributevalue != null){
                    if(attributevalue.equalsIgnoreCase("text")){  // type의 값이 text 이면
                        TextExtractor textExtractor = element.getTextExtractor();  // 해당 문자값을 가져온다
                        get_data = textExtractor.toString();  // 가져온 값을 스트링으로 변환후
                        array.add(get_data);  // ArrayList에 추가한다
                    }
                }
            }
        }catch(Exception e){

        }
        return array;  // 입력된 배열값을 리턴
    }

}