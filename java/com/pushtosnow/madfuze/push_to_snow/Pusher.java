package com.pushtosnow.madfuze.push_to_snow;

/**
 * Created by Thomas on 07/12/2015.
 */
public class Pusher {

    private String image = "img-src-Pusher-Europe", name ="European Pusher";
    private int id = 1;
    private int strength = 0;


    public Pusher(String pImage,String pName, int pId, int pStrength)
    {
        image = pImage;
        name = pName;
        id = pId;
        strength = pStrength;
    }

    //Getter
    public String getImage()    //Return picture of the pusher
    {
        return image;
    }

    public String getName()     //Return name of the pusher
    {
        return name;
    }

    public int getId()          //Return id of the pusher it depends of his continent
    {
        return id;
    }

    public int getStrength()     //Return Strength of the pusher
    {
        return strength;
    }


}
