package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.ReviewQuestion;
import com.song.worterdemo.entity.ReviewVO;
import com.song.worterdemo.entity.SymbolQuestion;

import java.util.List;

@Dao
public interface ReviewQuestionDao {

    //查询所有题
    @Query("select * from review_question")
    public LiveData<List<ReviewQuestion>> getAllReviewQuestion();

    //联合信息查询
    @Query("select review_id,word_id,word_content,answer_one,answer_two,answer_three,answer_four,review_answer,israw,symbol.symbol_id," +
            "symbol_content,symbol_group,symbol_islearn,symbol_alphabet,symbol_pronun " +
            "from review_question,symbol where review_question.symbol_id=symbol.symbol_id")
    public LiveData<List<ReviewVO>> getAllReviewQuestionAndSymbol();

    //根据音标组查询
    @Query("select review_id,word_id,word_content,answer_one,answer_two,answer_three,answer_four,review_answer,israw,symbol.symbol_id," +
            "symbol_content,symbol_group,symbol_islearn,symbol_alphabet,symbol_pronun " +
            "from review_question,symbol where review_question.symbol_id=symbol.symbol_id and symbol_group= :group")
    public LiveData<List<ReviewVO>> getReviewQuestionAndSymbolByGroup(Integer... group);

    //根据音标组修改复习题为待复习    //修改israw为1
    @Query("update review_question set israw=:israw where review_question.symbol_id=" +
            "(select symbol_id from symbol where symbol.symbol_id=review_question.symbol_id " +
            "and symbol_group=:group)")
    public void updateReviewIsraw(Integer israw,Integer group);

    //根据ID修改复习题为已复习     //根据ID修改israw为0
    @Query("update review_question set israw=0 where review_id=:id")
    public void updateReviewFinish(Integer id);

    //查询所有待复习的题目
    @Query("select review_id,word_id,word_content,answer_one,answer_two,answer_three,answer_four,review_answer,israw,symbol.symbol_id," +
            "symbol_content,symbol_group,symbol_islearn,symbol_alphabet,symbol_pronun " +
            "from review_question,symbol where review_question.symbol_id=symbol.symbol_id and israw=1")
    public LiveData<List<ReviewVO>> getReviewQuestion();

}
