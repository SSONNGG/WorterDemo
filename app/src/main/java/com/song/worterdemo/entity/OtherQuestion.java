package com.song.worterdemo.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "other_question")
public class OtherQuestion {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "other_question_id")
    private int otherQuestionId;
    @ColumnInfo(name = "other_question_content")
    @NonNull
    private String otherQuestionContent;
    @ColumnInfo(name = "answer_one")
    @NonNull
    private String answerOne;
    @ColumnInfo(name = "answer_two")
    @NonNull
    private String answerTwo;
    @ColumnInfo(name = "answer_three")
    @NonNull
    private String answerThree;
    @ColumnInfo(name = "answer_four")
    @NonNull
    private String answerFour;
    @ColumnInfo(name = "other_question_answer")
    @NonNull
    private String otherQuestionAnswer;
    @ColumnInfo(name ="other_question_cate" )
    private int otherQuestionCate;
    @ColumnInfo(name = "other_question_israw",defaultValue = "0")
    @NonNull
    private int otherQuestionIsRaw;

    public int getOtherQuestionId() {
        return otherQuestionId;
    }

    public void setOtherQuestionId(int otherQuestionId) {
        this.otherQuestionId = otherQuestionId;
    }

    @NonNull
    public String getOtherQuestionContent() {
        return otherQuestionContent;
    }

    public void setOtherQuestionContent(@NonNull String otherQuestionContent) {
        this.otherQuestionContent = otherQuestionContent;
    }

    @NonNull
    public String getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(@NonNull String answerOne) {
        this.answerOne = answerOne;
    }

    @NonNull
    public String getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(@NonNull String answerTwo) {
        this.answerTwo = answerTwo;
    }

    @NonNull
    public String getAnswerThree() {
        return answerThree;
    }

    public void setAnswerThree(@NonNull String answerThree) {
        this.answerThree = answerThree;
    }

    @NonNull
    public String getAnswerFour() {
        return answerFour;
    }

    public void setAnswerFour(@NonNull String answerFour) {
        this.answerFour = answerFour;
    }

    @NonNull
    public String getOtherQuestionAnswer() {
        return otherQuestionAnswer;
    }

    public void setOtherQuestionAnswer(@NonNull String otherQuestionAnswer) {
        this.otherQuestionAnswer = otherQuestionAnswer;
    }

    public int getOtherQuestionCate() {
        return otherQuestionCate;
    }

    public void setOtherQuestionCate(int otherQuestionCate) {
        this.otherQuestionCate = otherQuestionCate;
    }

    public int getOtherQuestionIsRaw() {
        return otherQuestionIsRaw;
    }

    public void setOtherQuestionIsRaw(int otherQuestionIsRaw) {
        this.otherQuestionIsRaw = otherQuestionIsRaw;
    }

    public OtherQuestion(int otherQuestionId, @NonNull String otherQuestionContent, @NonNull String answerOne, @NonNull String answerTwo, @NonNull String answerThree, @NonNull String answerFour, @NonNull String otherQuestionAnswer, int otherQuestionCate, int otherQuestionIsRaw) {
        this.otherQuestionId = otherQuestionId;
        this.otherQuestionContent = otherQuestionContent;
        this.answerOne = answerOne;
        this.answerTwo = answerTwo;
        this.answerThree = answerThree;
        this.answerFour = answerFour;
        this.otherQuestionAnswer = otherQuestionAnswer;
        this.otherQuestionCate = otherQuestionCate;
        this.otherQuestionIsRaw = otherQuestionIsRaw;
    }

    @Override
    public String toString() {
        return "OtherQuestion{" +
                "otherQuestionId=" + otherQuestionId +
                ", otherQuestionContent='" + otherQuestionContent + '\'' +
                ", answerOne='" + answerOne + '\'' +
                ", answerTwo='" + answerTwo + '\'' +
                ", answerThree='" + answerThree + '\'' +
                ", answerFour='" + answerFour + '\'' +
                ", otherQuestionAnswer='" + otherQuestionAnswer + '\'' +
                ", otherQuestionCate=" + otherQuestionCate +
                ", otherQuestionIsRaw=" + otherQuestionIsRaw +
                '}';
    }
}
