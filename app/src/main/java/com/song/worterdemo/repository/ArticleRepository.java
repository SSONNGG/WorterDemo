package com.song.worterdemo.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.song.worterdemo.dao.ArticleDao;
import com.song.worterdemo.db.WorterDatabase;
import com.song.worterdemo.entity.Article;

import java.util.List;

public class ArticleRepository {

    private LiveData<List<Article>> articleLive;
    private ArticleDao dao;

    public ArticleRepository(Context context) {
        WorterDatabase database=WorterDatabase.getWorterDatabase(context.getApplicationContext());
        dao=database.getArticleDao();
    }

    public LiveData<List<Article>> getAllArticle(){
        articleLive= dao.getAllArticle();
        return articleLive;
    }

    public LiveData<List<Article>> getArticleIndex(){
        articleLive= dao.getArticleIndex();
        return articleLive;
    }

}
