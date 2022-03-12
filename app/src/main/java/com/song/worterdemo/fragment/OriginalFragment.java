package com.song.worterdemo.fragment;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.song.worterdemo.R;
import com.song.worterdemo.adapter.MyFragmentPageAdapter;

import java.util.ArrayList;

//原语
public class OriginalFragment  extends Fragment {

    View rootView;
    TabLayout tabLayout;
    ViewPager2 viewPager;

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

    //初始化ViewPage
    private void initPage(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(AlphabetFragment.newInstance());
        fragments.add(SymbolFragment.newInstance());
        MyFragmentPageAdapter adapter=new MyFragmentPageAdapter(getFragmentManager(),getLifecycle(),fragments);
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
