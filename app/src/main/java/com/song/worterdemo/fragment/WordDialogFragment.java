package com.song.worterdemo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.WordAndSymbol;

public class WordDialogFragment extends DialogFragment {
    View rootView;
    WordAndSymbol data;
    TextView tvWord;
    TextView tvUkSymbol;
    TextView tvUsSymbol;
    TextView tvTrans;

    public void setData(WordAndSymbol data){
        this.data=data;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView==null){
            rootView=inflater.inflate(R.layout.dialog_wordbook,container);
        }
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);  // 去掉Title布局
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.round_rectangle_dialog);
        initData();
        return rootView;
    }

    private void initData() {
        tvWord=rootView.findViewById(R.id.tv_dialog_word);
        tvUkSymbol=rootView.findViewById(R.id.tv_dialog_uk_symbol);
        tvUsSymbol=rootView.findViewById(R.id.tv_dialog_us_symbol);
        tvTrans=rootView.findViewById(R.id.tv_dialog_wordtrans);
        tvWord.setText(data.getWordContent());
        tvUkSymbol.setText(data.getUkSymbol());
        tvUsSymbol.setText(data.getUsaSymbol());
        tvTrans.setText(data.getWordTrans());
    }
}
