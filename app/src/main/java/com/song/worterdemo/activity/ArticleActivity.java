package com.song.worterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.song.worterdemo.R;
import com.song.worterdemo.utils.StatusBarUtil;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        //需要切换颜色就调用即可
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);
    }
}