package com.song.worterdemo.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * 音标表的实体类
 */
@Entity(tableName = "symbol")
public class Symbol {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="symbol_id")
    private int symbolId;

    @ColumnInfo(name = "symbol_content")
    @NonNull
    private String symbolContent;
    @ColumnInfo(name = "symbol_group")
    private int symbolGroup;
    @ColumnInfo(name = "symbol_islearn",defaultValue = "0")
    private int symbolIslearn;
    @ColumnInfo(name = "symbol_alphabet")
    private String symbolAlphabet;
    @ColumnInfo(name = "symbol_pronun")
    @NonNull
    private String symbolPronun;
    @ColumnInfo(name = "symbol_categories")
    @NonNull
    private String symbolCategories;

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    public String getSymbolContent() {
        return symbolContent;
    }

    public void setSymbolContent(String symbolContent) {
        this.symbolContent = symbolContent;
    }

    public int getSymbolGroup() {
        return symbolGroup;
    }

    public void setSymbolGroup(int symbolGroup) {
        this.symbolGroup = symbolGroup;
    }

    public int getSymbolIslearn() {
        return symbolIslearn;
    }

    public void setSymbolIslearn(int symbolIslearn) {
        this.symbolIslearn = symbolIslearn;
    }

    public String getSymbolAlphabet() {
        return symbolAlphabet;
    }

    public void setSymbolAlphabet(String symbolAlphabet) {
        this.symbolAlphabet = symbolAlphabet;
    }

    public String getSymbolPronun() {
        return symbolPronun;
    }

    public void setSymbolPronun(String symbolPronun) {
        this.symbolPronun = symbolPronun;
    }

    public String getSymbolCategories() {
        return symbolCategories;
    }

    public void setSymbolCategories(String symbolCategories) {
        this.symbolCategories = symbolCategories;
    }

    public Symbol(int symbolId, String symbolContent, int symbolGroup, int symbolIslearn, String symbolAlphabet, String symbolPronun, String symbolCategories) {
        this.symbolId = symbolId;
        this.symbolContent = symbolContent;
        this.symbolGroup = symbolGroup;
        this.symbolIslearn = symbolIslearn;
        this.symbolAlphabet = symbolAlphabet;
        this.symbolPronun = symbolPronun;
        this.symbolCategories = symbolCategories;
    }

    @Override
    public String toString() {
        return "Symbol{" +
                "symbolId=" + symbolId +
                ", symbolContent='" + symbolContent + '\'' +
                ", symbolGroup=" + symbolGroup +
                ", symbolIslearn=" + symbolIslearn +
                ", symbolAlphabet='" + symbolAlphabet + '\'' +
                ", symbolPronun='" + symbolPronun + '\'' +
                ", symbolCategories='" + symbolCategories + '\'' +
                '}';
    }
}
