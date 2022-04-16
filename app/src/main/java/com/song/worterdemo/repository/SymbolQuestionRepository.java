package com.song.worterdemo.repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.SymbolQuestionDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.QuestionVO;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SymbolQuestionRepository {
    private final Executor executor = Executors.newFixedThreadPool(2);  //开线程池
    private LiveData<List<SymbolQuestion>> questionList;
    private List<SymbolQuestion> questions;
    private LiveData<List<QuestionVO>> questionvoList;
    private SymbolQuestionDao dao;


    public SymbolQuestionRepository(Context context){
        WorterDatabase database=WorterDatabase.getWorterDatabase(context.getApplicationContext());
        dao=database.getSymbolQuestionDao();
    }

    public LiveData<List<SymbolQuestion>> getAllSymbolQuestion(){
        questionList=dao.getAllSymbolQuestion();
        return questionList;
    }

    public LiveData<List<SymbolQuestion>> getSymbolQuestionBySymbolId(Integer... symbolId) {
        questionList=dao.getSymbolQuestionBySymbolId(symbolId);
        return questionList;
    }

    public LiveData<List<SymbolQuestion>> getSymbolQuestionById(Integer... id){
        questionList=dao.getSymbolQuestionById(id);
        return questionList;
    }

    public void updateSymbolQuestionIsraw(Integer israw,Integer id){
        executor.execute(()->{
            dao.updateSymbolQuestionIsraw(israw,id);
        });
    }

    public void updateSymbolQuestionIsReview(Integer isreview,Integer id){
        executor.execute(()->{
            dao.updateSymbolQuestionIsReview(isreview,id);
        });
    }

    public LiveData<List<SymbolQuestion>> getSymbolQuestionIsraw() {
        questionList=dao.getSymbolQuestionIsraw();
        return questionList;
    }

    public LiveData<List<SymbolQuestion>> getSymbolQuestionIsreview() {
        questionList=dao.getSymbolQuestionIsreview();
        return questionList;
    }

    public LiveData<List<QuestionVO>> getSymbolQuestionStudyByGroup(Integer... group){
        questionvoList=dao.getSymbolQuestionStudyByGroup(group);
        return questionvoList;
    }

    public List<SymbolQuestion>  getSymbolQuestionListBySymbolId(Integer... group){
        questions=dao.getSymbolQuestionListBySymbolId(group);
        return questions;
    }




}
