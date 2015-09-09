package com.example.sunyawang.uidemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

/**
 * Created by sunyawang on 15/9/9.
 */
/*
  可定义宽高比的imageview
 */
public class MovieImageView extends ImageView {

    private float proportion; // 高=宽*proportion

    public MovieImageView(Context context) {
        this(context, null, 0);
    }

    public MovieImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MovieImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setScale(float scale){
        this.proportion = scale;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = (int) (width * proportion);
        setMeasuredDimension(width, height);
    }
}
