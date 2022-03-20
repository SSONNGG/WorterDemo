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

public class SymbolDialogFragment  extends DialogFragment {

    Symbol data;
    View rootView;
    TextView symbol;
    TextView pronun;
    TextView alphabet;

    public void setData(Symbol data){
        this.data=data;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(rootView==null){
            rootView= inflater.inflate(R.layout.dialog_symbol, container);
        }
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);  // 去掉Title布局
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.round_rectangle_dialog);
        initData();
        return rootView;
    }

    //绑定数据
    public void initData(){
        symbol=rootView.findViewById(R.id.symbol_content);
        pronun=rootView.findViewById(R.id.symbol_pronun);
        alphabet=rootView.findViewById(R.id.symbol_alphabet);
        symbol.setText(data.getSymbolContent());
        pronun.setText(data.getSymbolPronun());
        alphabet.setText(data.getSymbolAlphabet());
    }
}
