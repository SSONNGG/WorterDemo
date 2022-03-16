package com.song.worterdemo.manage;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.AlphabetDao;
import com.song.worterdemo.db.AlphabetDatabase;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.AlphabetCapAndLow;

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
            LiveData<List<Alphabet>> allAlphabet=dao.getAllAlphabet();
            //遍历结果

            return null;
        }
    }


    //异步操作
    //getAllCapAndLowAlphabet
    public void getAllCapAndLowAlphabet(){
        new AlphabetEngin.getAllCapAndLowAlphabetTask(dao).execute();

    }

        static class getAllCapAndLowAlphabetTask extends AsyncTask<Void, Void, Void> {

        private AlphabetDao dao;

        public getAllCapAndLowAlphabetTask(AlphabetDao alphabetDao){
            dao=alphabetDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<AlphabetCapAndLow> allAlphabet=dao.getAllCapAndLowAlphabet();
            //遍历结果
            for(AlphabetCapAndLow alphabet:allAlphabet){
                Log.e("TAG", "doInBackground: 查询所有字母大小写"+alphabet.toString());
            }
            return null;
        }

    }

    //异步操作
    //getAlphabetById
    public void getAlphabetById(Integer... integers){
        new AlphabetEngin.getAlphabetByIdTask(dao).execute(integers);
    }

    static class getAlphabetByIdTask extends AsyncTask<Integer,Void,Void> {

        private AlphabetDao dao;

        public getAlphabetByIdTask(AlphabetDao alphabetDao){
            dao=alphabetDao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            List<Alphabet> allAlphabet=dao.getAlphabetById(integers);
            //遍历结果
            for(Alphabet alphabet:allAlphabet){
                Log.e("TAG", "doInBackground: 根据ID查询字母信息"+alphabet.getAlphabetCapital()+alphabet.getAlphabetLower());
            }
            return null;
        }
    }

}
