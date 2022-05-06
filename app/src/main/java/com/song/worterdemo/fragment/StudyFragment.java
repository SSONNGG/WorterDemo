package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.song.worterdemo.R;
import com.song.worterdemo.activity.StudyActivity;
import com.song.worterdemo.entity.QuestionVO;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.viewmodel.SymbolViewModel;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

/**
 * 创建学习内容的StudyFragment
 */
public class StudyFragment extends Fragment {
    View rootView;
    private static final String ARG_PARAM = "param";
    private Integer mParam;


    public StudyFragment() {
    }

    public static StudyFragment newInstance(int id) {
        StudyFragment fragment = new StudyFragment();
        Bundle args=new Bundle();
        args.putInt(ARG_PARAM,id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getInt(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_study, container, false);
        }
        setData();
        bindButtonChange();
        return rootView;
    }

    private void setData(){
        SymbolViewModel symbolViewModel=new ViewModelProvider(getActivity()).get(SymbolViewModel.class);
        symbolViewModel.getSymbolById(mParam).observe(getActivity(),symbols -> {
            //Update UI
            TextView tv_symbol=rootView.findViewById(R.id.tv_symbol_content);
            tv_symbol.setText(symbols.get(0).getSymbolContent());
            TextView tv_alphabet=rootView.findViewById(R.id.tv_alphabet);
            tv_alphabet.setText(symbols.get(0).getSymbolAlphabet());
            TextView tv_pronun=rootView.findViewById(R.id.tv_symbol_pronun);
            tv_pronun.setText(symbols.get(0).getSymbolPronun());
        });
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

}