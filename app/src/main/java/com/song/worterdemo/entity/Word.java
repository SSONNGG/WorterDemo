package com.song.worterdemo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * 单词表实体类
 */
@Entity(tableName = "word")
public class Word {

    @PrimaryKey(autoGenerate = true)
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
    @ColumnInfo(name = "word_categories")
    @NonNull
    private int wordCategories;


    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent( String wordContent) {
        this.wordContent = wordContent;
    }

    public String getWordTrans() {
        return wordTrans;
    }

    public void setWordTrans( String wordTrans) {
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

    public void setSymbolId( int symbolId) {
        this.symbolId = symbolId;
    }

    public int getWordCategories() {
        return wordCategories;
    }

    public void setWordCategories(int wordCategories) {
        this.wordCategories = wordCategories;
    }

    public Word(int wordId,  String wordContent,  String wordTrans, int israw, String ukSymbol, String usaSymbol, int symbolId, int wordCategories) {
        this.wordId = wordId;
        this.wordContent = wordContent;
        this.wordTrans = wordTrans;
        this.israw = israw;
        this.ukSymbol = ukSymbol;
        this.usaSymbol = usaSymbol;
        this.symbolId = symbolId;
        this.wordCategories = wordCategories;
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordId=" + wordId +
                ", wordContent='" + wordContent + '\'' +
                ", wordTrans='" + wordTrans + '\'' +
                ", israw=" + israw +
                ", ukSymbol='" + ukSymbol + '\'' +
                ", usaSymbol='" + usaSymbol + '\'' +
                ", symbolId=" + symbolId +
                ", wordCategories=" + wordCategories +
                '}';
    }
}
