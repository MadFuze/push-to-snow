package com.pushtosnow.madfuze.push_to_snow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by Thomas on 07/12/2015.
 */
public class Game {

    private Bitmap background;

    private Context context;

    private Shop shop;

    private int continentIndex = 0;
    private Continent continent[] = new Continent[9];
    /*
    1: Europe
    2: Asie
    3: Moyen-Orient
    4: Afrique
    5: Asie du Sud-Est
    6: Océanie
    7: Amérique du nord
    8: Amérique du sud
    9: Antartique
    */

    Game(Context mainContext){
        context = mainContext;

        continent[0] = new Continent("Europe", "srcEurope", 3);
        continent[1] = new Continent("Asie", "srcAsie", 6);
        continent[2] = new Continent("Moyen-Orient", "srcMO", 10);

        background = ((BitmapDrawable) context.getResources().getDrawable(R.drawable.backgroundEurope)).getBitmap(); // need to load the image bakgroundEurope
    }

    void render(Canvas canvas){
        canvas.drawBitmap(background, 0, 0, null);
    }

    void update(){
    }



}
