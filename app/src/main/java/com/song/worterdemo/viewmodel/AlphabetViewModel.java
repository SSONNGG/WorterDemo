package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.repository.AlphabetRepository;

import java.util.List;

public class AlphabetViewModel extends AndroidViewModel {


    private AlphabetRepository repository;

    public AlphabetViewModel(@NonNull Application application) {
        super(application);
        repository=new AlphabetRepository(application);
    }

    public LiveData<List<Alphabet>> getAlphabetLive(){
        return repository.getAlphabetLive();
    }

    public LiveData<List<Alphabet>> getAlphabetById(Integer...integers){
        return repository.getAlphabetById(integers);
    }

}
