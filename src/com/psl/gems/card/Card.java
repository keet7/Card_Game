package com.psl.gems.card;

public class Card {
    Suit suit;
    Rank rank;
public Card(Suit suit, Rank rank)
{
    this.suit = suit;
    this.rank = rank;
}
public Card(){

}

// We need getters public
public int getCardValue()
{
    int cardValue = (this.suit.getSuitValue() * 4) + this.rank.getRankValue();
    return cardValue;
}

public String toString(){
    String str = "";

    str += rank.name() + " of " + suit.name();
    return str;
}

public String getCardName(){
    //Images/SPADE/THREE.png
    String cardName = suit.name().toUpperCase() + "/" + rank.name().toUpperCase() + ".png";
    return cardName;
}
}
