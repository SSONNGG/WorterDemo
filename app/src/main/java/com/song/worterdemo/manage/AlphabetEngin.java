package com.song.worterdemo.manage;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.song.worterdemo.dao.AlphabetDao;
import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.db.AlphabetDatabase;
import com.song.worterdemo.db.SymbolDatabase;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.Symbol;

import java.util.List;

public class AlphabetEngin {

    private AlphabetDao dao;

    public AlphabetEngin(Context context){
        AlphabetDatabase db=AlphabetDatabase.getAlphabetDatabase(context);
        dao=db.getAlphabetDao();
    }

    //异步操作
    //getAllAlphabet
    public void getAllAlphabet(){
        new AlphabetEngin.getAllAlphabetTask(dao).execute();
    }

    static class getAllAlphabetTask extends AsyncTask<Void,Void,Void> {

        private AlphabetDao dao;

        public getAllAlphabetTask(AlphabetDao alphabetDao){
            dao=alphabetDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Alphabet> allAlphabet=dao.getAllAlphabet();
            //遍历结果
            for(Alphabet alphabet:allAlphabet){
                Log.e("TAG", "doInBackground: 查询所有字母"+alphabet.toString());
            }
            return null;
        }
    }

}
