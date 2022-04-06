package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.repository.SymbolRepository;

import java.util.List;

public class SymbolViewModel extends AndroidViewModel {
    private SymbolRepository repository;

    public SymbolViewModel(@NonNull Application application) {
        super(application);
        repository=new SymbolRepository(application);
    }

    public LiveData<List<Symbol>> getAllSymbolLive(){
        return repository.getAllSymbolLive();
    }

    public LiveData<List<Symbol>> getSymbolByGroup(Integer... group){
        return repository.getSymbolByGroup(group);
    }

    public LiveData<List<Symbol>> getSymbolByCate(String... cate){
       return repository.getSymbolByCate(cate);
    }

    public LiveData<List<Symbol>> getSymbolById(Integer... id){
        return repository.getSymbolById(id);
    }

}
