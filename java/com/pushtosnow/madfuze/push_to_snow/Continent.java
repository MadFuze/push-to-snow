package com.pushtosnow.madfuze.push_to_snow;

/**
 * Created by Thomas on 07/12/2015.
 */
public class Continent {

    private String backgroundImage = "img-src-Europe.jpg";
    private int pusherMax = 0;


    public Continent(String pbackgroundImage, int pPusherMax) // Constructor with backgroud picture
    {
        backgroundImage = pbackgroundImage;
        pusherMax = pPusherMax;
    }

    public Continent(int pPousseurMax) //Constructor without background picture
    {
        pusherMax = pPousseurMax;
    }

    //Getter

    public int getPusherMax()  //Return number of Pusher
    {
        return pusherMax;
    }

    public String getbackgroundImage()    //Return the backgroud
    {
        return backgroundImage;
    }


}
