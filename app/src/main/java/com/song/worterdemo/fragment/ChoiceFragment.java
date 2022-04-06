package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.song.worterdemo.R;
import com.song.worterdemo.activity.StudyActivity;
import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.entity.WordAndSymbol;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 选择题的fragment
 */
public class ChoiceFragment extends Fragment {

    View rootView;

    ChipGroup chipGroup;
    Chip chip;
    public ChoiceFragment() {

    }


    public static ChoiceFragment newInstance() {
        ChoiceFragment fragment = new ChoiceFragment();
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
            rootView=inflater.inflate(R.layout.fragment_choice, container, false);
        }
        //注册
        ChoiceChip();
        EventBus.getDefault().register(this);
        return rootView;
    }

    public void ChoiceChip() {
        chipGroup=rootView.findViewById(R.id.chipgroup_choice);
        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                String show="";
                switch (checkedId){
                    case R.id.chip_choice01:
                        show="第一个选项";
                        chip=rootView.findViewById(R.id.chip_choice01);
                        judgement(chip);
                        break;
                    case R.id.chip_choice02:
                        show="第二个选项";
                        chip=rootView.findViewById(R.id.chip_choice02);
                        judgement(chip);
                        break;
                    case R.id.chip_choice03:
                        show="第三个选项";
                        chip=rootView.findViewById(R.id.chip_choice03);
                        judgement(chip);
                        break;
                    case R.id.chip_choice04:
                        show="第四个选项";
                        chip=rootView.findViewById(R.id.chip_choice04);
                        judgement(chip);
                        break;
                    default:
                        show="没有选中内容";
                        break;
                }
                Toast.makeText(getContext(), show, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void judgement(Chip chip){
        chip.setChipBackgroundColorResource(R.color.content_text_yellow);
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                /**
                 * 切换页面
                 */
                ((StudyActivity)getActivity()).changePage();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000);//3秒后执行TimeTask的run方法
    }


    //订阅并绑定数据到控件
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onEvent(WordAndSymbol data){
        Log.e("TAG", "onEvent: 接受到数据"+data.toString() );
//               tv=rootView.findViewById(R.id.id);
//               tv.setText(data.toString());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this); //取消注册
    }
}