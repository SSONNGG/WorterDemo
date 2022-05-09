package com.song.worterdemo.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.ReviewQuestionDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.ReviewQuestion;
import com.song.worterdemo.entity.ReviewVO;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReviewQuestionRepository {

    private final Executor executor= Executors.newFixedThreadPool(2);   //开线程池
    private LiveData<List<ReviewQuestion>> questionList;
    private LiveData<List<ReviewVO>> reviewList;
    private ReviewQuestionDao dao;

    public ReviewQuestionRepository(Context context){
        WorterDatabase database=WorterDatabase.getWorterDatabase(context);
        dao= database.getReviewQuestionDao();
    }

    public LiveData<List<ReviewQuestion>> getAllReviewQuestion(){
        questionList=dao.getAllReviewQuestion();
        return questionList;
    }

    public LiveData<List<ReviewVO>> getAllReviewQuestionAndSymbol(){
        reviewList=dao.getAllReviewQuestionAndSymbol();
        return reviewList;
    }

    public LiveData<List<ReviewVO>> getReviewQuestionAndSymbolByGroup(Integer group){
        reviewList=dao.getReviewQuestionAndSymbolByGroup(group);
        return reviewList;
    }

    public LiveData<List<ReviewVO>> getReviewQuestionAndSymbolById(Integer... id){
        reviewList=dao.getReviewQuestionAndSymbolById(id);
        return reviewList;
    }

    public void updateReviewIsraw(Integer israw,Integer group){
        executor.execute(()->{
            dao.updateReviewIsraw(israw,group);
        });
    }

    public void updateReviewFinish(Integer id){
        executor.execute(()->{
            dao.updateReviewFinish(id);
        });
    }

    public LiveData<List<ReviewVO>> getReviewQuestion(){
        reviewList=dao.getReviewQuestion();
        return reviewList;
    }



}
