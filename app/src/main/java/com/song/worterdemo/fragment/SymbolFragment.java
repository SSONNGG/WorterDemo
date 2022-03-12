package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.song.worterdemo.R;


public class SymbolFragment extends Fragment {

    public SymbolFragment() {

    }



    public static SymbolFragment newInstance() {
        SymbolFragment fragment = new SymbolFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_symbol, container, false);
    }
}