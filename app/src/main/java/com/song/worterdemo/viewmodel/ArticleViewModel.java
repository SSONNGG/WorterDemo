package com.song.worterdemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.song.worterdemo.entity.Article;
import com.song.worterdemo.repository.ArticleRepository;

import java.util.List;

public class ArticleViewModel extends AndroidViewModel {

    private ArticleRepository repository;


    public ArticleViewModel(@NonNull Application application) {
        super(application);
        repository=new ArticleRepository(application);
    }

    public LiveData<List<Article>> getAllArticle(){
        return repository.getAllArticle();
    }

    public LiveData<List<Article>> getArticleIndex(){
        return repository.getArticleIndex();
    }


}
