package com.song.worterdemo.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Query;

import com.song.worterdemo.dao.OtherQuestionDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.OtherQuestion;
import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class OtherQuestionRepository {

    private final Executor executor = Executors.newFixedThreadPool(2);  //开线程池
    private LiveData<List<OtherQuestion>> questionList;
    private OtherQuestionDao dao;

    public OtherQuestionRepository(Context context){
        WorterDatabase database=WorterDatabase.getWorterDatabase(context.getApplicationContext());
        dao=database.getOtherQuestionDao();
    }

    public LiveData<List<OtherQuestion>> getAllOtherQuestion(){
        questionList=dao.getAllOtherQuestion();
        return questionList;
    }


    public LiveData<List<OtherQuestion>> getOtherQuestionById(Integer... id){
        questionList=dao.getOtherQuestionById(id);
        return questionList;
    }

    public LiveData<List<OtherQuestion>> getOtherQuestionByCate(Integer... category){
        questionList=dao.getOtherQuestionByCate(category);
        return questionList;
    }

    public void updateOtherQuestionIsraw(Integer israw,Integer id){
        executor.execute(()->{
            dao.updateOtherQuestionIsraw(israw,id);
        });
    }


    public LiveData<List<OtherQuestion>> getSymbolQuestionIsraw(){
        questionList=dao.getSymbolQuestionIsraw();
        return questionList;
    }

}
