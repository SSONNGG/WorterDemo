package com.song.worterdemo.entity;

/**
 * 文章临时实体类
 */
public class ArticleTempo {

    private String titleMain;
    private String titleSub;
    private String articleContent;



    public String getTitleMain() {
        return titleMain;
    }

    public void setTitleMain(String titleMain) {
        this.titleMain = titleMain;
    }

    public String getTitleSub() {
        return titleSub;
    }

    public void setTitleSub(String titleSub) {
        this.titleSub = titleSub;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public ArticleTempo() {
    }

    public ArticleTempo(String titleMain, String titleSub, String articleContent) {
        this.titleMain = titleMain;
        this.titleSub = titleSub;
        this.articleContent = articleContent;
    }
}
