package com.psl.gems.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;

public class Deck {



    List<Card>  DeckOfCards = new ArrayList<Card>();



    public Deck()
    {
        if(DeckOfCards.size() > 0)
        {
            DeckOfCards.clear();
        }
        populate();
    }

    private void populate(){
        for(Suit suit: Suit.values()){
            for(Rank rank: Rank.values()){
                Card card = new Card(suit, rank);
                DeckOfCards.add(card);
            }
        }
    }

    public void shuffle(){
        for(int i =0; i<5; i++){
            for (int j = 0; j < this.DeckOfCards.size()/2; j++) {
                double random = Math.random() * (51 - 0 + 1) + 0;
                Collections.swap(this.DeckOfCards, j, (int)random);
            }
        }
    }

    public void reset(){
        DeckOfCards.clear();
        populate();
    }
    public Card getRandomCard(int index){
        return DeckOfCards.get(index);
    }
}
