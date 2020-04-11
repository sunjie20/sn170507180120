package cn.edu.sdwu.android.classroom.sn170507180120;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.xmlpull.v1.XmlPullParser;

public class Ch6Activity1 extends AppCompatActivity {




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout_ch6_1);
            //在java代码中获取字符串资源
            String content=getString(R.string.hello);

            Log.i(Ch6Activity1.this.toString(),content);


            //短信
            String sms=getString(R.string.sms);
            sms=String.format(sms,100,"tom");
            Log.i(Ch6Activity1.this.toString(),sms);

            //获取数组资源
            Resources resources=getResources();
            //——整型数组
            int[] intArr=resources.getIntArray(R.array.intArr);
            for(int i=0;i<intArr.length;i++){
                Log.i(Ch6Activity1.this.toString(),intArr[i]+"");
            }
            //——string数组
            String[] strArr=resources.getStringArray(R.array.strArr);
            for(int i=0;i<strArr.length;i++){
                Log.i(Ch6Activity1.this.toString(),strArr[i]+"");
            }
            //——普通数组
            TypedArray typedArray=resources.obtainTypedArray(R.array.commonArr);
            ImageView imageView=(ImageView)findViewById(R.id.ch6_1_iv);
            int resId=typedArray.getResourceId(0,0);//两个参数：数组下标，值
            imageView.setImageResource(resId);
            String str=typedArray.getString(1);
            Log.i(Ch6Activity1.this.toString(),str);


            //2--注册上下文菜单
            LinearLayout linearLayout=(LinearLayout)findViewById(R.id.ch6_1_ll);

            registerForContextMenu(linearLayout);


            //XML

            XmlPullParser xmlPullParser=resources.getXml(R.xml.words);
            try{
                while(xmlPullParser.getEventType()!=XmlPullParser.END_DOCUMENT){//判断是否能够到达文档结尾
                    if(xmlPullParser.getEventType()==XmlPullParser.START_TAG){//到达新元素的开始
                        //判断一下是否是word元素(words直接跳过)
                        if(xmlPullParser.getName().equals("word")){
                            String word=xmlPullParser.getAttributeValue(0);//当前第几个属性
                            Log.i(Ch6Activity1.class.toString(),word);
                        }
                    }
                    xmlPullParser.next();
                }
            }catch (Exception e){
                Log.e(Ch6Activity1.class.toString(),e.toString());
            }

        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            //加载自定义的菜单资源
            MenuInflater menuInflater=getMenuInflater();
            menuInflater.inflate(R.menu.mymenu1,menu);
        }

        @Override
        public boolean onContextItemSelected(MenuItem item) {
            switch (item.getItemId()){
                case R.id.mymenu_item1:
                    Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mymenu_item2:
                    Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mymenu_item3:
                    Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        }

        //选项菜单
        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            //事件处理的方式：基于回调的事件处理(覆盖父类的某个方法)
            //根据菜单项的ID进行区分
            switch (item.getItemId()){
                case R.id.mymenu_item1:
                    Toast.makeText(this,"item1",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mymenu_item2:
                    Toast.makeText(this,"item2",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.mymenu_item3:
                    Toast.makeText(this,"item3",Toast.LENGTH_SHORT).show();
                    break;
            }

            return true;
        }

        //菜单资源menu
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            //加载自定义的菜单资源
            MenuInflater menuInflater=getMenuInflater();
            menuInflater.inflate(R.menu.mymenu1,menu);//参数：定义的菜单资源，加载到哪个对象
            return true;

        }






    }
