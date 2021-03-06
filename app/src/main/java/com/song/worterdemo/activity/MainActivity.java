package com.song.worterdemo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.MyFragmentPageAdapter;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.Article;
import com.song.worterdemo.entity.OtherQuestion;
import com.song.worterdemo.entity.QuestionVO;
import com.song.worterdemo.entity.ReviewQuestion;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.fragment.MainFragment;
import com.song.worterdemo.fragment.MyFragment;
import com.song.worterdemo.fragment.OriginalFragment;
import com.song.worterdemo.fragment.SearchFragment;
import com.song.worterdemo.utils.DatabaseUtil;
import com.song.worterdemo.utils.DateUtil;
import com.song.worterdemo.utils.StatusBarUtil;
import com.song.worterdemo.viewmodel.AlphabetViewModel;
import com.song.worterdemo.viewmodel.ArticleViewModel;
import com.song.worterdemo.viewmodel.OtherQuestionViewModel;
import com.song.worterdemo.viewmodel.ReviewQuestionViewModel;
import com.song.worterdemo.viewmodel.SymbolQuestionViewModel;
import com.song.worterdemo.viewmodel.SymbolViewModel;
import com.song.worterdemo.viewmodel.WordViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//主页操作
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ViewPager2 viewPager;
    private LinearLayout llMain,llOriginal,llSearch,llMy;
    private ImageView ivMain,ivOriginal,ivSearch,ivMy,ivCurrent;
    private DatabaseUtil dbutil;
    ReviewQuestionViewModel viewModel;
    //SP文件



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //从数据库文件导入数据库
        dbutil=new DatabaseUtil(this);
        dbutil.openDatabase();
//        viewModel=new ViewModelProvider(this).get(ReviewQuestionViewModel.class);
//        viewModel.getAllReviewQuestion().observe(this, new Observer<List<ReviewQuestion>>() {
//            @Override
//            public void onChanged(List<ReviewQuestion> reviewQuestions) {
//                Log.e("TAG", "onChanged: "+reviewQuestions.toString() );
//            }
//        });
//        viewModel.updateWordIsraw(1,1);
//        viewModel.updateWordIsraw(1,2);
//        viewModel.updateWordIsraw(1,8);
//        viewModel.updateWordIsraw(1,12);
//        viewModel.updateWordIsraw(1,27);
//        viewModel.updateWordIsraw(1,16);
//        viewModel.updateWordIsraw(1,29);
//        viewModel.updateWordIsraw(1,31);
//        viewModel.updateWordIsraw(1,91);
//        viewModel.updateWordIsraw(1,100);

        //添加模拟数据
//        ReviewQuestionViewModel reviewQuestionViewModel=new ViewModelProvider(this).get(ReviewQuestionViewModel.class);
//        reviewQuestionViewModel.updateReviewIsraw(0,1);
//        SharedPreferences sp= getSharedPreferences("SPWorter", Context.MODE_PRIVATE);
//        sp.edit().putInt("SymbolGroup",1).apply();
        //需要切换颜色就调用
        StatusBarUtil.setStatusBarMode(this, true, R.color.white);
        initPage();
        initTableView();
    }

    //实现点击事件
    @Override
    public void onClick(View v) {
        changeTab(v.getId());
    }

    //切换Tab
    private void changeTab(int position){
        ivCurrent.setSelected(false);   //默认设置选择状态为未选择状态
        switch (position){
            case R.id.id_tab_main:
                viewPager.setCurrentItem(0);
            case 0:
                ivMain.setSelected(true);
                ivCurrent=ivMain;
                break;

            case R.id.id_tab_original:
                viewPager.setCurrentItem(1);
            case 1:
                ivOriginal.setSelected(true);
                ivCurrent=ivOriginal;
                break;

            case R.id.id_tab_search:
                viewPager.setCurrentItem(2);
            case 2:
                ivSearch.setSelected(true);
                ivCurrent=ivSearch;
                break;

            case R.id.id_tab_my:
                viewPager.setCurrentItem(3);
            case 3:
                ivMy.setSelected(true);
                ivCurrent=ivMy;
                break;
        }
    }


    /**
     * 处理Tab区域UI
     */
    private void initTableView(){
        //绑定组件和设计点击事件
        //绑定LinearLayout
        llMain=findViewById(R.id.id_tab_main);
        llMain.setOnClickListener(this);
        llOriginal=findViewById(R.id.id_tab_original);
        llOriginal.setOnClickListener(this);
        llSearch=findViewById(R.id.id_tab_search);
        llSearch.setOnClickListener(this);
        llMy=findViewById(R.id.id_tab_my);
        llMy.setOnClickListener(this);
        //绑定ImageView
        ivMain=findViewById(R.id.tab_iv_main);
        ivOriginal=findViewById(R.id.tab_iv_original);
        ivSearch=findViewById(R.id.tab_iv_search);
        ivMy=findViewById(R.id.tab_iv_my);
        //默认选择第一个tab
        ivMain.setSelected(true);
        ivCurrent=ivMain;
    }

    /**
     * 初始化ViewPage的函数
     */
    private void initPage(){
        viewPager=findViewById(R.id.id_viewpager);
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(MainFragment.newInstance());
        fragments.add(OriginalFragment.newInstance());
        fragments.add(SearchFragment.newInstance());
        fragments.add(MyFragment.newInstance());
        MyFragmentPageAdapter pageAdapter=new MyFragmentPageAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pageAdapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });

    }

    /**
     * 开始学习
     * @param view
     */
    public void startStudy(View view) {
        //创建Intent对象
        Intent intent=new Intent(this,StudyActivity.class);
        intent.putExtra("mode","StudyMode");
        startActivity(intent);
    }

    /**
     * 综合复习
     * @param view
     */
    public void generalStudy(View view) {
        //创建Intent对象
        Intent intent=new Intent(this,StudyActivity.class);
        intent.putExtra("mode","ReviewMode");
        startActivity(intent);
    }


    public void trainSpell(View view) {
        //创建Intent对象
        Intent intent=new Intent(this,StudyActivity.class);
        intent.putExtra("mode","SpellEnglishMode");
        startActivity(intent);
    }

    public void trainNum(View view) {
        //创建Intent对象
        Intent intent=new Intent(this,StudyActivity.class);
        intent.putExtra("mode","NumMode");
        startActivity(intent);
    }

    public void trainDate(View view) {
        //创建Intent对象
        Intent intent=new Intent(this,StudyActivity.class);
        intent.putExtra("mode","DateMode");
        startActivity(intent);
    }

    public void trainFreedom(View view) {
        //创建Intent对象
        Intent intent=new Intent(this,StudyActivity.class);
        intent.putExtra("mode","FreedomMode");
        startActivity(intent);
    }
}