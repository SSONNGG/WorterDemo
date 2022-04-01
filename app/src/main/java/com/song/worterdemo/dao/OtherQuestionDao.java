package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.OtherQuestion;
import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;

@Dao
public interface OtherQuestionDao {

    @Query("select * from other_question")
    public LiveData<List<OtherQuestion>> getAllOtherQuestion();
}
