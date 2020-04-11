package cn.edu.sdwu.android.classroom.sn170507180120;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Ch7Activity1 extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_ch7_1);

            //ToggleButton开关按钮
            ToggleButton toggleButton=(ToggleButton)findViewById(R.id.ch7_1_tb);
            toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
                        Toast.makeText(Ch7Activity1.this,"on",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(Ch7Activity1.this,"off",Toast.LENGTH_SHORT).show();
                    }
                }
            });

            //spinner
            Spinner spinner=(Spinner)findViewById(R.id.ch7_1_spinner);
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    //参数i：代表当前选中的索引值
                    String[] strArr=getResources().getStringArray(R.array.strArr);
                    String content=strArr[i];
                    Toast.makeText(Ch7Activity1.this,content,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            //数组适配器
            spinner=(Spinner)findViewById(R.id.ch7_1_spinner2);
            //↑在oncreate中定义ArrayList成员
            //准备数据
            list=new ArrayList();
            list.add("spinnerItem1");
            list.add("spinnerItem2");
            list.add("spinnerItem3");
            //实例化（数组适配器)
            //系统样式
            //ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);//参数：上下文(当前所在页面)，样式，数组
            //自定义的样式
            ArrayAdapter arrayAdapter=new ArrayAdapter(this,R.layout.layout_spinner_item,list);
            //设置到spinner中
            spinner.setAdapter(arrayAdapter);
            //处理事件
            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    //参数i：代表当前选中的索引值
                    String content=list.get(i).toString();
                    Toast.makeText(Ch7Activity1.this,content,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

        }//oncreate


    }
