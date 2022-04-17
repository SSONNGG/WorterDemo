package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.song.worterdemo.R;
import com.song.worterdemo.activity.StudyActivity;
import com.song.worterdemo.entity.QuestionVO;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.viewmodel.SymbolQuestionViewModel;

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
    private static final String ARG_PARAM = "param";
    private Integer mParam;

    ChipGroup chipGroup;
    Chip chip;

    public ChoiceFragment() {

    }

    public static ChoiceFragment newInstance(int id) {
        ChoiceFragment fragment = new ChoiceFragment();
        Bundle args=new Bundle();
        args.putInt(ARG_PARAM,id);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getInt(ARG_PARAM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView==null){
            rootView=inflater.inflate(R.layout.fragment_choice, container, false);
        }
        //注册
        setData();
        return rootView;
    }

    public void ChoiceChip(String rightAnswer,int symbolId) {
        chipGroup=rootView.findViewById(R.id.chipgroup_choice);
        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                String show="";
                switch (checkedId){
                    case R.id.chip_choice01:
                        show="第一个选项";
                        chip=rootView.findViewById(R.id.chip_choice01);
                        judgement(chip,rightAnswer,symbolId);
                        break;
                    case R.id.chip_choice02:
                        show="第二个选项";
                        chip=rootView.findViewById(R.id.chip_choice02);
                        judgement(chip,rightAnswer,symbolId);
                        break;
                    case R.id.chip_choice03:
                        show="第三个选项";
                        chip=rootView.findViewById(R.id.chip_choice03);
                        judgement(chip,rightAnswer,symbolId);
                        break;
                    case R.id.chip_choice04:
                        show="第四个选项";
                        chip=rootView.findViewById(R.id.chip_choice04);
                        judgement(chip,rightAnswer,symbolId);
                        break;
                    default:
                        show="没有选中内容";
                        break;
                }
            }
        });
    }

    //配置数据
    public void setData() {
        SymbolQuestionViewModel viewModel=new ViewModelProvider(getActivity()).get(SymbolQuestionViewModel.class);
        viewModel.getSymbolQuestionBySymbolId(mParam).observe(getActivity(),questions->{
            TextView tv_symbol=rootView.findViewById(R.id.tv_choice_title);
            tv_symbol.setText(questions.get(0).getSymbolQuestionContent());
            Chip chip01=rootView.findViewById(R.id.chip_choice01);
            chip01.setText(questions.get(0).getAnswerOne());
            Chip chip02=rootView.findViewById(R.id.chip_choice02);
            chip02.setText(questions.get(0).getAnswerTwo());
            Chip chip03=rootView.findViewById(R.id.chip_choice03);
            chip03.setText(questions.get(0).getAnswerThree());
            Chip chip04=rootView.findViewById(R.id.chip_choice04);
            chip04.setText(questions.get(0).getAnswerFour());
            ChoiceChip(questions.get(0).getSymbolQuestionAnswer(),questions.get(0).getSymbolId());
        });

    }

    //判断是否为正确答案
    public void judgement(Chip chip,String rightAnswer,int symbolId){
        if(chip.getText().equals(rightAnswer)){ //题目答对了
            chip.setChipBackgroundColorResource(R.color.content_text_yellow);
        }else{  //题目答错了
            chip.setChipBackgroundColorResource(R.color.color_red);

            ((StudyActivity)getActivity()).ReloadStudyPage(symbolId);
        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                 //切换页面
                ((StudyActivity)getActivity()).changePage();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000);//3秒后执行TimeTask的run方法
    }

}