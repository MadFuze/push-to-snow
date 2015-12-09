package com.pushtosnow.madfuze.push_to_snow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;

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

    private int snowcoins; // The main game var



    Game(Context mainContext){
        context = mainContext;

        continent[0] = new Continent("Europe", R.drawable.background_europe, 3); // ContinentName, backgroundImageID, nameOfPuchersAllowed
        continent[1] = new Continent("Asie", R.drawable.background_europe, 6);
        continent[2] = new Continent("Moyen-Orient", R.drawable.background_europe, 10);

        // Load the bitmap from the index saved into the currently continent
        background = ((BitmapDrawable) context.getResources().getDrawable(continent[continentIndex].getBackgroundImageID())).getBitmap();

        snowcoins = 0; // Maybe have a save
    }

    void render(GameView screen){
        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setTextSize(52);

        screen.canvas.drawBitmap(background, 0, 0, null);
        screen.canvas.drawText("Snowcoins : " + String.valueOf(snowcoins), 50, 200, paint);
    }

    void update(){
    }

    public void processEvents(MotionEvent event) {

        if (event.getAction() == MotionEvent.ACTION_UP || event.getAction() == MotionEvent.ACTION_POINTER_UP){
            snowcoins++;
        }
    }


}
