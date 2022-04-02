package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.entity.OtherQuestion;
import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.repository.OtherQuestionRepository;

import java.util.List;

public class OtherQuestionViewModel extends AndroidViewModel {
    private OtherQuestionRepository repository;


    public OtherQuestionViewModel(@NonNull Application application) {
        super(application);
        repository=new OtherQuestionRepository(application);
    }

    public LiveData<List<OtherQuestion>> getAllOtherQuestion(){
        return repository.getAllOtherQuestion();
    }

    public LiveData<List<OtherQuestion>> getOtherQuestionById(Integer... id){
        return repository.getOtherQuestionById(id);
    }

    public LiveData<List<OtherQuestion>> getOtherQuestionByCate(Integer... category){
        return repository.getOtherQuestionByCate(category);
    }

    public void updateOtherQuestionIsraw(Integer israw,Integer id){
        repository.updateOtherQuestionIsraw(israw,id);
    }


    public LiveData<List<OtherQuestion>> getSymbolQuestionIsraw(){
        return repository.getSymbolQuestionIsraw();
    }
}
