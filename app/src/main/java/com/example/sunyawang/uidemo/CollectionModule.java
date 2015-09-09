package com.example.sunyawang.uidemo;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by sunyawang on 15/9/7.
 */

/*
 合集模块
 */
public class CollectionModule extends LinearLayout {
    public TextView moduleTitle;
    private View rootView;
    private CollectionMovieItem movie0;
    private CollectionMovieItem movie1;
    private CollectionMovieItem movie2;
    private CollectionMovieItem movie3;
    private ArrayList movieItemArray;

    public CollectionModule(Context context) {
        this(context, null, 0);
    }

    public CollectionModule(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollectionModule(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        init();
    }

    private void init() {
        rootView = LayoutInflater.from(getContext()).inflate(R.layout.module_collection, null);
        addView(rootView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        moduleTitle = (TextView) findViewById(R.id.module_title);
        movie0 = (CollectionMovieItem)findViewById(R.id.movieitem_0);
        movie1 = (CollectionMovieItem)findViewById(R.id.movieitem_1);
        movie2 = (CollectionMovieItem)findViewById(R.id.movieitem_2);
        movie3 = (CollectionMovieItem)findViewById(R.id.movieitem_3);
        movieItemArray = new ArrayList();
        movieItemArray.add(movie0);
        movieItemArray.add(movie1);
        movieItemArray.add(movie2);
        movieItemArray.add(movie3);
    }

    //设置电影数据
    public void setMovieData(ArrayList movieArray) {
        int movieArraySize = movieArray.size();
        //根据影片数量设置显示个数
        if (movieArraySize <= 0) {
            return;
        } else if (movieArraySize > 0 && movieArraySize <= 2) {
            ((LinearLayout) findViewById(R.id.line_0)).setVisibility(VISIBLE);
        } else if (movieArraySize > 2 && movieArraySize <= 4) {
            ((LinearLayout) findViewById(R.id.line_0)).setVisibility(VISIBLE);
            ((LinearLayout) findViewById(R.id.line_1)).setVisibility(VISIBLE);

        } else{
            return;
        }

        for (int i = 0; i < movieArraySize; i++){
            CollectionMovieItem tmpItem = (CollectionMovieItem)movieItemArray.get(i);
            MovieModel tmpModel = (MovieModel)movieArray.get(i);
            tmpItem.setMovieData(tmpModel);
        }
    }

    //设置模块标题
    public void setModuleTitle(String string) {
        moduleTitle.setText(string);

    }

}
