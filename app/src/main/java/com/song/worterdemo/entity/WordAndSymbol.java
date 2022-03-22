package com.song.worterdemo.entity;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Relation;

/**
 * 单词和对应音标的一对一关系表
 */
public class WordAndSymbol {

    @Embedded public Word word;
    @Relation(
            parentColumn = "wordId",
            entityColumn = "userId"
    )
    public Symbol symbol;

    @Override
    public String toString() {
        return "WordAndSymbol{" +
                "symbol=" + symbol +
                ", word=" + word.toString() +
                '}';
    }
}
