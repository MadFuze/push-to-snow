package com.pushtosnow.madfuze.push_to_snow;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thomas on 13/12/2015.
 */
public class EasyButton{

    private Button m_button;
    private float m_x, m_y;
    private Canvas m_canvas;
    private BitmapDrawable sprite;


    EasyButton(Context pContext, float pX, float pY, int spriteID)
    {
        m_button = new Button(pContext);
        m_x = pX;
        m_y = pY;
        sprite = (BitmapDrawable)pContext.getResources().getDrawable(spriteID);
    }

    public boolean update(View view, MotionEvent event)
    {
        if(event.getAction() == MotionEvent.ACTION_UP &&
           event.getX() == m_x && event.getY() == m_y )
        {
            return true;
        }
        return false;
    }

    public void render()
    {
        m_button.draw(m_canvas);
    }






}
