package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Index;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.song.worterdemo.entity.Symbol;
import com.song.worterdemo.entity.Word;
import com.song.worterdemo.entity.WordAndSymbol;

import java.util.List;
import java.util.Map;

@Dao    //单词数据库访问接口
public interface WordDao {

    @Query("select word_id,word_content,word_trans,israw,uk_symbol,usa_symbol,word.symbol_id,symbol_content,symbol_group " +
            "from word,symbol where word.symbol_id=symbol.symbol_id")
    public LiveData<List<WordAndSymbol>> getWordAndSymbol();

    //根据israw查询   0：未添加到单词本，1：已添加到单词本
    @Query("select word_id,word_content,word_trans,israw,uk_symbol,usa_symbol,word.symbol_id,symbol_content,symbol_group " +
            "from word,symbol where word.symbol_id=symbol.symbol_id and israw=:israw")
    public LiveData<List<WordAndSymbol>> getWordBook(Integer... israw);

    //根据symbol_id查询
    @Query("select word_id,word_content,word_trans,israw,uk_symbol,usa_symbol,word.symbol_id,symbol_content,symbol_group " +
            "from word,symbol where word.symbol_id=symbol.symbol_id and word.symbol_id=:symbol_id")
    public LiveData<List<WordAndSymbol>> getWordBySymbolId(Integer... symbol_id);

    //根据word_id查询
    @Query("select word_id,word_content,word_trans,israw,uk_symbol,usa_symbol,word.symbol_id,symbol_content,symbol_group " +
            "from word,symbol where word.symbol_id=symbol.symbol_id and word_id=:word_id")
    public LiveData<List<WordAndSymbol>> getWordByWordId(Integer... word_id);

    //根据symbol_group查询
    @Query("select word_id,word_content,word_trans,israw,uk_symbol,usa_symbol,word.symbol_id,symbol_content,symbol_group " +
            "from word,symbol where word.symbol_id=symbol.symbol_id and symbol_group=:group")
    public LiveData<List<WordAndSymbol>> getWordByGroup(Integer... group);

    //根据id修改单词本数据（将israw修改为1）
    @Query("update word set israw=:israw where word_id= :id")
    public void updateWordIsraw(Integer israw,Integer id);

}
