package com.psl.gems.game;

import com.psl.gems.card.Card;
import com.psl.gems.card.Deck;
import com.psl.gems.player.Player;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Game {
    List<Player> players = new ArrayList<Player>();
    Deck deck;

    public Game()
    {
        deck = new Deck();

    }
    public void registerPlayer(Player player)
    {
       if(players.size() < 2)
       {
           players.add(player);
       }
    }

    public void play()
    {
        // Allot 3 cards to each player
        deck.reset();

        deck.shuffle();
        int counter = 0;
        for( int i = 0; i < 3; i++)
        {
            Card tmpCard1 = deck.getRandomCard(counter);
            System.out.println(tmpCard1);
            players.get(0).assignCrad(tmpCard1);
            Card tmpCard2 = deck.getRandomCard(counter + 1);
            System.out.println(tmpCard2);
            players.get(1).assignCrad(tmpCard2);
            counter = counter + 2;
        }
        // Get the max card value of each player
        int player1MaxValue;
        int player2MaxValue;
        player1MaxValue = players.get(0).getHighestCard().getCardValue();
        //System.out.println(players.get(0).getHighestCard());

        Card player1HighestCard = players.get(0).getHighestCard();
        player2MaxValue = players.get(1).getHighestCard().getCardValue();
        //System.out.println(players.get(1).getHighestCard());
        Card player2HighestCard = players.get(1).getHighestCard();
        // Compare the max values of each player and declare winner
        if(player1MaxValue > player2MaxValue)
        {
            System.out.println(players.get(0).getName() + " (Player1) is the winner");
            System.out.println(player1HighestCard + " is the highest card");
        }
        else {
            System.out.println(players.get(1).getName() + " (Player2) is the winner");
            System.out.println(player2HighestCard + " is the highest card");
            // player1MaxValue is winner
        }

        System.out.println("writing a html file in the default directory");
        writeHTMLFile();
        System.out.println("Completed writing a html file");
        System.out.println("end of game");
    }

    public String declareWinner(){
        int player1MaxValue;
        int player2MaxValue;
        String winner = null;
        player1MaxValue = players.get(0).getHighestCard().getCardValue();
        Card player1HighestCard = players.get(0).getHighestCard();
        player2MaxValue = players.get(1).getHighestCard().getCardValue();
        Card player2HighestCard = players.get(1).getHighestCard();
        if(player1MaxValue > player2MaxValue)
        {
            winner = "Player 1 " + players.get(0).getName() + " is the winner of the game.";
        }
        else {
            winner = "Player 2 " + players.get(1).getName() + " is the winner of the game.";
        }
        return winner;

    }

    @Override
    public String toString(){

        String[] player1CardsInHand = players.get(0).getCardFromCardInHand();

        String[] player2CardsInHand = players.get(1).getCardFromCardInHand();

        String flipImageFunc = "function flipImage( eleId ) { let imageElement = document.getElementById (eleId); let cardImage = imageElement.getAttribute (\"datacard\"); let src = imageElement.getAttribute(\"src\"); if(src === \"images/card.jpg\") { if(document.getElementById('player1div')){ player1cardOpen++;  imageElement.src= cardImage;  } if(document.getElementById ('player2div')){ player2cardOpen++; imageElement.src= cardImage; } } else { if(document.getElementById('player1div')){  player1cardOpen--; imageElement.src= \"images/card.jpg\"; } if(document.getElementById ('player2div')){   player2cardOpen--; imageElement.src= \"images/card.jpg\"; } } if(player1cardOpen === 3){ highestCardButton1.style.visibility = \"visible\"; } if(player2cardOpen === 3){ highestCardButton2.style.visibility = \"visible\"; }  }";
        String showHighestCardFunc = " function showHighestCard(eleId){  let highestDivElement = document.getElementById(eleId);  highestDivElement.style.visibility = \"visible\"; }";
        String declareWinnerFunc = " function declareWinner(eleId){  let winner = document.getElementById(eleId);  winner.style.visibility = \"visible\"; }";


        String player1div = "<div id=\"player1div\">\n  <h2>Player1</h2>\n  <h3>Name : " + players.get(0).getName() + "</h3>\n    <div id=\"player1card1\">\n <image\n    id=\"player1card1img\"\n    datacard=\"" + player1CardsInHand[0] + "\"\n   src=\"images/card.jpg\"\n   onclick=\"flipImage('player1card1img')\">\n </image>\n</div>\n  <div id=\"player1card2\">\n <image id=\"player1card2img\"\n datacard=\"" + player1CardsInHand[1] + "\"\nsrc=\"images/card.jpg\"\nonclick=\"flipImage('player1card2img')\">\n</image>\n </div>\n<div id=\"player1card3\">\n  <image id=\"player1card3img\"\n datacard=\"" + player1CardsInHand[2] + "\"\n    src=\"images/card.jpg\"\n   onclick=\"flipImage('player1card3img')\">\n</image>\n   </div>\n    <button id=\"highestCardButton1\"\n onclick=\"showHighestCard('player1HighestCardDisplay')\"\n>Show Highest Card</button>\n</div>";

        String player2div = " <div id=\"player2div\">\n  <h2>Player2</h2>\n <h3>Name : " + players.get(1).getName() + "</h3>\n <div id=\"player2card1\">\n <image\n id=\"player2card1img\"\n datacard=\"" + player2CardsInHand[0] + "\"\n src=\"images/card.jpg\"\n onclick=\"flipImage('player2card1img')\"\n ></image>\n </div>\n <div id=\"player2card2\">\n <image id=\"player2card2img\"\n  datacard=\"" + player2CardsInHand[1] + "\" \nsrc=\"images/card.jpg\"\n onclick=\"flipImage('player2card2img')\">\n</image>\n </div>\n <div id=\"player2card3\">\n <image id=\"player2card3img\"\n datacard=\"" + player2CardsInHand[2] + "\"\n src=\"images/card.jpg\"\n onclick=\"flipImage('player2card3img')\">\n</image>\n </div> \n <button id=\"highestCardButton2\"\n onclick=\"showHighestCard ('player2HighestCardDisplay')\"\n>Show Highest Card</button>\n </div>";

        String player1HighestCardDisplay = " <div id=\"player1HighestCardDisplay\">\n <image id=\"player1HighestCardimg\"\n src=\"" + players.get(0).getHighestCardName() + "\">\n</image>\n  <h2 class=\"points\">Points Earned " + players.get(0).getHighestCard().getCardValue() + "</h2> \n</div>";

        String player2HighestCardDisplay = " <div id=\"player2HighestCardDisplay\">\n <image id=\"player2HighestCardimg\"\n src=\"" + players.get(1).getHighestCardName() + "\">\n</image>\n <h2 class=\"points\">Points Earned " + players.get(1).getHighestCard().getCardValue() + "</h2> \n</div>";

        String decideWinnerButton = " <button id=\"decideWinnerButton\"\n onclick=\"declareWinner('winner')\">\nDecide Winner\n</button>";

        String winnerdiv = " <div id=\"winner\">\n <p> " + declareWinner() + "</p>\n </div>";


        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>\n");
        sb.append("<html lang=\"en\">\n");
        sb.append("<head>\n");
        sb.append("<title>Document</title>\n");
        sb.append("<script lang=\"javascript\">");
        sb.append("let player1cardOpen = 0;");
        sb.append("let player2cardOpen = 0;");

        sb.append(flipImageFunc);
        sb.append(showHighestCardFunc);
        sb.append(declareWinnerFunc);
        sb.append("\n</script>");
        sb.append("\n<link rel=\"stylesheet\" href=\"K:\\Java Project\\Persistent_CardGame_1\\src\\com\\psl\\gems\\HTML\\style.css\">");
        //K:\\Java Project\\Persistent_CardGame_1\\src\\com\\psl\\gems\\HTML\\cardgame.html"
        sb.append("</head>\n");
        sb.append("<body>\n");
        sb.append(player1div);
        sb.append(player2div);
        sb.append(player1HighestCardDisplay);
        sb.append(player2HighestCardDisplay);
        sb.append(decideWinnerButton);
        sb.append(winnerdiv);
        sb.append("\n</body>");
        sb.append("\n</html>");
        /*sb.append("<div id=\"Suresh\">\n");
        List<Card> player1cardInHand = players.get(0).getCardsInHand();
        for(int i = 0; i<3; i++){
            //String card1 = "<div data-card=\""  + player1cardInHand.get(i) +" \" />";

            sb.append("<div data-card=\""  + player1cardInHand.get(i) +" \" />\n");

        }
        sb.append("</div>\n");
        sb.append("<div id=\"Ramesh\">\n");
        List<Card> player2cardInHand = players.get(0).getCardsInHand();
        for(int i = 0; i<3; i++){
            //String card1 = "<div data-card=\""  + player1cardInHand.get(i) +" \" />";

            sb.append("<div data-card=\""  + player2cardInHand.get(i) +" \" />\n");

        }
        sb.append("</div>\n");
        sb.append("</section>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");*/
        return sb.toString();

    }

    public void writeHTMLFile(){
        String htmlCode = toString();

        File f = new File("K:\\Java Project\\Persistent_CardGame_1\\src\\com\\psl\\gems\\HTML\\cardgame.html");
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, false));
            bw.write(htmlCode);
            bw.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }


}
