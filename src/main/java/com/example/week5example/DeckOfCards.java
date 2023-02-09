package com.example.week5example;

import java.util.ArrayList;
import java.util.Collections;

public class DeckOfCards {
    private ArrayList<Card> deck;

    /**
     * This is the constructor, it will need to build 52 Card objects and add
     * them to the deck
     *
     * This is a constructor, so it does not have a return type and the name
     * matches the class name exactly (including the upper case first letter)
     */
    public DeckOfCards()
    {
        deck = new ArrayList<>();

//              Calling getValidSuits() returns
//              ["clubs", "hearts", "diamonds", "spades"]
//        index     0         1         2           3
//        for (int i=0; i<Card.getValidSuits().size() ; i++)
//        {
//            System.out.println(Card.getValidSuits().get(i));
//        }

//       what is in each position       collection to iterate over
        for (String suit            :   Card.getValidSuits())
        {
            for (String faceName : Card.getValidFaceNames())
            {
                Card newCard = new Card(faceName,suit);
                deck.add(newCard);
            }
        }
    }

    /**
     * This method will shuffle the deck of cards
     */
    public void shuffle()
    {
        Collections.shuffle(deck);
    }

    /**
     * This method will remove the top card from the deck.  If no cards are
     * left in the deck, it will return null
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        else
            return null;
    }

    /**
     * This method will return the number of cards in the deck
     */
    public int getCountOfCards()
    {
        return deck.size();
    }
}
