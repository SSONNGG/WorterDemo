package com.song.worterdemo.utils;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpaceItemUtil extends RecyclerView.ItemDecoration {
    private int space;

    public SpaceItemUtil(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        if(parent.getChildLayoutPosition(view)!=0){
            outRect.top=space;
        }
    }
}
