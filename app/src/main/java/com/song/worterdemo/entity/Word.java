package com.song.worterdemo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
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
    @NotNull
    private String wordContent;
    @ColumnInfo(name = "word_trans")
    @NotNull
    private String wordTrans;
    @ColumnInfo(name = "israw")
    @NotNull
    private int israw;
    @ColumnInfo(name = "uk_symbol")
    private String ukSymbol;
    @ColumnInfo(name = "usa_symbol")
    private String usaSymbol;
    @ColumnInfo(name = "word_categories")
    @NotNull
    private int wordCategories;

    @ColumnInfo(name = "symbol_id")
    private int symbolId;   //外键



    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    @NotNull
    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent(@NotNull String wordContent) {
        this.wordContent = wordContent;
    }

    @NotNull
    public String getWordTrans() {
        return wordTrans;
    }

    public void setWordTrans(@NotNull String wordTrans) {
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

    public int getWordCategories() {
        return wordCategories;
    }

    public void setWordCategories(int wordCategories) {
        this.wordCategories = wordCategories;
    }

    public Word(int wordId, @NotNull String wordContent, @NotNull String wordTrans, int israw, String ukSymbol, String usaSymbol, int symbolId, int wordCategories) {
        this.wordId = wordId;
        this.wordContent = wordContent;
        this.wordTrans = wordTrans;
        this.israw = israw;
        this.ukSymbol = ukSymbol;
        this.usaSymbol = usaSymbol;
        this.symbolId = symbolId;
        this.wordCategories = wordCategories;
    }
}
