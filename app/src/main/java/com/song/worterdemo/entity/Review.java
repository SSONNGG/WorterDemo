package com.song.worterdemo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

/**
 * 复习表实体类
 */
@Entity(tableName = "review")
public class Review {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "review_id")
    private int reviewId;

    @ColumnInfo(name = "word_id")
    @NotNull
    private  int wordId;

    @ColumnInfo(name = "review_num")
    private int reviewNum;
    @ColumnInfo(name = "review_israw")
    private int reviewIsraw;

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public int getReviewNum() {
        return reviewNum;
    }

    public void setReviewNum(int reviewNum) {
        this.reviewNum = reviewNum;
    }

    public int getReviewIsraw() {
        return reviewIsraw;
    }

    public void setReviewIsraw(int reviewIsraw) {
        this.reviewIsraw = reviewIsraw;
    }

    public Review(int reviewId, int wordId, int reviewNum, int reviewIsraw) {
        this.reviewId = reviewId;
        this.wordId = wordId;
        this.reviewNum = reviewNum;
        this.reviewIsraw = reviewIsraw;
    }
}
