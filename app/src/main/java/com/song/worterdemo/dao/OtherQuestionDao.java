package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.OtherQuestion;
import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;

@Dao
public interface OtherQuestionDao {

    //查询所有题
    @Query("select * from other_question")
    LiveData<List<OtherQuestion>> getAllOtherQuestion();

    //根据ID查询
    @Query("select * from other_question where other_question_id=:id")
    LiveData<List<OtherQuestion>> getOtherQuestionById(Integer... id);

    //按照分类查询
    @Query("select * from other_question where other_question_cate=:category")
    LiveData<List<OtherQuestion>> getOtherQuestionByCate(Integer... category);

    //将题目设为已学习
    @Query("update other_question set other_question_israw=:israw where other_question_id= :id")
    void updateOtherQuestionIsraw(Integer israw,Integer id);

    //查询所有已学习的
    @Query("select * from other_question where other_question_israw=1")
    LiveData<List<OtherQuestion>> getSymbolQuestionIsraw();

}
