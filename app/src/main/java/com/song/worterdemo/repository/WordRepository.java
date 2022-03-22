package com.song.worterdemo.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.WordDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.WordAndSymbol;

import java.util.List;

public class WordRepository {

    private LiveData<List<WordAndSymbol>> wordAndSymbolLive;
    private WordDao dao;

    public WordRepository(Context context) {
        WorterDatabase database=WorterDatabase.getWorterDatabase(context.getApplicationContext());
        dao=database.getWordDao();
    }

    public LiveData<List<WordAndSymbol>> getWordAndSymbol(){
        wordAndSymbolLive=dao.getWordAndSymbol();
        return wordAndSymbolLive;
    }





}
