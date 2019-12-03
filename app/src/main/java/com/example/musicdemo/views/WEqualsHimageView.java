package com.example.musicdemo.views;

import android.content.Context;
import android.icu.util.Measure;
import android.util.AttributeSet;
import android.widget.ImageView;

import androidx.appcompat.widget.AppCompatImageView;

public class WEqualsHimageView extends AppCompatImageView {

    public WEqualsHimageView(Context context) {
        super(context);
    }

    public WEqualsHimageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public WEqualsHimageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       // super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
      /*  //获取View宽度
        int width=MeasureSpec.getSize(widthMeasureSpec);
        //获取View模式等
        int mode=MeasureSpec.getMode(widthMeasureSpec);
*/

    }
}
