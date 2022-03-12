package com.song.worterdemo.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.db.SymbolDatabase;
import com.song.worterdemo.entity.Symbol;

import java.util.List;

/**
 * View层，实例化数据库并对外暴露LiveData
 */
public class SymbolViewModel extends AndroidViewModel {
    private SymbolDatabase database;
    //利用liveData进行包装
    private LiveData<List<Symbol>> listLiveData;


    public SymbolViewModel(@NonNull Application application) {
        super(application);
        //初始化数据库实例
        database=SymbolDatabase.getSymbolDatabase(application);
        listLiveData=database.getSymbolDao().getAllSymbol();
    }

    public LiveData<List<Symbol>> getListLiveData(){
        return listLiveData;
    }
}
