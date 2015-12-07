package com.pushtosnow.madfuze.push_to_snow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private GameLoop game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new GameLoop();
        game.initGame(this);
        setContentView(game.screen);
    }
}
