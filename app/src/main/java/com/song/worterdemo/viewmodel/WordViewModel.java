package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.Word;
import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.repository.WordRepository;

import java.util.List;
import java.util.Map;

public class WordViewModel extends AndroidViewModel {
    private WordRepository repository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        repository=new WordRepository(application);
    }

    public LiveData<List<WordAndSymbol>> getWordAndSymbol(){
        return repository.getWordAndSymbol();
    }

    public LiveData<List<WordAndSymbol>> getWordBook(Integer... israw){
        return  repository.getWordBook(israw);
    }

    public LiveData<List<WordAndSymbol>> getWordBySymbolId(Integer... symbolId){
        return  repository.getWordBySymbolId(symbolId);
    }

    public LiveData<List<WordAndSymbol>> getWordByWordId(Integer... wordId){
        return  repository.getWordByWordId(wordId);
    }

    public LiveData<List<WordAndSymbol>> getWordByWordGroup(Integer... group){
        return  repository.getWordByGroup(group);
    }

    public void updateWordIsraw(Integer israw,Integer id){
        repository.updateWordIsraw(israw, id);
    }


}
