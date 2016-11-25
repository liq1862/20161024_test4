package com.example.user.a20161024_test4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1;
    String fruit[] = {"蘋果","葡萄","芭樂","芒果","甘蔗","鳳梨"};
    String cities[] = {"台北", "台中","高雄"};
    String codes[] = {"02", "04", "07"};
    Spinner spinner2;
    TextView tv;
    ArrayList<Map<String,String>> mylist;
    ArrayAdapter<String> adapter;
    SimpleAdapter adapter2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        adapter =new  ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,fruit);
                                         //(目前的Activity,  layout格式(內建),  string陣列名稱)

        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tv = (TextView) findViewById(R.id.textView);
                tv.setText(fruit[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //=======================================
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        mylist = new ArrayList<>();
        for (int i=0;i<cities.length;i++)
        {
            HashMap<String,String> m1 = new HashMap<>();
            m1.put("city", cities[i]);
            m1.put("code", codes[i]);
            mylist.add(m1);
        }
        /*
        HashMap<String,String> m1 = new HashMap<>();
        m1.put("city", "台北");
        m1.put("code", "02");
        mylist.add(m1);
        HashMap<String,String> m2 = new HashMap<>();
        m2.put("city", "台中");
        m2.put("code", "04");
        mylist.add(m2);
        HashMap<String,String> m3 = new HashMap<>();
        m3.put("city", "高雄");
        m3.put("code", "07");
        mylist.add(m3);
        */
        /*adapter2 = new SimpleAdapter(MainActivity.this,mylist,android.R.layout.simple_list_item_2,
                                    new String[]{"city","code"},
                                    new int[]{android.R.id.text1,android.R.id.text2});
                */
        adapter2 = new SimpleAdapter(MainActivity.this,mylist,R.layout.myitem,
                new String[]{"city","code"},
                new int[]{R.id.tvCity,R.id.tvCode});
        spinner2.setAdapter(adapter2);
    }
}
