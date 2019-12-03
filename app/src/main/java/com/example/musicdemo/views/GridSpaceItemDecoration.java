package com.example.musicdemo.views;

import android.graphics.Rect;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GridSpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int mSpace;
    public GridSpaceItemDecoration(int space,RecyclerView parent){
        mSpace = space;
        getRecyclerViewOffsets(parent);
    }
// OutRect矩形边界
// view ItemView
// parent RecyclerView
// state  RecyclerViewd的状态
    @Override
    public void getItemOffsets(@NonNull Rect OutRect,@NonNull View view,@NonNull RecyclerView parent ,@NonNull RecyclerView.State state){
        super.getItemOffsets(OutRect,view,parent,state);
        OutRect.left=mSpace;
        //判断Item是不是每一行第一个Item
      /*  if(parent.getChildLayoutPosition(view)%3==0){
            OutRect.left=0;
        }*/
    }
    private void getRecyclerViewOffsets(RecyclerView parent){
        LinearLayout.LayoutParams layoutParams=(LinearLayout.LayoutParams)parent.getLayoutParams();
        layoutParams.leftMargin=-mSpace;
        parent.setLayoutParams(layoutParams);
    }
}
