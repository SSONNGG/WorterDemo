package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.song.worterdemo.entity.WordAndSymbol;

import java.util.List;

@Dao    //单词数据库访问接口
public interface WordDao {

    @Transaction
    @Query("select * from word join symbol on word.symbol_id=symbol.symbol_id")
    public LiveData<List<WordAndSymbol>> getWordAndSymbol();


}
