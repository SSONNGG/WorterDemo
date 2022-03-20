package com.song.worterdemo.fragment;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.song.worterdemo.R;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.viewmodel.AlphabetViewModel;

import org.w3c.dom.Text;

import java.util.List;

public class AlphabetDialogFragment extends DialogFragment {

    Alphabet data;

    View rootView;
    TextView alphabet;
    TextView pronun;
    TextView from;

    public void setData(Alphabet data){
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
            rootView= inflater.inflate(R.layout.dialog_alphabet, container);
        }
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);  // 去掉Title布局
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.round_rectangle_dialog);
        initData();
        return rootView;
    }

    //绑定数据
    public void initData(){
        alphabet=rootView.findViewById(R.id.alphabet_content);
        pronun=rootView.findViewById(R.id.alphabet_pronun);
        from=rootView.findViewById(R.id.alphabet_from);
        String alphabetcontent=data.getAlphabetCapital()+data.getAlphabetLower();
        alphabet.setText(alphabetcontent);
        pronun.setText(data.getAlphabetPronun());
        from.setText(data.getAlphabetFrom());
    }
}
