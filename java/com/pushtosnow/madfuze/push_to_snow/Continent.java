package com.pushtosnow.madfuze.push_to_snow;

/**
 * Created by Thomas on 07/12/2015.
 */
public class Continent {

    private String name;
    private int maxPusher = 0;
    private int backgroundImageID = -1;

    public Continent(String continentName, int imageID, int pPusherMax) // Constructor with background picture
    {
        backgroundImageID = imageID;
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

    public int getBackgroundImageID()    //Return the backgroud
    {
        return backgroundImageID;
    }


}
