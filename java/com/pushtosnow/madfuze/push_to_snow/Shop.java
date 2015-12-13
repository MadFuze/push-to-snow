package com.pushtosnow.madfuze.push_to_snow;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;

/**
 * Created by Antoine on 07/12/2015.
 */
public class Shop {

    private Bitmap bitmapPousseur;

    Shop(){
    }

    public void render(GameView screen){
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        paint.setTextSize(48);


        float xInit = (screen.width /3)/2, x = xInit;
        float y = screen.height /7;
        float circleSize = screen.width / 7;

        for (int j = 1; j<=2; j++){
            for (int i = 0; i < 3; i++) {
                screen.canvas.drawCircle(x + (circleSize*2 + circleSize/4) * i, y*j, circleSize, paint);
                screen.canvas.drawText("Europe -",x + (circleSize*2 + circleSize/4) * i, y*j + circleSize*2, paint);
            }
            y=y*2;
            x = (screen.width /3)/2;
        }
    }

    public void update(){
    }

    public void processEvents(MotionEvent event) {

    }
}
