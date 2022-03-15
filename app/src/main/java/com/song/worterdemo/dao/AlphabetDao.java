package com.song.worterdemo.dao;

import androidx.room.Dao;
import androidx.room.Query;

import com.song.worterdemo.entity.Alphabet;

import java.util.List;

// 字母数据库访问接口
@Dao
public interface AlphabetDao {
    //查询所有字母
    @Query("select * from alphabet")
    List<Alphabet> getAllAlphabet();

//    //查询所有大小写字母
//    @Query("select alphabet_id, alphabet_capital,alphabet_lower from alphabet")
//    List<Alphabet> getAllCapAndLowAlphabet();

    //根据ID查询所有信息
    @Query("select * from alphabet where alphabet_id=:id")
    List<Alphabet> getAlphabetById(Integer[]id);

}