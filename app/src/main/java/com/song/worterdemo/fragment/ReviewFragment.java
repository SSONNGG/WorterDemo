package com.song.worterdemo.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.song.worterdemo.R;
import com.song.worterdemo.activity.StudyActivity;
import com.song.worterdemo.viewmodel.ReviewQuestionViewModel;
import com.song.worterdemo.viewmodel.WordViewModel;

import java.util.Timer;
import java.util.TimerTask;


public class ReviewFragment extends Fragment {
    View rootView;
    private static final String ARG_PARAM = "param";
    private Integer mParam;
    ChipGroup chipGroup;
    Chip chip;



    public ReviewFragment() {

    }

    public static ReviewFragment newInstance(int id) {
        ReviewFragment fragment = new ReviewFragment();
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
            rootView=inflater.inflate(R.layout.fragment_review, container, false);
        }
        setData();
        return rootView;
    }

    public void ChoiceChip(String rightAnswer,int reviewId,int wordId) {
        chipGroup = rootView.findViewById(R.id.chipgroup_review);
        chipGroup.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(ChipGroup group, int checkedId) {
                String show = "";
                switch (checkedId) {
                    case R.id.chip_choice01:
                        show = "第一个选项";
                        chip = rootView.findViewById(R.id.chip_choice01);
                        judgement(chip, rightAnswer,reviewId,wordId);
                        break;
                    case R.id.chip_choice02:
                        show = "第二个选项";
                        chip = rootView.findViewById(R.id.chip_choice02);
                        judgement(chip, rightAnswer,reviewId,wordId);
                        break;
                    case R.id.chip_choice03:
                        show = "第三个选项";
                        chip = rootView.findViewById(R.id.chip_choice03);
                        judgement(chip, rightAnswer,reviewId,wordId);
                        break;
                    case R.id.chip_choice04:
                        show = "第四个选项";
                        chip = rootView.findViewById(R.id.chip_choice04);
                        judgement(chip, rightAnswer,reviewId,wordId);
                        break;
                    default:
                        show = "没有选中内容";
                        break;
                }
            }
        });
    }

    public void setData(){
        ReviewQuestionViewModel reviewQuestionViewModel=new ViewModelProvider(this).get(ReviewQuestionViewModel.class);
        reviewQuestionViewModel.getReviewQuestionAndSymbolById(mParam).observe(getActivity(),reviewVOS -> {
            TextView tv_symbol = rootView.findViewById(R.id.tv_choice_title);
            tv_symbol.setText(reviewVOS.get(0).getWordContent());
            Chip chip01 = rootView.findViewById(R.id.chip_choice01);
            chip01.setText(reviewVOS.get(0).getAnswerOne());
            Chip chip02 = rootView.findViewById(R.id.chip_choice02);
            chip02.setText(reviewVOS.get(0).getAnswerTwo());
            Chip chip03 = rootView.findViewById(R.id.chip_choice03);
            chip03.setText(reviewVOS.get(0).getAnswerThree());
            Chip chip04 = rootView.findViewById(R.id.chip_choice04);
            chip04.setText(reviewVOS.get(0).getAnswerFour());
            ChoiceChip(reviewVOS.get(0).getReviewAnswer(),reviewVOS.get(0).getReviewId(),reviewVOS.get(0).getWordId());
        });
    }

    //判断是否为正确答案
    public void judgement(Chip chip, String rightAnswer,int reviewId,int wordId) {
        if (chip.getText().equals(rightAnswer)) { //题目答对了
            chip.setChipBackgroundColorResource(R.color.content_text_yellow);
            //update数据
            ReviewQuestionViewModel reviewQuestionViewModel=new ViewModelProvider(this).get(ReviewQuestionViewModel.class);
            reviewQuestionViewModel.updateReviewFinish(reviewId);
        } else {  //题目答错了
            chip.setChipBackgroundColorResource(R.color.color_red);
            WordViewModel wordViewModel=new ViewModelProvider(this).get(WordViewModel.class);
            wordViewModel.updateWordIsraw(1,wordId);

        }

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //切换页面
                ((StudyActivity) getActivity()).reviewChangePage();
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000);//3秒后执行TimeTask的run方法
    }

}