package com.song.worterdemo.adapter;

import com.barryzhang.tcontributionsview.adapter.BaseContributionsViewAdapter;

public class MyContributionsViewAdapter extends BaseContributionsViewAdapter {
    private int row;
    private int column;
    private int level;

    public MyContributionsViewAdapter() {
    }

    public MyContributionsViewAdapter(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public MyContributionsViewAdapter(int row, int column, int level) {
        this.row = row;
        this.column = column;
        this.level = level;
    }

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 14;
    }

    @Override
    public int getLevel(int row, int column) {
        return 0;
    }
}
