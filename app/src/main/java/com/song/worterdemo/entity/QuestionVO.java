package com.song.worterdemo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

import org.jetbrains.annotations.NotNull;

public class QuestionVO {
    @ColumnInfo(name = "symbol_id")
    @NonNull
    private int symbolId;
    @ColumnInfo(name = "symbol_content")
    @NonNull
    private String symbolContent;
    @ColumnInfo(name = "symbol_alphabet")
    private String symbolAlphabet;
    @ColumnInfo(name = "symbol_pronun")
    @NonNull
    private String symbolPronun;
    @ColumnInfo(name = "symbol_group")
    private int symbolGroup;
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

    public String getSymbolAlphabet() {
        return symbolAlphabet;
    }

    public void setSymbolAlphabet(String symbolAlphabet) {
        this.symbolAlphabet = symbolAlphabet;
    }

    @NonNull
    public String getSymbolPronun() {
        return symbolPronun;
    }

    public void setSymbolPronun(@NonNull String symbolPronun) {
        this.symbolPronun = symbolPronun;
    }

    public int getSymbolGroup() {
        return symbolGroup;
    }

    public void setSymbolGroup(int symbolGroup) {
        this.symbolGroup = symbolGroup;
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

    public QuestionVO(int symbolId, @NonNull String symbolContent, String symbolAlphabet, @NonNull String symbolPronun, int symbolGroup, @NotNull String symbolQuestionContent, @NotNull String answerOne, @NotNull String answerTwo, @NotNull String answerThree, @NotNull String answerFour, @NotNull String symbolQuestionAnswer) {
        this.symbolId = symbolId;
        this.symbolContent = symbolContent;
        this.symbolAlphabet = symbolAlphabet;
        this.symbolPronun = symbolPronun;
        this.symbolGroup = symbolGroup;
        this.symbolQuestionContent = symbolQuestionContent;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.symbolQuestionAnswer = symbolQuestionAnswer;
    }

    @Override
    public String toString() {
        return "QuestionVO{" +
                "symbolId=" + symbolId +
                ", symbolContent='" + symbolContent + '\'' +
                ", symbolAlphabet='" + symbolAlphabet + '\'' +
                ", symbolPronun='" + symbolPronun + '\'' +
                ", symbolGroup=" + symbolGroup +
                ", symbolQuestionContent='" + symbolQuestionContent + '\'' +
                ", answerOne='" + answerOne + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", answerThree='" + answerThree + '\'' +
                ", answerFour='" + answerFour + '\'' +
                ", symbolQuestionAnswer='" + symbolQuestionAnswer + '\'' +
                '}';
    }
}
