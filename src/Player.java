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

    public boolean hasYellows(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("yellow")){
                return true;
            }
        }
        return false;
    }

    public boolean hasReds(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("red")){
                return true;
            }
        }
        return false;
    }

    public boolean hasGreens(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("green")){
                return true;
            }
        }
        return false;
    }
    public boolean hasBlues(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("blue")){
                return true;
            }
        }
        return false;
    }

}
