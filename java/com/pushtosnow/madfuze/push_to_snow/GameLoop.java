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
    public boolean running = false, finished = false;
    public Object mPauseLock;

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

    // === GAME ELEMENTS ===
    private Game game;
    private Shop shop;

    public enum State{
        GAME,
        SHOP;
    }

    private State state;

    //

    public void initGame(Context context) {

        this.context = context;
        mPauseLock = new Object();

        running = true;
        this.screen = new GameView(context, this);
        ///
        game = new Game(context);
        shop = new Shop();

        state = State.GAME;
    }

    /** la boucle de jeu */
    @Override
    public void run() {
        while (!this.finished) {

            synchronized (mPauseLock) {


                while (this.running) {
                    this.processEvents();
                    this.update();
                    this.render();
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

    }

    /** Dessiner les composant du jeu sur le buffer de l'écran*/
    public void render() {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        //effacer l'écran
        this.screen.canvas.drawPaint(paint);

        switch (state)
        {
            case GAME:
                game.render(this.screen);
                break;
            case SHOP:
                shop.render(this.screen);
                break;
        }

        this.screen.invalidate();
    }

    /** Mise à jour des composants du jeu
     *  Ici nous déplaçon le personnage avec la vitesse vx
     *  S'il sort de l'écran, on le fait changer de direction
     *  */
    public void update() {
        switch (state)
        {
            case GAME:
                game.update();
                break;
            case SHOP:
                shop.update();
                break;
        }
    }

    /** Ici on va faire en sorte que lorsqu'on clique sur l'écran,
     * L'animation s'arrête/redémarre
     * */
    public void processEvents() {
        if (lastEvent != null){
            int x = (int)lastEvent.getX(); // Position souris
            int y = (int)lastEvent.getY(); // Position souris

            switch (state)
            {
                case GAME:
                    game.processEvents(lastEvent);
                    break;
                case SHOP:
                    shop.processEvents(lastEvent);
                    break;
            }

        }
        lastEvent = null;
    }
}


