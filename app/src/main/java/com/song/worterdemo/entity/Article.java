package com.song.worterdemo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "article")
public class Article implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "article_id")
    private int articleId;
    @ColumnInfo(name="article_title")
    private String articleTitle;
    @ColumnInfo(name="article_subtitle")
    private String articleSubTitle;
    @ColumnInfo(name="article_content")
    private String articleContent;

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleSubTitle() {
        return articleSubTitle;
    }

    public void setArticleSubTitle(String articleSubTitle) {
        this.articleSubTitle = articleSubTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public Article(int articleId, String articleTitle, String articleSubTitle, String articleContent) {
        this.articleId = articleId;
        this.articleTitle = articleTitle;
        this.articleSubTitle = articleSubTitle;
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleId=" + articleId +
                ", articleTitle='" + articleTitle + '\'' +
                ", articleSubTitle='" + articleSubTitle + '\'' +
                ", articleContent='" + articleContent + '\'' +
                '}';
    }
}
