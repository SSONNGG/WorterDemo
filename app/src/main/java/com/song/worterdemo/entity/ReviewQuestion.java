package com.song.worterdemo.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "review_question")
public class ReviewQuestion {

    @ColumnInfo(name = "review_id")
    @PrimaryKey(autoGenerate = true)
    private int reviewId;

    @ColumnInfo(name = "word_id")
    @NotNull
    private int wordId;

    @ColumnInfo(name = "word_content")
    private String wordContent;

    @ColumnInfo(name = "answer_one")
    private String answerOne;

    @ColumnInfo(name = "answer_two")
    private String answerTwo;

    @ColumnInfo(name = "answer_three")
    private String answerThree;

    @ColumnInfo(name = "answer_four")
    private String answerFour;

    @ColumnInfo(name = "review_answer")
    private String reviewAnswer;

    @ColumnInfo(name = "israw")
    @NotNull
    private int israw;

    @ColumnInfo(name = "symbol_id")
    @NotNull
    private int symbolId;

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

    public String getWordContent() {
        return wordContent;
    }

    public void setWordContent(String wordContent) {
        this.wordContent = wordContent;
    }

    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(String answerOne) {
        this.answerOne = answerOne;
    }

    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(String answerTwo) {
        this.answerTwo = answerTwo;
    }

    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(String answerThree) {
        this.answerThree = answerThree;
    }

    public String getAnswerFour() {
        return answerFour;
    }

    public void setAnswerFour(String answerFour) {
        this.answerFour = answerFour;
    }

    public String getReviewAnswer() {
        return reviewAnswer;
    }

    public void setReviewAnswer(String reviewAnswer) {
        this.reviewAnswer = reviewAnswer;
    }

    public int getIsraw() {
        return israw;
    }

    public void setIsraw(int israw) {
        this.israw = israw;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    public ReviewQuestion(int reviewId, int wordId, String wordContent, String answerOne, String answerTwo, String answerThree, String answerFour, String reviewAnswer, int israw, int symbolId) {
        this.reviewId = reviewId;
        this.wordId = wordId;
        this.wordContent = wordContent;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.reviewAnswer = reviewAnswer;
        this.israw = israw;
        this.symbolId = symbolId;
    }

    @Override
    public String toString() {
        return "ReviewQuestion{" +
                "reviewId=" + reviewId +
                ", wordId=" + wordId +
                ", wordContent='" + wordContent + '\'' +
                ", answerOne='" + answerOne + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", answerThree='" + answerThree + '\'' +
                ", answerFour='" + answerFour + '\'' +
                ", reviewAnswer='" + reviewAnswer + '\'' +
                ", israw=" + israw +
                ", symbolId=" + symbolId +
                '}';
    }
}
