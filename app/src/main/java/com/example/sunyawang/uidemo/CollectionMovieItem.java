package com.example.sunyawang.uidemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Environment;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.os.Handler;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by sunyawang on 15/9/8.
 */

/*
  合集模块中的影片
 */
public class CollectionMovieItem extends LinearLayout {
    private View rootView;
    private TextView movieTitle;    //电影标题
    private TextView movieCategory; //电影分类
    private MovieImageView movieImage;   //电影海报
    private String movieImageUrl;      //电影海报地址

    private Bitmap bitmap = null;

    private static final int LOAD_SUCCESS = 1; //海报下载成功
    private static final int LOAD_ERROR = -1;  //海边下载失败

    public CollectionMovieItem(Context context) {
        this(context, null, 0);
    }

    public CollectionMovieItem(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CollectionMovieItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        rootView = LayoutInflater.from(getContext()).inflate(R.layout.movieitem_collection, null);
        addView(rootView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        movieTitle = (TextView) findViewById(R.id.movie_title);
        movieCategory = (TextView) findViewById(R.id.movie_category);
        movieImage = (MovieImageView) findViewById(R.id.movie_image);
        movieImage.setScale(0.68f);

    }

    //根据model设置数据
    public void setMovieData(MovieModel movieModel){
        setMovieTitle(movieModel.getMovieTitle());
        setMovieCategory(movieModel.getMovieCateory());
        setMovieImage(movieModel.getMovieImgUrl());
    }

    public void setMovieTitle(String string) {
        movieTitle.setText(string);
    }

    public void setMovieCategory(String string) {
        movieCategory.setText(string);
    }

    public void setMovieImage(String imageUrl) {
        // 开启子线程，用于下载图片
        movieImageUrl = imageUrl;
        new Thread(new MyThread()).start();
    }

    public void setMovieImage(Bitmap bitmap) {
        movieImage.setImageBitmap(bitmap);
    }

    private Handler myHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                //下载成功
                case LOAD_SUCCESS:
                    Log.v("SYW", "下载成功");
                    movieImage.setImageBitmap(bitmap);
                    break;
                //下载失败
                case LOAD_ERROR:

                    break;
            }
        }
    };

    // 下载图片
    public class MyThread implements Runnable {
        @Override
        public void run() {
            try {
                Log.v("SYW", "开始下载图片");
                URL url = new URL(movieImageUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoInput(true);
                conn.setConnectTimeout(5000);
                conn.setRequestMethod("GET");
                conn.connect();
                InputStream inputStream = conn.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
                Message msg = new Message();
                msg.what = LOAD_SUCCESS;
                myHandler.sendMessage(msg);
            } catch (Exception e) {
                Log.v("SYW", "下载失败" + e);
                Message msg = new Message();
                msg.what = LOAD_ERROR;
                myHandler.sendMessage(msg);
            }
        }
    }


}
