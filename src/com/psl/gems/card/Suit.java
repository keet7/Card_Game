package com.psl.gems.card;
//package com.psl.gems.client;

public enum Suit {
    SPADE(1),
    HEART(2),
    DIAMOND(3),
    CLUB(4);

    private int value;
    Suit(int value){
        this.value = value;
    }
    public int getSuitValue()
    {
        return this.value;
    }

}

