package com.song.worterdemo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.entity.Symbol;

//Symbol表的数据库管理类
@Database(entities = {Symbol.class},version = 1,exportSchema = false)
public abstract class SymbolDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "worter.db";

    //使用单例模式进行访问
    public SymbolDatabase(){

    }

    private static  SymbolDatabase symbolDatabase;


    synchronized public static SymbolDatabase getSymbolDatabase(Context context){
        if(symbolDatabase==null){
            symbolDatabase= Room.databaseBuilder(context.getApplicationContext(),SymbolDatabase.class,DATABASE_NAME)
                    .build();
        }
        return symbolDatabase;
    }

    public abstract SymbolDao getSymbolDao();
}
