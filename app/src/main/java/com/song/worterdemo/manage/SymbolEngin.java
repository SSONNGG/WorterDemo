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
        new getAllAsyncTask(dao).execute();
    }

    static class getAllAsyncTask extends AsyncTask<Void,Void,Void> {

        private SymbolDao dao;

        public getAllAsyncTask(SymbolDao symbolDao){
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

}
