package com.song.worterdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.song.worterdemo.R;

//原语
public class OriginalFragment  extends Fragment {

    View rootView;

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
            rootView= inflater.inflate(R.layout.original_layout, container, false);
        }
        return rootView;
    }
}
