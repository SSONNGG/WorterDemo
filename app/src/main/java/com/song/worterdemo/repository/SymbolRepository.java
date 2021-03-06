package com.song.worterdemo.repository;

import android.content.Context;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.Symbol;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SymbolRepository {
    private LiveData<List<Symbol>> symbolLive;
    private List<Symbol> symbols;
    private SymbolDao dao;

    public SymbolRepository(Context context) {
        WorterDatabase database=WorterDatabase.getWorterDatabase(context.getApplicationContext());
        dao=database.getSymbolDao();
    }

    public LiveData<List<Symbol>> getSymbolLive() {
        return symbolLive;
    }

    public LiveData<List<Symbol>> getAllSymbolLive(){
        symbolLive=dao.getAllSymbolLive();
        return symbolLive;
    }

    public LiveData<List<Symbol>> getSymbolByGroup(Integer... group){
        symbolLive=dao.getSymbolByGroup(group);
        return symbolLive;

    }

    public LiveData<List<Symbol>> getSymbolByCate(String... cate){
        symbolLive=dao.getSymbolByCate(cate);
        return symbolLive;
    }

    public LiveData<List<Symbol>> getSymbolById(Integer... id){
        symbolLive=dao.getSymbolById(id);
        return symbolLive;
    }








}
