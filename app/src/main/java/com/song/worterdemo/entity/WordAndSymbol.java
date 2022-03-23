package com.song.worterdemo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Relation;

/**
 * 单词和对应音标的一对一关系表
 */
public class WordAndSymbol {

    @ColumnInfo(name = "word_id")
    private int wordId;
    @ColumnInfo(name = "word_content")
    @NonNull
    private String wordContent;
    @ColumnInfo(name = "word_trans")
    @NonNull
    private String wordTrans;
    @ColumnInfo(name = "israw",defaultValue = "0")
    @NonNull
    private int israw;
    @ColumnInfo(name = "uk_symbol")
    private String ukSymbol;
    @ColumnInfo(name = "usa_symbol")
    private String usaSymbol;
    @ColumnInfo(name = "symbol_id")
    @NonNull
    private int symbolId;   //外键
    @ColumnInfo(name = "symbol_content")
    @NonNull
    private String symbolContent;
    @ColumnInfo(name = "symbol_group")
    private int symbolGroup;


    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    @NonNull
    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent(@NonNull String wordContent) {
        this.wordContent = wordContent;
    }

    @NonNull
    public String getWordTrans() {
        return wordTrans;
    }

    public void setWordTrans(@NonNull String wordTrans) {
        this.wordTrans = wordTrans;
    }

    public int getIsraw() {
        return israw;
    }

    public void setIsraw(int israw) {
        this.israw = israw;
    }

    public String getUkSymbol() {
        return ukSymbol;
    }

    public void setUkSymbol(String ukSymbol) {
        this.ukSymbol = ukSymbol;
    }

    public String getUsaSymbol() {
        return usaSymbol;
    }

    public void setUsaSymbol(String usaSymbol) {
        this.usaSymbol = usaSymbol;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    @NonNull
    public String getSymbolContent() {
        return symbolContent;
    }

    public void setSymbolContent(@NonNull String symbolContent) {
        this.symbolContent = symbolContent;
    }

    public int getSymbolGroup() {
        return symbolGroup;
    }

    public void setSymbolGroup(int symbolGroup) {
        this.symbolGroup = symbolGroup;
    }

    @Ignore
    public WordAndSymbol() {
    }

    public WordAndSymbol(int wordId, @NonNull String wordContent, @NonNull String wordTrans, int israw, String ukSymbol, String usaSymbol, int symbolId, @NonNull String symbolContent, int symbolGroup) {
        this.wordId = wordId;
        this.wordContent = wordContent;
        this.wordTrans = wordTrans;
        this.israw = israw;
        this.ukSymbol = ukSymbol;
        this.usaSymbol = usaSymbol;
        this.symbolId = symbolId;
        this.symbolContent = symbolContent;
        this.symbolGroup = symbolGroup;
    }

    @Override
    public String toString() {
        return "WordAndSymbol{" +
                "wordId=" + wordId +
                ", wordContent='" + wordContent + '\'' +
                ", wordTrans='" + wordTrans + '\'' +
                ", israw=" + israw +
                ", ukSymbol='" + ukSymbol + '\'' +
                ", usaSymbol='" + usaSymbol + '\'' +
                ", symbolId=" + symbolId +
                ", symbolContent='" + symbolContent + '\'' +
                ", symbolGroup=" + symbolGroup +
                '}';
    }
}
