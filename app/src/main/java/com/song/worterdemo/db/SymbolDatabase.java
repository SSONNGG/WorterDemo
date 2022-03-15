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
@Database(entities = {Symbol.class},version = 2,exportSchema = false)
public abstract class SymbolDatabase extends RoomDatabase {
    private static final String SYMBOL_DATABASE = "worter.db";

    //使用单例模式进行访问
    public SymbolDatabase(){

    }

    private static  SymbolDatabase symbolDatabase;
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 因为没有变化，所以是一个空实现
        }
    };


    synchronized public static SymbolDatabase getSymbolDatabase(Context context){
        if(symbolDatabase==null){
            symbolDatabase= Room.databaseBuilder(context.getApplicationContext(),SymbolDatabase.class,SYMBOL_DATABASE)
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return symbolDatabase;
    }

    public abstract SymbolDao getSymbolDao();
}
