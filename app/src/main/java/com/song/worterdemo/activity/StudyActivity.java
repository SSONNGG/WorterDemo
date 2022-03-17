package com.song.worterdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.song.worterdemo.R;
import com.song.worterdemo.utils.StatusBarUtil;

public class StudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        //需要切换颜色就调用即可
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);

        //接收携带过来的数据
        Intent inten=getIntent();
        String title= getIntent().getStringExtra("title");
        TextView textView=findViewById(R.id.tv_title);
        textView.setText(title);

    }


}
