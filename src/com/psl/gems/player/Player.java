package com.psl.gems.player;

import com.psl.gems.card.Card;
import java.util.ArrayList;
import java.util.List;

public class Player {
    String name = null;
    //Card[] cardsInHand = new Card[3];
    List<Card> cardsInHand = new ArrayList<Card>();

    public Player (String name)
    {
        this.name = name;
    }
    public void assignCrad(Card card)
    {
        if(cardsInHand.size() < 3)
        {
            cardsInHand.add(card);
        }
    }

    public String getName()
    {
        return name;
    }
    public Card getHighestCard(){
        int maxValue = 0;
        Card highestCard = null;
        for(int i = 0; i < cardsInHand.size(); i++)
        {
            Card tmpCard = cardsInHand.get(i);
            int tmpValue = tmpCard.getCardValue();
            if( maxValue < tmpValue)
            {
                maxValue = tmpValue;
                highestCard = tmpCard;
            }
        }
        return highestCard;

    }

    public String getHighestCardName(){
        Card card = getHighestCard();
        //Images/SPADE/JACK.png
        String highestCardName = "Images/" + card.getCardName();
        return highestCardName;
    }

    public String[] getCardFromCardInHand(){
        String cardName = null;
        String cards[] = new String[3];
        for(int i = 0; i<3; i++){
            //Images/SPADE/THREE.png
            StringBuilder sb = new StringBuilder();
            sb.append("Images/");
            String name = cardsInHand.get(i).getCardName();
            sb.append(name);
            //sb.append(".png");
            cards[i] = sb.toString();
        }
        return cards;
    }

    public List<Card> getCardsInHand(){
        return cardsInHand;
    }



}
