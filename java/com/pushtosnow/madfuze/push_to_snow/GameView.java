package com.pushtosnow.madfuze.push_to_snow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;

/**
 * Created by Antoine on 07/12/2015.
 */
public class GameView extends SurfaceView implements Callback {

    public int width; //largeur de l'écran
    public int height; //hauteur de l'écran
    public Canvas canvas; //outil pour dessiner sur l'écran
    private Bitmap buffer; // pixel buffer
    private SurfaceHolder holder;
    private GameLoop game; //pointeur vers la boucle de jeu

    public GameView(Context context, GameLoop game) {
        super(context);
        this.holder = getHolder();
        this.holder.addCallback(this);
        this.game = game;
    }

    /** Rafraichir l'écran*/
    @Override
    public void invalidate() {
        if (holder != null) {
            Canvas c = holder.lockCanvas();
            if (c != null) {
                c.drawBitmap(buffer, 0, 0, null);
                holder.unlockCanvasAndPost(c);
            }
        }
    }

    /**callback lorsque l'écran est touché
     * on stocke l'événement pour être ensuite traité dans la boucle de jeu*/
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.game.lastEvent = event;
        return true;
    }

    /** callback lorsque la surface est chargée,
     * donc démarrer la boucle de jeu*/
    public void surfaceChanged(SurfaceHolder holder, int format,
                               int width, int height) {
        this.width = width;
        this.height = height;
        this.buffer = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        this.canvas = new Canvas(buffer);
        this.game.start();
    }

    public void surfaceCreated(SurfaceHolder holder) {
    }

    public void surfaceDestroyed(SurfaceHolder holder) {
    }
}
