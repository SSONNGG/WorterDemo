package com.song.worterdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.song.worterdemo.R;
import com.song.worterdemo.adapter.MyFragmentPageAdapter;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.fragment.StudyFragment;
import com.song.worterdemo.utils.StatusBarUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StudyActivity extends AppCompatActivity {

    ViewPager2 viewPager;
    private List<WordAndSymbol> wordAndSymbols=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        //需要切换颜色就调用即可
        StatusBarUtil.setStatusBarMode(this, true, R.color.content_background_blue);


        initData();
        initPage();



    }

    private void initPage() {
        int n=wordAndSymbols.size();
        viewPager=findViewById(R.id.id_studyViewPage);
        ArrayList<Fragment> fragments=new ArrayList<>();
        for(int i=0;i<n;i++){
            Bundle bundle=new Bundle();
            bundle.putSerializable("symbol",(Serializable) wordAndSymbols);
            fragments.add(StudyFragment.newInstance(bundle));
        }
        MyFragmentPageAdapter pageAdapter=new MyFragmentPageAdapter(getSupportFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(pageAdapter);
    }

    private void initData(){
        for(int i=0;i<3;i++){
            WordAndSymbol wordAndSymbol=new WordAndSymbol();
            wordAndSymbol.setWordId(i);
            wordAndSymbol.setWordContent("car");
            wordAndSymbol.setWordTrans("n. 汽车，轿车；（电梯的）梯厢");
            wordAndSymbol.setSymbolId(1);
            wordAndSymbol.setSymbolContent("[ɑ:]");
            wordAndSymbol.setUkSymbol("[kɑ:(r)]");
            wordAndSymbol.setUsaSymbol("[kɑ:r]");
            wordAndSymbol.setSymbolGroup(1);
            wordAndSymbol.setIsraw(1);
            wordAndSymbols.add(wordAndSymbol);
        }
        Log.e("TAG", "initData: "+wordAndSymbols.toString() );

    }


}
