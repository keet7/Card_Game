package com.psl.gems.client;

import com.psl.gems.game.Game;
import com.psl.gems.player.Player;

public class TestClient {

    public static void main(String[] args){
        //CREATE PLAYER 1 AND PLAYER 2 WITH SOME NAMES (say Suresh and Ramesh)
        //CREATE AND INITIALIZE CARD-GAME (shuffle the Full Card Pack)
        //LET BOTH THE PLAYERS REGISTER TO THE GAME
        // (something like game.register(player1))
        // IF GAME HAS 2 PLAYERS, PLAY THE GAME.
        // INSIDE game.play() ALLOT 3 CARDS TO EACH PLAYER
        // as per rules decide highest card for each player
        // as per rule decide winner and print it.
        // WRITE THE PLAYER DATA AND PLAYERS' CARDS IN PROVIDED HTML TEMPLATE IN

        //TO cardgame.html file.

        //Card card = new Card( Suit.DIAMOND, Rank.SIX);
        //System.out.println(card.getCardValue());

        //List<Card> DeckOfCards = new ArrayList<Card>();
        //Deck deck = new Deck();
        Player p1 = new Player("Divya");
        Player p2 = new Player("Keerthana");
        Game game = new Game();
        game.registerPlayer(p1);
        game.registerPlayer(p2);
        game.play();
        //System.out.println(game);

    }
}
