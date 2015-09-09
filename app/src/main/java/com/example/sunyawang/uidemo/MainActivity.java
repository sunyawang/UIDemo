package com.example.sunyawang.uidemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CollectionModule collectionModule = (CollectionModule)findViewById(R.id.moudleView);
        collectionModule.setModuleTitle("第998期电影推荐");

        MovieModel model1 = new MovieModel();
        model1.setMovieTitle("习近平同志讲话");
        model1.setMovieCateory("演讲");
        model1.setMovieImgUrl("http://img2.imgtn.bdimg.com/it/u=2695027216,3708629240&fm=111&gp=0.jpg");

        MovieModel model2 = new MovieModel();
        model2.setMovieTitle("捉妖记");
        model2.setMovieCateory("电影");
        model2.setMovieImgUrl("https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3546161216,1010657410&fm=58");

        MovieModel model3 = new MovieModel();
        model3.setMovieTitle("亲爱的");
        model3.setMovieCateory("电影");
        model3.setMovieImgUrl("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=3813539224,2665877748&fm=58");

        MovieModel model4 = new MovieModel();
        model4.setMovieTitle("碟中谍4");
        model4.setMovieCateory("动作片");
        model4.setMovieImgUrl("https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=3416192034,954815460&fm=58");

        ArrayList array = new ArrayList();
        array.add(model1);
        array.add(model2);
        array.add(model3);
        array.add(model4);
        collectionModule.setMovieData(array);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
