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

    public LiveData<List<SymbolQuestion>> getSymbolQuestionBySymbolId(Integer... symbolId) {
        return repository.getSymbolQuestionBySymbolId(symbolId);
    }

    public LiveData<List<SymbolQuestion>> getSymbolQuestionById(Integer... id){
        return repository.getSymbolQuestionById(id);
    }

    public void updateSymbolQuestionIsraw(Integer israw,Integer id){
        repository.updateSymbolQuestionIsraw(israw,id);
    }

    public void updateSymbolQuestionIsReview(Integer isreview,Integer id){
        repository.updateSymbolQuestionIsReview(isreview, id);
    }

    public LiveData<List<SymbolQuestion>> getSymbolQuestionIsraw() {
        return repository.getSymbolQuestionIsraw();
    }

    public LiveData<List<SymbolQuestion>> getSymbolQuestionIsreview() {
        return repository.getSymbolQuestionIsreview();
    }
}
