package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.repository.SymbolQuestionRepository;

import java.util.List;

public class SymbolQuestionViewModel extends AndroidViewModel {
    private SymbolQuestionRepository repository;


    public SymbolQuestionViewModel(@NonNull Application application) {
        super(application);
        repository=new SymbolQuestionRepository(application);
    }

    public LiveData<List<SymbolQuestion>> getAllSymbolQuestion(){
        return repository.getAllSymbolQuestion();
    }
}
