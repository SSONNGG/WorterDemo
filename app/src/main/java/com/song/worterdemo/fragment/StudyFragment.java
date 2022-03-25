package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.WordAndSymbol;

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

    public static StudyFragment newInstance(Bundle bundle) {
        StudyFragment fragment = new StudyFragment();
        fragment.setArguments(bundle);
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
        List<WordAndSymbol>  wordAndSymbolList=(List<WordAndSymbol>) getArguments().getSerializable("symbol");
        tv=rootView.findViewById(R.id.id);
        tv.setText(wordAndSymbolList.toString());
        return rootView;
    }
}