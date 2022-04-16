package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.QuestionVO;
import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;

@Dao
public interface SymbolQuestionDao {

    //查询所有题
    @Query("select * from symbol_question")
    public LiveData<List<SymbolQuestion>> getAllSymbolQuestion();

    //根据音标ID查询题目
    @Query("select * from symbol_question where symbol_id= :symbolId")
    LiveData<List<SymbolQuestion>> getSymbolQuestionBySymbolId(Integer... symbolId);

    //根据题目ID查询
    @Query("select * from symbol_question where symbol_question_id= :questionId")
    LiveData<List<SymbolQuestion>> getSymbolQuestionById(Integer... questionId);

    //根据ID修改题目为已学习
    @Query("update symbol_question set symbol_question_israw=:israw where symbol_question_id= :id")
    public void updateSymbolQuestionIsraw(Integer israw,Integer id);

    //根据ID修改题目为已复习
    @Query("update symbol_question set symbol_question_isreview=:isreview where symbol_question_id= :id")
    public void updateSymbolQuestionIsReview(Integer isreview,Integer id);

    //查询所有已学习的
    @Query("select * from symbol_question where symbol_question_israw=1")
    LiveData<List<SymbolQuestion>> getSymbolQuestionIsraw();

    //查询所有已复习的
    @Query("select * from symbol_question where symbol_question_isreview=1")
    LiveData<List<SymbolQuestion>> getSymbolQuestionIsreview();

    //已学习中需要复习的
    @Query("select * from symbol_question where symbol_question_israw=1 and symbol_question_isreview=0")
    LiveData<List<SymbolQuestion>> getSymbolQuestionNeedReview();

    //根据音标组开始学习
    @Query("select symbol.symbol_id,symbol_content,symbol_group,symbol_alphabet,symbol_pronun," +
            "symbol_question_content,answer_one,answer_two,answer_three," +
            "answer_four, symbol_question_answer " +
            "from symbol,symbol_question " +
            "where symbol.symbol_id=symbol_question.symbol_id and symbol_group=:group")
    LiveData<List<QuestionVO>> getSymbolQuestionStudyByGroup(Integer... group);

    //根据音标ID查询题目,不适用LiveData
    @Query("select * from symbol_question where symbol_id= :symbolId")
    List<SymbolQuestion> getSymbolQuestionListBySymbolId(Integer... symbolId);
}
