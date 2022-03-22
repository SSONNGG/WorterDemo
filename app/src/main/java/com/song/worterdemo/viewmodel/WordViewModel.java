package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.entity.WordAndSymbol;
import com.song.worterdemo.repository.WordRepository;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository repository;

    public WordViewModel(@NonNull Application application) {
        super(application);
        repository=new WordRepository(application);
    }

    public LiveData<List<WordAndSymbol>> getWordAndSymbol(){
        return repository.getWordAndSymbol();
    }

}
