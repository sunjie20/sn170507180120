package cn.edu.sdwu.android.classroom.sn170507180120;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class Ch8Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //使用编码方式实现页面布局
        FrameLayout frameLayout=new FrameLayout(this);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));

        //实例化imageview
        ImageView imageView=new ImageView(this);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setImageResource(R.drawable.img);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);//缩放形式(长、宽占满屏幕)
        frameLayout.addView(imageView);//加载到framelayout

        //实例化imageview
        TextView textView=new TextView(this);
        textView.setText("test");//设置文本
        textView.setTextColor(Color.RED);//设置字体颜色
        textView.setTextSize(70);//设置字体大小
        textView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER));//设置宽、高、显示的相对位置
        frameLayout.addView(textView);
        //加载到framelayout

        //framelayout与Activity建立关系
        setContentView(frameLayout);


    }
}
