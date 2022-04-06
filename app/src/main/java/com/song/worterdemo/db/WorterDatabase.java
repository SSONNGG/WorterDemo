package com.song.worterdemo.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.song.worterdemo.dao.AlphabetDao;
import com.song.worterdemo.dao.ArticleDao;
import com.song.worterdemo.dao.OtherQuestionDao;
import com.song.worterdemo.dao.SymbolDao;
import com.song.worterdemo.dao.SymbolQuestionDao;
import com.song.worterdemo.dao.WordDao;
import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.Article;
import com.song.worterdemo.entity.OtherQuestion;
import com.song.worterdemo.entity.Review;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.SymbolQuestion;
import com.song.worterdemo.entity.Word;
import com.song.worterdemo.entity.WordAndSymbol;

import java.io.File;

//Alphabet表的数据库管理类
@Database(entities = {Alphabet.class, Symbol.class,Word.class, SymbolQuestion.class, OtherQuestion.class, Article.class},version = 2,exportSchema = false)
public abstract class WorterDatabase extends RoomDatabase {

    private static final String ALPHA_DATABASE = "worter.db";

    //使用单例模式进行访问
    public WorterDatabase(){

    }
    private static WorterDatabase database;
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // 因为没有变化，所以是一个空实现
            database.execSQL("");
        }
    };

    synchronized public static WorterDatabase getWorterDatabase(Context context){
        if(database==null){
            database= Room.databaseBuilder(context.getApplicationContext(),WorterDatabase.class,ALPHA_DATABASE)
                    .addMigrations(MIGRATION_1_2)
                    //.allowMainThreadQueries()   //强制开启主线程
                    .build();
        }
        return database;
    }

    public abstract AlphabetDao getAlphabetDao();

    public abstract SymbolDao getSymbolDao();

    public abstract WordDao getWordDao();

    public abstract SymbolQuestionDao getSymbolQuestionDao();

    public abstract OtherQuestionDao getOtherQuestionDao();

    public abstract ArticleDao getArticleDao();

}
