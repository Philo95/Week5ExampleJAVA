package com.example.week5example;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String suit, faceName;

    /**
     * This is the constructor, it takes the face name and the suit
     * of the card as arguments
     */
    public Card(String faceName, String suit) {
        setSuit(suit);
        setFaceName(faceName);
    }

    public String getSuit() {
        return suit;
    }

    public String getFaceName() {
        return faceName;
    }

    /**
     * This method will ensure that the argument is one of clubs, hearts, diamonds, spades
     * @param suit - a String that represents the suit
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        if (getValidSuits().contains(suit))
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " was not in the valid list: "+getValidSuits());
    }

    /**
     * This method will return a list of valid suits
     * @return "clubs", "hearts", "diamonds", "spades"
     */
    public static List<String> getValidSuits()
    {
        return Arrays.asList("clubs", "hearts", "diamonds", "spades");
    }

    /**
     * This method will validate if the name is valid and set the instance variable
     * @param faceName
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();

        if (getValidFaceNames().contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " was not in " +getValidFaceNames());
    }

    /**
     * This method will return a list of Strings with valid face names
     */
    public static List<String> getValidFaceNames()
    {
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
    }

    /**
     * This method will return a String representing the Card
     */
    public String toString()
    {
        return String.format("%s of %s", faceName, suit);
    }

    /**
     * This method will return the colour of the suit
     */
    public String getColour()
    {
        if (suit.equals("hearts") || suit.equals("diamonds"))
            return "red";
        else
            return "black";
    }

    /**
     * This method will return the value of the card and assumes that "ace"
     * is the highest card
     *
     * faceName "2","3","4","5","6","7","8","9","10","jack","queen","king","ace"
     * index     0   1   2   3   4   5   6   7   8     9      10      11     12
     * faceValue 2   3   4   5   6   7   8   9   10    11     12      13     14
     */
    public int getFaceValue()
    {
        return getValidFaceNames().indexOf(faceName)+2;
    }

    //this will return an image of the card
    public Image getImage()
    {
        String fileName = "images/" + faceName + "_of_" + suit + ".png";
        System.out.println(fileName);
        return new Image(Card.class.getResourceAsStream(fileName));
    }
}
