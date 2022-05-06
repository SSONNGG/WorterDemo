package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.entity.ReviewQuestion;
import com.song.worterdemo.entity.ReviewVO;
import com.song.worterdemo.repository.ReviewQuestionRepository;

import java.util.List;

public class ReviewQuestionViewModel extends AndroidViewModel {
    public ReviewQuestionRepository repository;

    public ReviewQuestionViewModel(@NonNull Application application) {
        super(application);
        repository=new ReviewQuestionRepository(application);
    }

    public LiveData<List<ReviewQuestion>> getAllReviewQuestion(){
        return repository.getAllReviewQuestion();
    }

    public LiveData<List<ReviewVO>> getAllReviewQuestionAndSymbol(){
        return repository.getAllReviewQuestionAndSymbol();
    }

    public LiveData<List<ReviewVO>> getReviewQuestionAndSymbolByGroup(Integer group){
        return repository.getReviewQuestionAndSymbolByGroup(group);
    }

    public void updateReviewIsraw(Integer israw,Integer group){
       repository.updateReviewIsraw(israw,group);
    }

    public void updateReviewFinish(Integer id){
        repository.updateReviewFinish(id);
    }

    public LiveData<List<ReviewVO>> getReviewQuestion(){
        return repository.getReviewQuestion();
    }
}
