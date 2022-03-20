package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.song.worterdemo.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WordbookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WordbookFragment extends Fragment {
    View rootView;

    public WordbookFragment() {

    }


    public static WordbookFragment newInstance() {
        WordbookFragment fragment = new WordbookFragment();
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
            rootView=inflater.inflate(R.layout.fragment_wordbook, container, false);
        }
        return rootView;
    }
}