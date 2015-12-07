package com.pushtosnow.madfuze.push_to_snow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private GameLoop game;
    boolean firstStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("INFO", "onCreate called");

        if (firstStart == false) {
            game = new GameLoop();
            game.initGame(this);
            firstStart = true;
        }

        setContentView(game.screen);
    }

    protected void onResume() {
        super.onResume();
        Log.i("INFO", "onResume called");
        synchronized (game.mPauseLock){
            game.running = true;
            game.mPauseLock.notifyAll();
        }
    }

    public void onPause() {
        super.onPause();
        Log.i("INFO", "onPause called");
        synchronized (game.mPauseLock){
            game.running = false;
        }
    }
    

    public void onDestroy() {
        game.running = false;
        super.onDestroy();
        Log.i("INFO", "onDestroy called");
    }

}
