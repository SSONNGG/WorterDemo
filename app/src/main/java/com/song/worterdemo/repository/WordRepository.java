package com.song.worterdemo.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.WordDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.WordAndSymbol;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import io.reactivex.Observable;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.schedulers.Schedulers;

public class WordRepository {

    private final Executor executor = Executors.newFixedThreadPool(2);  //开线程池
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

    public LiveData<List<WordAndSymbol>> getWordBook(Integer...israw){
        wordAndSymbolLive=dao.getWordBook(israw);
        return wordAndSymbolLive;
    }

    public LiveData<List<WordAndSymbol>> getWordBySymbolId(Integer...symbolId){
        wordAndSymbolLive=dao.getWordBySymbolId(symbolId);
        return wordAndSymbolLive;
    }

    public LiveData<List<WordAndSymbol>> getWordByWordId(Integer...wordId){
        wordAndSymbolLive=dao.getWordByWordId(wordId);
        return wordAndSymbolLive;
    }

    public LiveData<List<WordAndSymbol>> getWordByGroup(Integer...group){
        wordAndSymbolLive=dao.getWordByGroup(group);
        return wordAndSymbolLive;
    }

    public void updateWordIsraw(Integer israw,Integer id){
        executor.execute(()->{
            dao.updateWordIsraw(israw,id);
        });
    }

}
