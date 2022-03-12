package com.song.worterdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.song.worterdemo.R;

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


        return rootView;

    }
}
