package com.song.worterdemo.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.shapes.Shape;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.MyFragmentPageAdapter;
import com.song.worterdemo.bus.LiveDataBus;
import com.song.worterdemo.entity.QuestionVO;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.fragment.ChoiceFragment;
import com.song.worterdemo.fragment.ReviewFragment;
import com.song.worterdemo.fragment.StudyFragment;
import com.song.worterdemo.utils.StatusBarUtil;
import com.song.worterdemo.viewmodel.ReviewQuestionViewModel;
import com.song.worterdemo.viewmodel.SymbolQuestionViewModel;
import com.song.worterdemo.viewmodel.SymbolViewModel;
import com.song.worterdemo.viewmodel.WordViewModel;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class StudyActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    ArrayList<Fragment> fragments=new ArrayList<>();
    MyFragmentPageAdapter Adapter;
    LinearLayout ll;
    LinearLayout study;
    TextView tv_mode_title;
    TextView tv_mode_subTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        Intent intent=getIntent();
        String mode=intent.getStringExtra("mode");
        ll=findViewById(R.id.ll_mode_banner);
        study=findViewById(R.id.fragment_study);
        tv_mode_title=findViewById(R.id.tv_mode_title);
        tv_mode_subTitle=findViewById(R.id.tv_mode_subtitle);
        choiceMode(mode);
    }

    //??????????????????
    @SuppressLint("ResourceAsColor")
    private void choiceMode(String mode){
        if(mode.equals("StudyMode")){
            //?????????????????????????????????
            StatusBarUtil.setStatusBarMode(this, true, R.color.content_background_blue);
            initStudyModeData();

        }else if(mode.equals("ReviewMode")){
            StatusBarUtil.setStatusBarMode(this, true, R.color.silver);
            ll.setBackgroundResource(R.color.silver);
            tv_mode_title.setText("????????????");
            tv_mode_title.setTextColor(R.color.black);
            tv_mode_subTitle.setTextColor(R.color.black);
            initReviewMode();

        }else if(mode.equals("SpellEnglishMode")) {
            StatusBarUtil.setStatusBarMode(this, true, R.color.content_green_light);
            ll.setBackgroundResource(R.color.content_green_light);
            tv_mode_title.setText("????????????");
            tv_mode_title.setTextColor(R.color.content_green_deep);
            tv_mode_subTitle.setText("??????????????????");
            tv_mode_subTitle.setTextColor(R.color.content_green_deep);

        }else if(mode.equals("NumMode")) {
            StatusBarUtil.setStatusBarMode(this, true, R.color.content_pink_light);
            ll.setBackgroundResource(R.color.content_pink_light);
            tv_mode_title.setText("??????");
            tv_mode_title.setTextColor(R.color.black);
            tv_mode_subTitle.setText("??????????????????");
            tv_mode_subTitle.setTextColor(R.color.black);

        }else if(mode.equals("DateMode")) {
            StatusBarUtil.setStatusBarMode(this, true, R.color.content_orange_light);
            ll.setBackgroundResource(R.color.content_orange_light);
            tv_mode_title.setText("??????");
            tv_mode_title.setTextColor(R.color.color_orange_deep);
            tv_mode_subTitle.setText("?????????????????????");
            tv_mode_subTitle.setTextColor(R.color.color_orange_deep);

        }else if(mode.equals("FreedomMode")) {
            StatusBarUtil.setStatusBarMode(this, true, R.color.content_purple_title);
            ll.setBackgroundResource(R.color.content_purple_title);
            tv_mode_title.setText("????????????");
            tv_mode_title.setTextColor(R.color.content_purple_deep);
            tv_mode_subTitle.setText("???????????????");
            tv_mode_subTitle.setTextColor(R.color.content_purple_deep);
        }

        viewPager=findViewById(R.id.id_studyViewPage);
        Adapter=new MyFragmentPageAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setUserInputEnabled(false);   //????????????
        viewPager.setAdapter(Adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }
        });
    }

    //???????????????????????????????????????
    private void initStudyModeData(){
        //??????SP???????????????????????????
        SharedPreferences sp= getSharedPreferences("SPWorter", Context.MODE_PRIVATE);
        int SymbolGroup=sp.getInt("SymbolGroup",1); //???????????????SP?????????SymbolGroup??????????????????1
        SymbolViewModel symbolViewModel=new ViewModelProvider(this).get(SymbolViewModel.class);
        symbolViewModel.getSymbolByGroup(SymbolGroup).observe(this,symbols -> {
            for(int i=0;i<symbols.size();i++){
                fragments.add(StudyFragment.newInstance(symbols.get(i).getSymbolId()));
                fragments.add(ChoiceFragment.newInstance(symbols.get(i).getSymbolId()));
            }
        });
    }

    //?????????????????????
    public void ReloadStudyPage(int SymbolId){
        Log.e("TAG", "ReloadStudyPage: "+ viewPager.getCurrentItem());
        SymbolViewModel symbolViewModel=new ViewModelProvider(this).get(SymbolViewModel.class);
        symbolViewModel.getSymbolById(SymbolId).observe(this,symbols -> {
            fragments.add(viewPager.getCurrentItem()+2,StudyFragment.newInstance(symbols.get(0).getSymbolId()));
            fragments.add(viewPager.getCurrentItem()+2,ChoiceFragment.newInstance(symbols.get(0).getSymbolId()));
        });
    }

    //??????????????????
    private void initReviewMode() {
        ProgressBar pb=findViewById(R.id.pb_study);
        pb.setProgressDrawable(getResources().getDrawable(R.drawable.progressbar_review));
        fragments.clear();
        ReviewQuestionViewModel reviewQuestionViewModel=new ViewModelProvider(this).get(ReviewQuestionViewModel.class);
        reviewQuestionViewModel.getReviewQuestion().observe(this,reviewVOS -> {
            for(int i=0;i<reviewVOS.size();i++){
                fragments.add(ReviewFragment.newInstance(reviewVOS.get(i).getReviewId()));
            }
        });
    }

    private void initNumMode(){

    }


    public void studyChangePage(){
        if(viewPager.getCurrentItem()==Adapter.getItemCount()-1){   //??????item?????????item??????????????????????????????????????????????????????
            SharedPreferences sp= getSharedPreferences("SPWorter", Context.MODE_PRIVATE);
            //?????????????????????Toast??????Looper
            Looper.prepare();
            ReviewQuestionViewModel reviewQuestionViewModel=new ViewModelProvider(this).get(ReviewQuestionViewModel.class);
            reviewQuestionViewModel.updateReviewIsraw(1,sp.getInt("SymbolGroup",1));
            Toast.makeText(getApplicationContext(),"??? "+sp.getInt("SymbolGroup",1)+" ????????????????????????",Toast.LENGTH_SHORT).show();
            sp.edit().putInt("SymbolGroup",sp.getInt("SymbolGroup",1)+1).apply();
            Looper.loop();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            ProgressBar pb=findViewById(R.id.pb_study);
            pb.setMax(Adapter.getItemCount());
            pb.setProgress(viewPager.getCurrentItem());
        }
    }

    public void reviewChangePage(){
        if(viewPager.getCurrentItem()==Adapter.getItemCount()-1){   //??????item?????????item??????????????????????????????????????????????????????
            //?????????????????????Toast??????Looper
            Looper.prepare();
            Toast.makeText(getApplicationContext(),"????????????????????????",Toast.LENGTH_SHORT).show();
            Looper.loop();
        }else{
            viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
            ProgressBar pb=findViewById(R.id.pb_study);
            pb.setMax(Adapter.getItemCount());
            pb.setProgress(viewPager.getCurrentItem());
        }
    }

}
