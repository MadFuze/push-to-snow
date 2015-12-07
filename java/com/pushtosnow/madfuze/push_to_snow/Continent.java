package com.pushtosnow.madfuze.push_to_snow;

/**
 * Created by Thomas on 07/12/2015.
 */
public class Continent {

    private String backgroundImage = "img-src-Europe.jpg";
    private String name;
    private int maxPusher = 0;

    public Continent(String continentName, String pbackgroundImage, int pPusherMax) // Constructor with background picture
    {
        backgroundImage = pbackgroundImage;
        maxPusher = pPusherMax;
        name = continentName;
    }

    public Continent(int pPousseurMax) //Constructor without background picture
    {
        maxPusher = pPousseurMax;
    }

    //Getter

    public int getMaxPusher()  //Return number of Pusher
    {
        return maxPusher;
    }

    public String getBackgroundImage()    //Return the backgroud
    {
        return backgroundImage;
    }


}
