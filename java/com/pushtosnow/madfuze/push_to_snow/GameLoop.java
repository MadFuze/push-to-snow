package com.pushtosnow.madfuze.push_to_snow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.MotionEvent;
import android.graphics.Color;
import android.widget.TextView;

import java.io.Console;

/**
 * Created by Antoine on 07/12/2015.
 */
public class GameLoop extends Thread {

    /** Variable booléenne pour arrêter le jeu */
    public boolean running = false;

    /**
     * durée de la pause entre chaque frame
     * du jeu pour frame per second FPS=10
     * on a sleepTime=100
     */
    private long sleepTime = 100;

    /** Ecran de jeu */
    public GameView screen;

    /** le dernier évenement enregistré sur l'écran*/
    public MotionEvent lastEvent;



    private Context context;


    public void initGame(Context context) {

        this.context = context;

        running = true;
        this.screen = new GameView(context, this);
    }

    /** la boucle de jeu */
    @Override
    public void run() {
        while (this.running) {
            this.processEvents();
            this.update();
            this.render();
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
    }

    /** Dessiner les composant du jeu sur le buffer de l'écran*/
    public void render() {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        //effacer l'écran
        this.screen.canvas.drawPaint(paint);

        this.screen.invalidate();
    }

    /** Mise à jour des composants du jeu
     *  Ici nous déplaçon le personnage avec la vitesse vx
     *  S'il sort de l'écran, on le fait changer de direction
     *  */
    public void update() {
    }

    /** Ici on va faire en sorte que lorsqu'on clique sur l'écran,
     * L'animation s'arrête/redémarre
     * */
    public void processEvents() {
        if (lastEvent != null){
            int x = (int)lastEvent.getX(); // Position souris
            int y = (int)lastEvent.getY(); // Position souris

        }
        lastEvent = null;
    }
}

