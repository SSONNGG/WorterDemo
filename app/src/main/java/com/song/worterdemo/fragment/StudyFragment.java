package com.song.worterdemo.fragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.viewmodel.SymbolQuestionViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建学习内容的StudyFragment
 */
public class StudyFragment extends Fragment {
    View rootView;

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
                ((StudyActivity)getActivity()).changePage();
            }
        });
    }

    //订阅并绑定数据到控件
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(Symbol data){
        TextView tv_symbol=rootView.findViewById(R.id.tv_symbol_content);
        tv_symbol.setText(data.getSymbolContent());
        TextView tv_alphabet=rootView.findViewById(R.id.tv_alphabet);
        tv_alphabet.setText(data.getSymbolAlphabet());
        TextView tv_pronun=rootView.findViewById(R.id.tv_symbol_pronun);
        tv_pronun.setText(data.getSymbolPronun());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this); //取消注册
    }


}