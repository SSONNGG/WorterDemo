package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.Alphabet;
import com.song.worterdemo.entity.Article;

import java.util.List;

@Dao
public interface ArticleDao {

    //查询所有文章
    @Query("select * from article")
    LiveData<List<Article>> getAllArticle();

    //查询3条文章
    @Query("select * from article limit 3")
    LiveData<List<Article>> getArticleIndex();

}
