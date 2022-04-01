package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;

@Dao
public interface SymbolQuestionDao {

    @Query("select * from symbol_question")
    public LiveData<List<SymbolQuestion>> getAllSymbolQuestion();
}
