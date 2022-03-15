package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.Symbol;

import java.util.List;

@Dao    //音标表数据库访问接口
public interface SymbolDao {
    //1.查询所有音标content
    //使用livedata进行数据包装
    @Query("select * from symbol")
    List<Symbol> getAllSymbol();

    //2.按照组别查询
    @Query("select symbol_content from symbol where symbol_group= :group")
    List<String> getSymbolByGroup(Integer[] group);

    //3.按照分类查询
    @Query("select symbol_categories from symbol where symbol_group= :categories")
    List<String> getSymbolByCate(String[] categories);

    //4.按照ID查询
    @Query("select * from symbol where symbol_id=:id")
    List<Symbol> getSymbolById(Integer[] id);
}
