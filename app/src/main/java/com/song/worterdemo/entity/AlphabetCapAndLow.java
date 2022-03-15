package com.song.worterdemo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

/**
 * 大小写字母专用字段
 */
public class AlphabetCapAndLow {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "alphabet_id")
    private int alphabetId;

    @ColumnInfo(name = "alphabet_capital")
    @NonNull
    private String alphabetCapital;
    @ColumnInfo(name = "alphabet_lower")
    @NonNull
    private String alphabetLower;


    public int getAlphabetId() {
        return alphabetId;
    }

    public void setAlphabetId(int alphabetId) {
        this.alphabetId = alphabetId;
    }

    @NonNull
    public String getAlphabetCapital() {
        return alphabetCapital;
    }

    public void setAlphabetCapital(@NonNull String alphabetCapital) {
        this.alphabetCapital = alphabetCapital;
    }

    @NonNull
    public String getAlphabetLower() {
        return alphabetLower;
    }

    public void setAlphabetLower(@NonNull String alphabetLower) {
        this.alphabetLower = alphabetLower;
    }

    public AlphabetCapAndLow(int alphabetId, @NonNull String alphabetCapital, @NonNull String alphabetLower) {
        this.alphabetId = alphabetId;
        this.alphabetCapital = alphabetCapital;
        this.alphabetLower = alphabetLower;
    }

    @Override
    public String toString() {
        return "AlphabetCapAndLow{" +
                "alphabetId=" + alphabetId +
                ", alphabetCapital='" + alphabetCapital + '\'' +
                ", alphabetLower='" + alphabetLower + '\'' +
                '}';
    }
}
