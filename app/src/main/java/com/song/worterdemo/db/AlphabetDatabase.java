package com.song.worterdemo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.song.worterdemo.dao.AlphabetDao;
import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.Symbol;

//Alphabet表的数据库管理类
@Database(entities = {Alphabet.class},version = 2,exportSchema = false)
public abstract class AlphabetDatabase extends RoomDatabase {

    private static final String ALPHA_DATABASE = "worter.db";

    //使用单例模式进行访问
    public AlphabetDatabase(){

    }
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 因为没有变化，所以是一个空实现
        }
    };

    private static  AlphabetDatabase alphabetDatabase;


    synchronized public static AlphabetDatabase getAlphabetDatabase(Context context){
        if(alphabetDatabase==null){
            alphabetDatabase= Room.databaseBuilder(context.getApplicationContext(),AlphabetDatabase.class,ALPHA_DATABASE)
                    .addMigrations(MIGRATION_1_2)
                    .allowMainThreadQueries()   //强制开启主线程
                    .build();
        }
        return alphabetDatabase;
    }

    public abstract AlphabetDao getAlphabetDao();
}
