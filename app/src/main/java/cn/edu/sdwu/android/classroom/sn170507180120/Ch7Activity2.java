package cn.edu.sdwu.android.classroom.sn170507180120;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ch7Activity2 extends AppCompatActivity {

    private ArrayList list;
        private ArrayAdapter arrayAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_ch7_2);

            //实例化
            list=new ArrayList();
            list.add("item1");
            list.add("item2");
            list.add("item3");

            final ListView listView=(ListView)findViewById(R.id.ch7_2_lv);
            //实例化——数组适配器
            arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,list);//上下文，显示的样式,事件源
            listView.setAdapter(arrayAdapter);

            //点击后的操作
            //设置监听器
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    //第三个参数代表当前点击数据位置
                    String content=list.get(i).toString();
                    Toast.makeText(Ch7Activity2.this,content,Toast.LENGTH_SHORT).show();
                }
            });

        }

        //点击数据源后增加数据
        public void refresh(View view){
            list.add("item4");
            list.add("item5");

            //数据源改变后，界面不会同步刷新，需要调用相应的方法
            arrayAdapter.notifyDataSetChanged();

        }

    }
