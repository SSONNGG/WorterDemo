package com.song.worterdemo.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.song.worterdemo.R;
import com.song.worterdemo.activity.StudyActivity;
import com.song.worterdemo.entity.WordAndSymbol;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建学习内容的StudyFragment
 */
public class StudyFragment extends Fragment {
    View rootView;
    TextView tv;

    public StudyFragment() {
    }

    public static StudyFragment newInstance() {
        StudyFragment fragment = new StudyFragment();
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
            rootView=inflater.inflate(R.layout.fragment_study, container, false);
        }
        //注册
        EventBus.getDefault().register(this);
        bindButtonChange();
        return rootView;
    }

    private void bindButtonChange() {
        top.androidman.SuperButton btnNext=rootView.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getContext(),"button按下",Toast.LENGTH_SHORT).show();
                ((StudyActivity)getActivity()).changePage();
            }
        });
    }

    //订阅并绑定数据到控件
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(WordAndSymbol data){
    //    Log.e("TAG", "onEvent: 接受到数据"+data.toString() );
    //        tv=rootView.findViewById(R.id.id);
    //        tv.setText(data.toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this); //取消注册
    }


}