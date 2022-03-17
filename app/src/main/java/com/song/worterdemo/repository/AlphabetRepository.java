package com.song.worterdemo.repository;

import android.content.Context;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.AlphabetDao;
import com.song.worterdemo.db.AlphabetDatabase;
import com.song.worterdemo.entity.Alphabet;

import java.util.List;

public class AlphabetRepository {

    private LiveData<List<Alphabet>> alphabetLive;
    private AlphabetDao dao;

    public AlphabetRepository(Context context) {
        AlphabetDatabase database=AlphabetDatabase.getAlphabetDatabase(context.getApplicationContext());
        dao=database.getAlphabetDao();
    }

    public LiveData<List<Alphabet>> getAlphabetLive(){
        alphabetLive=dao.getAllAlphabet();
        return alphabetLive;
    }

    public LiveData<List<Alphabet>> getAlphabetById(Integer... integers){
        alphabetLive=dao.getAlphabetById(integers);
        return alphabetLive;
    }

}
