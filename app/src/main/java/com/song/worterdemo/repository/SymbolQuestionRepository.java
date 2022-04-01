package com.song.worterdemo.repository;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.SymbolQuestionDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;

public class SymbolQuestionRepository {

    private LiveData<List<SymbolQuestion>> questionList;
    private SymbolQuestionDao dao;


    public SymbolQuestionRepository(Context context){
        WorterDatabase database=WorterDatabase.getWorterDatabase(context.getApplicationContext());
        dao=database.getSymbolQuestionDao();
    }

    public LiveData<List<SymbolQuestion>> getAllSymbolQuestion(){
        questionList=dao.getAllSymbolQuestion();
        return questionList;
    }


}
