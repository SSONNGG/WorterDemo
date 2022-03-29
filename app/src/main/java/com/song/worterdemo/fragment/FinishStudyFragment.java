package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.song.worterdemo.R;

//完成学习页面
public class FinishStudyFragment extends Fragment {
    View rootView;


    public FinishStudyFragment() {

    }


    public static FinishStudyFragment newInstance() {
        FinishStudyFragment fragment = new FinishStudyFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_finish_study, container, false);
        }
        return rootView;
    }
}