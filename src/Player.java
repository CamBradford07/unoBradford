import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> deck;

    public Player(String name){
        deck = new ArrayList<Card>();
        this.name = name;
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public void addCard(Card newCard){
        deck.add(newCard);
    }

    public String getName(){
        return name;
    }

    public int getCardCount(){
        return deck.size();
    }

    public int findCardIndex(String color, int num){
        int index = -1;
        for(int i = 0; i < deck.size(); i++){
            if(deck.get(i).getColor().equalsIgnoreCase(color) && deck.get(i).getNumber() == num){
                index = i;
                break;
            }
        }
        return index;
    }

    public Card playCard(int index){
       return deck.remove(index);
    }

    public void plus2(DeckOfCards gameCards){
        deck.add(gameCards.drawCard());
        deck.add(gameCards.drawCard());
    }

    public void plus4(DeckOfCards gameCards){
        deck.add(gameCards.drawCard());
        deck.add(gameCards.drawCard());
        deck.add(gameCards.drawCard());
        deck.add(gameCards.drawCard());
    }

}
