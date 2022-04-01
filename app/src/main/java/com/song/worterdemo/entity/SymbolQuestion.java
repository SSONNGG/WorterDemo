package com.song.worterdemo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "symbol_question")
public class SymbolQuestion {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "symbol_question_id")
    private int symbolQuestionId;

    @ColumnInfo(name = "symbol_question_content")
    @NotNull
    private String symbolQuestionContent;

    @ColumnInfo(name = "answer_one")
    @NotNull
    private String answerOne;

    @ColumnInfo(name = "answer_two")
    @NotNull
    private String answerTwo;

    @ColumnInfo(name = "answer_three")
    @NotNull
    private String answerThree;

    @ColumnInfo(name = "answer_four")
    @NotNull
    private String answerFour;

    @ColumnInfo(name = "symbol_question_answer")
    @NotNull
    private String symbolQuestionAnswer;

    @ColumnInfo(name = "symbol_id")
    private int symbolId;

    @ColumnInfo(name = "symbol_question_israw",defaultValue = "0")
    private int symbolQuestionIsraw;

    @ColumnInfo(name = "symbol_question_isreview",defaultValue = "0")
    private int symbolQuestionIsreview;

    public int getSymbolQuestionId() {
        return symbolQuestionId;
    }

    public void setSymbolQuestionId(int symbolQuestionId) {
        this.symbolQuestionId = symbolQuestionId;
    }

    @NotNull
    public String getSymbolQuestionContent() {
        return symbolQuestionContent;
    }

    public void setSymbolQuestionContent(@NotNull String symbolQuestionContent) {
        this.symbolQuestionContent = symbolQuestionContent;
    }

    @NotNull
    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(@NotNull String answerOne) {
        this.answerOne = answerOne;
    }

    @NotNull
    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(@NotNull String answerTwo) {
        this.answerTwo = answerTwo;
    }

    @NotNull
    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(@NotNull String answerThree) {
        this.answerThree = answerThree;
    }

    @NotNull
    public String getAnswerFour() {
        return answerFour;
    }

    public void setAnswerFour(@NotNull String answerFour) {
        this.answerFour = answerFour;
    }

    @NotNull
    public String getSymbolQuestionAnswer() {
        return symbolQuestionAnswer;
    }

    public void setSymbolQuestionAnswer(@NotNull String symbolQuestionAnswer) {
        this.symbolQuestionAnswer = symbolQuestionAnswer;
    }

    public int getSymbolId() {
        return symbolId;
    }

    public void setSymbolId(int symbolId) {
        this.symbolId = symbolId;
    }

    public int getSymbolQuestionIsraw() {
        return symbolQuestionIsraw;
    }

    public void setSymbolQuestionIsraw(int symbolQuestionIsraw) {
        this.symbolQuestionIsraw = symbolQuestionIsraw;
    }

    public int getSymbolQuestionIsreview() {
        return symbolQuestionIsreview;
    }

    public void setSymbolQuestionIsreview(int symbolQuestionIsreview) {
        this.symbolQuestionIsreview = symbolQuestionIsreview;
    }

    public SymbolQuestion(int symbolQuestionId, @NotNull String symbolQuestionContent, @NotNull String answerOne, @NotNull String answerTwo, @NotNull String answerThree, @NotNull String answerFour, @NotNull String symbolQuestionAnswer, int symbolId, int symbolQuestionIsraw, int symbolQuestionIsreview) {
        this.symbolQuestionId = symbolQuestionId;
        this.symbolQuestionContent = symbolQuestionContent;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.symbolQuestionAnswer = symbolQuestionAnswer;
        this.symbolId = symbolId;
        this.symbolQuestionIsraw = symbolQuestionIsraw;
        this.symbolQuestionIsreview = symbolQuestionIsreview;
    }

    @Override
    public String toString() {
        return "SymbolQuestion{" +
                "symbolQuestionId=" + symbolQuestionId +
                ", symbolQuestionContent='" + symbolQuestionContent + '\'' +
                ", answerOne='" + answerOne + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", answerThree='" + answerThree + '\'' +
                ", answerFour='" + answerFour + '\'' +
                ", symbolQuestionAnswer='" + symbolQuestionAnswer + '\'' +
                ", symbolId=" + symbolId +
                ", symbolQuestionIsraw=" + symbolQuestionIsraw +
                ", symbolQuestionIsreview=" + symbolQuestionIsreview +
                '}';
    }
}
