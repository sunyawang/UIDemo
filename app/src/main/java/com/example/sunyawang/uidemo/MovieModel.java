package com.example.sunyawang.uidemo;

/**
 * Created by sunyawang on 15/9/9.
 */
public class MovieModel
{
    private String movieTitle;     //电影主标题
    private String movieUrl;       //电影链接
    private String movieImgUrl;    //电影海报链接
    private String movieCateory;   //电影分类


    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieUrl(String movieUrl) {
        this.movieUrl = movieUrl;
    }

    public void setMovieImgUrl(String movieImgUrl) {
        this.movieImgUrl = movieImgUrl;
    }

    public void setMovieCateory(String movieCateory) {
        this.movieCateory = movieCateory;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieUrl() {
        return movieUrl;
    }

    public String getMovieImgUrl() {
        return movieImgUrl;
    }

    public String getMovieCateory() {
        return movieCateory;
    }

}
