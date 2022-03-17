package com.song.worterdemo.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.Alphabet;

import java.util.List;

// 字母数据库访问接口
@Dao
public interface AlphabetDao {
    //查询所有字母
    @Query("select * from alphabet")
    LiveData<List<Alphabet>> getAllAlphabet();

    //根据ID查询所有信息
    @Query("select * from alphabet where alphabet_id=:id")
    LiveData<List<Alphabet>> getAlphabetById(Integer...id);


}
