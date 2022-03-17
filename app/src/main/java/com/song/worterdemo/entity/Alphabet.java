package com.song.worterdemo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * 字母实体类
 */
@Entity(tableName = "alphabet")
public class Alphabet {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "alphabet_id")
    private int alphabetId;

    @ColumnInfo(name = "alphabet_capital")
    @NonNull
    private String alphabetCapital;
    @ColumnInfo(name = "alphabet_lower")
    @NonNull
    private String alphabetLower;

    @ColumnInfo(name = "alphabet_pronun")
    @NonNull
    private String alphabetPronun;

    @ColumnInfo(name = "alphabet_from")
    @NonNull
    private String alphabetFrom;

    @ColumnInfo(name = "alphabet_isvowel")
    private int alphabetIsvowel;

    public int getAlphabetId() {
        return alphabetId;
    }

    public void setAlphabetId(int alphabetId) {
        this.alphabetId = alphabetId;
    }

    @NotNull
    public String getAlphabetCapital() {
        return alphabetCapital;
    }

    public void setAlphabetCapital(@NotNull String alphabetCapital) {
        this.alphabetCapital = alphabetCapital;
    }

    @NotNull
    public String getAlphabetLower() {
        return alphabetLower;
    }

    public void setAlphabetLower(@NotNull String alphabetLower) {
        this.alphabetLower = alphabetLower;
    }

    public String getAlphabetPronun() {
        return alphabetPronun;
    }

    public void setAlphabetPronun(String alphabetPronun) {
        this.alphabetPronun = alphabetPronun;
    }
    public String getAlphabetFrom() {
        return alphabetFrom;
    }

    public void setAlphabetFrom( String alphabetFrom) {
        this.alphabetFrom = alphabetFrom;
    }

    public int getAlphabetIsvowel() {
        return alphabetIsvowel;
    }

    public void setAlphabetIsvowel(int alphabetIsvowel) {
        this.alphabetIsvowel = alphabetIsvowel;
    }

    public Alphabet(int alphabetId, @NotNull String alphabetCapital, @NotNull String alphabetLower, String alphabetPronun, String alphabetFrom, int alphabetIsvowel) {
        this.alphabetId = alphabetId;
        this.alphabetCapital = alphabetCapital;
        this.alphabetLower = alphabetLower;
        this.alphabetPronun = alphabetPronun;
        this.alphabetFrom = alphabetFrom;
        this.alphabetIsvowel = alphabetIsvowel;
    }

    @Override
    public String toString() {
        return "Alphabet{" +
                "alphabetId=" + alphabetId +
                ", alphabetCapital='" + alphabetCapital + '\'' +
                ", alphabetLower='" + alphabetLower + '\'' +
                ", alphabetPronun='" + alphabetPronun + '\'' +
                ", alphabetFrom='" + alphabetFrom + '\'' +
                ", alphabetIsvowel=" + alphabetIsvowel +
                '}';
    }
}
