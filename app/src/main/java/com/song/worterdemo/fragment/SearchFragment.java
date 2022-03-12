package com.song.worterdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.song.worterdemo.R;

//速查
public class SearchFragment extends Fragment {
    View rootView;

    public SearchFragment() {
    }

    public static SearchFragment newInstance(){
        SearchFragment fragment=new SearchFragment();
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
            rootView= inflater.inflate(R.layout.fragment_search, container, false);
        }
        return rootView;
    }
}
