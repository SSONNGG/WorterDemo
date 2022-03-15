package com.song.worterdemo.manage;


import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.db.SymbolDatabase;
import com.song.worterdemo.entity.Symbol;

import java.util.List;

//Symbol的DB引擎
public class SymbolEngin {

    private SymbolDao dao;

    public SymbolEngin(Context context){
        SymbolDatabase db=SymbolDatabase.getSymbolDatabase(context);
        dao=db.getSymbolDao();
    }

    //异步操作
    //getAllSymbol
    public void getAllSymbol(){
        new getAllSymbolAsyncTask(dao).execute();
    }

    static class getAllSymbolAsyncTask extends AsyncTask<Void,Void,Void> {

        private SymbolDao dao;

        public getAllSymbolAsyncTask(SymbolDao symbolDao){
            dao=symbolDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            List<Symbol> allsymbol=dao.getAllSymbol();
            //遍历结果
            for(Symbol symbol:allsymbol){
                Log.e("TAG", "doInBackground: 查询所有"+symbol.toString());
            }
            return null;
        }
    }

    //getSymbolByGroup
    public void getSymbolByGroup(Integer...integers){
        new getSymbolByGroupTask(dao).execute(integers);
    }

    static class getSymbolByGroupTask extends AsyncTask<Integer,Void,Void> {

        private SymbolDao dao;

        public getSymbolByGroupTask(SymbolDao symbolDao){
            dao=symbolDao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            List<String> allsymbol=dao.getSymbolByGroup(integers);
            //遍历结果
            for(String symbol:allsymbol){
                Log.e("TAG", "doInBackground: 按照组别查询"+symbol.toString());
            }
            return null;
        }
    }

    //getSymbolByCate
    public void getSymbolByCate(String...categories){
        new getSymbolByCateTask(dao).execute(categories);
    }

    static class getSymbolByCateTask extends AsyncTask<String,Void,Void> {

        private SymbolDao dao;

        public getSymbolByCateTask(SymbolDao symbolDao){
            dao=symbolDao;
        }

        @Override
        protected Void doInBackground(String... strings) {
            List<String> allsymbol=dao.getSymbolByCate(strings);
            //遍历结果
            for(String symbol:allsymbol){
                Log.e("TAG", "doInBackground: 按照分类查询"+symbol.toString());
            }
            return null;
        }
    }

    //getSymbolById
    public void getSymbolById(Integer...integers){
        new getSymbolByIdTask(dao).execute(integers);
    }

    static class getSymbolByIdTask extends AsyncTask<Integer,Void,Void> {

        private SymbolDao dao;

        public getSymbolByIdTask(SymbolDao symbolDao){
            dao=symbolDao;
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            List<Symbol> allsymbol=dao.getSymbolById(integers);
            //遍历结果
            for(Symbol symbol:allsymbol){
                Log.e("TAG", "doInBackground: 按照ID查询"+symbol.toString());
            }
            return null;
        }
    }

}
