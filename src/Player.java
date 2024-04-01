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


}
