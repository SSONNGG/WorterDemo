package com.song.worterdemo.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.song.worterdemo.R;

public class AlphabetDialogFragment extends DialogFragment {

    View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        return super.onCreateDialog(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView==null){
            rootView= inflater.inflate(R.layout.dialog_alphabet, container);
        }
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);  // 去掉Title布局
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.round_rectangle_dialog);
        return rootView;
    }
}
