package com.song.worterdemo.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.MyFragmentPageAdapter;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.fragment.ChoiceFragment;
import com.song.worterdemo.fragment.StudyFragment;
import com.song.worterdemo.utils.StatusBarUtil;
import com.song.worterdemo.viewmodel.SymbolQuestionViewModel;
import com.song.worterdemo.viewmodel.SymbolViewModel;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StudyActivity extends AppCompatActivity {


    ViewPager2 viewPager;
    ArrayList<Fragment> fragments=new ArrayList<>();
    MyFragmentPageAdapter Adapter;
    List<Symbol> symbols;
    List<SymbolQuestion> symbolQuestions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        //需要切换颜色就调用即可
        StatusBarUtil.setStatusBarMode(this, true, R.color.content_background_blue);
        initSymbolData();
    }

    private void initSymbolData(){
        SharedPreferences sp= getSharedPreferences("SPWorter", Context.MODE_PRIVATE);
        //获取SP文件中的音标组数据
        int SymbolGroup=sp.getInt("SymbolGroup",1); //获取保存在SP文件中SymbolGroup的值，默认为1
        SymbolViewModel symbolViewModel=new ViewModelProvider(this).get(SymbolViewModel.class);
        symbolViewModel.getSymbolByGroup(SymbolGroup).observe(this, new Observer<List<Symbol>>() {
            @Override
            public void onChanged(List<Symbol> data) {
                initSymbolPage(data);
            }
        });
    }

    private void initSymbolPage(List<Symbol> data){
        int n=data.size();
        for(int i=0;i<n;i++){
            //添加学习页面
            fragments.add(StudyFragment.newInstance());
            fragments.add(ChoiceFragment.newInstance());
        }
        viewPager=findViewById(R.id.id_studyViewPage);
        Adapter=new MyFragmentPageAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setUserInputEnabled(false);   //禁止滑动
        viewPager.setAdapter(Adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if(data.size()>position){
                    EventBus.getDefault().postSticky(data.get(position));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    public void initQuestionData(int id){
        SymbolQuestionViewModel symbolQuestionViewModel=new ViewModelProvider(this).get(SymbolQuestionViewModel.class);
        symbolQuestionViewModel.getSymbolQuestionBySymbolId(id).observe(this, new Observer<List<SymbolQuestion>>() {
            @Override
            public void onChanged(List<SymbolQuestion> data) {
                initQuestionPage(data);
            }
        });
    }

    private void initQuestionPage(List<SymbolQuestion> data){
        int n=data.size();
        for(int i=0;i<n;i++){
            //添加学习页面
            fragments.add(ChoiceFragment.newInstance());
        }
        viewPager=findViewById(R.id.id_studyViewPage);
        Adapter=new MyFragmentPageAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setUserInputEnabled(false);   //禁止滑动
        viewPager.setAdapter(Adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    public void changePage(){
        if(viewPager.getCurrentItem()==Adapter.getItemCount()-1){   //当前item等于总item数目时，完成业务：显示学习完成界面。
            Toast.makeText(getApplicationContext(),"已经到最后一页啦",Toast.LENGTH_SHORT).show();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
        }
    }



}
