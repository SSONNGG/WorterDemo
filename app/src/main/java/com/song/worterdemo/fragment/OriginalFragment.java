package com.song.worterdemo.fragment;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.song.worterdemo.R;
import com.song.worterdemo.adapter.AlphabetRecyclerViewAdapter;
import com.song.worterdemo.adapter.MyFragmentPageAdapter;
import com.song.worterdemo.adapter.MyRecyclerViewAdapter;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.AlphabetCapAndLow;
import com.song.worterdemo.entity.ArticleTempo;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.manage.AlphabetEngin;

import java.util.ArrayList;
import java.util.List;

//原语
public class OriginalFragment  extends Fragment {

    View rootView;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    //字母数据
    List<AlphabetCapAndLow> alphabetCapAndLow;
    List<Alphabet> alphabets;
    //音标数据
    List<Symbol> symbols;
    //RecyclerView适配器
    AlphabetRecyclerViewAdapter adapter;
    //数据库引擎
    AlphabetEngin alphabetEngin;

    public RecyclerView recyclerView;//定义RecyclerView

    public OriginalFragment() {
    }

    public static OriginalFragment newInstance(){
        OriginalFragment fragment=new OriginalFragment();
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView==null){
            rootView= inflater.inflate(R.layout.fragment_original, container, false);
        }
        //绑定两个Tab栏
        tabLayout=rootView.findViewById(R.id.tablayout_original);
        viewPager=rootView.findViewById(R.id.viewpager_original);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                changeTab(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        initPage();
        //配置recyclerView
        //配置数据
        initData();
        initRecyclerView();
        return rootView;
    }

    //切换Tab
    private void changeTab(int position){
        switch (position){
            case 0:
                viewPager.setCurrentItem(0);
                break;
            case 1:
                viewPager.setCurrentItem(1);
                break;
        }
    }

    /*
     * 配置数据
     */
    private void initData(){
        alphabetEngin=new AlphabetEngin(getActivity());
//        alphabetCapAndLow=alphabetEngin.getAllCapAndLowAlphabet();

    }


    /**
     * 对Recyleview进行配置
     */
    private void initRecyclerView(){
        //获取
        recyclerView=viewPager.findViewById(R.id.rv_alphabet);
        //创建Adapter
        adapter=new AlphabetRecyclerViewAdapter(alphabetCapAndLow,getActivity());
        //设置Adapter
        recyclerView.setAdapter(adapter);
        //设置layoutManager
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        //设置监听事件
        adapter.setOnItemClickListener(new AlphabetRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View view, AlphabetCapAndLow data) {
                //监听事件业务处理
                Toast.makeText(getActivity(),"我是item", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //初始化ViewPage
    private void initPage(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(AlphabetFragment.newInstance());
        fragments.add(SymbolFragment.newInstance());
        MyFragmentPageAdapter adapter=new MyFragmentPageAdapter(getChildFragmentManager(),getLifecycle(),fragments);
        viewPager.setAdapter(adapter);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                changeTab(position);
            }
        });
    }



}
