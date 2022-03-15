package com.song.worterdemo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.dao.WordDao;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.Word;

//Word表的数据库管理类
@Database(entities = {Word.class},version = 2,exportSchema = false)
public abstract class WordDatabase extends RoomDatabase {
    private static final String WORD_DATABASE = "worter.db";

    //使用单例模式进行访问
    public WordDatabase(){

    }

    private static  WordDatabase wordDatabase;
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 因为没有变化，所以是一个空实现
        }
    };


    synchronized public static WordDatabase getWordDatabase(Context context){
        if(wordDatabase==null){
            wordDatabase= Room.databaseBuilder(context.getApplicationContext(),WordDatabase.class,WORD_DATABASE)
                    .addMigrations(MIGRATION_1_2)
                    .build();
        }
        return wordDatabase;
    }

    public abstract WordDao getWordDao();
}
