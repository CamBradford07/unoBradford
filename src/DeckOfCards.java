import javax.swing.*;
import java.util.ArrayList;

public class DeckOfCards {
    private ArrayList<Card> deck;
    ImageIcon[] reds;
    ImageIcon[] blue;
    ImageIcon[] yellows;
    ImageIcon[] greens;
    ImageIcon wild;
    ImageIcon wildPlus4;

    public DeckOfCards(ImageIcon[] reds, ImageIcon[] blue, ImageIcon[] yellows, ImageIcon[] greens, ImageIcon wild, ImageIcon wildPlus4){
        this.reds = reds;
        this.blue = blue;
        this.yellows = yellows;
        this.greens = greens;
        this.wild = wild;
        this.wildPlus4 = wildPlus4;
        deck = new ArrayList<>();
        for(int i = 0; i <= 9; i++){
            deck.add(new Card(i, "green", greens[i]));
        }
        for(int i = 1; i <= 9; i++){
            deck.add(new Card(i, "green", greens[i]));
        }
        //skip = -2
        // reverse = -1
        //plus 2 = 10
        deck.add(new Card(-2, "green", greens[10]));
        deck.add(new Card(-2, "green", greens[10]));
        deck.add(new Card(-1, "green", greens[11]));
        deck.add(new Card(-1, "green", greens[11]));
        deck.add(new Card(10, "green", greens[12]));
        deck.add(new Card(10, "green", greens[12]));
        for(int i = 0; i <= 9; i++){
            deck.add(new Card(i, "red", reds[i]));
        }
        for(int i = 1; i <= 9; i++){
            deck.add(new Card(i, "red", reds[i]));
        }
        deck.add(new Card(-2, "red", reds[10]));
        deck.add(new Card(-2, "red", reds[10]));
        deck.add(new Card(-1, "red", reds[11]));
        deck.add(new Card(-1, "red", reds[11]));
        deck.add(new Card(10, "red", reds[12]));
        deck.add(new Card(10, "red", reds[12]));

        for(int i = 0; i <= 9; i++){
            deck.add(new Card(i, "blue", blue[i]));
        }
        for(int i = 1; i <= 9; i++){
            deck.add(new Card(i, "blue", blue[i]));
        }
        deck.add(new Card(-2, "blue", blue[10]));
        deck.add(new Card(-2, "blue", blue[10]));
        deck.add(new Card(-1, "blue", blue[11]));
        deck.add(new Card(-1, "blue", blue[11]));
        deck.add(new Card(10, "blue", blue[12]));
        deck.add(new Card(10, "blue", blue[12]));
        for(int i = 0; i <= 9; i++){
            deck.add(new Card(i, "yellow", yellows[i]));
        }
        for(int i = 1; i <= 9; i++){
            deck.add(new Card(i, "yellow", yellows[i]));
        }
        deck.add(new Card(-2, "yellow", yellows[10]));
        deck.add(new Card(-2, "yellow", yellows[10]));
        deck.add(new Card(-1, "yellow", yellows[11]));
        deck.add(new Card(-1, "yellow", yellows[11]));
        deck.add(new Card(10, "yellow", yellows[12]));
        deck.add(new Card(10, "yellow", yellows[12]));
        //wild 11
        //plus 4 = 12
        for(int i = 0; i < 4; i++){
            deck.add(new Card(11, "wild", wild));
            deck.add(new Card(12, "wild", wildPlus4));
        }
    }
public Card drawCard(){
        if(deck.isEmpty()){
            reset();
            shuffle();
        }
        return deck.remove(0);
}

public void reset(){
    deck = new ArrayList<>();
    for(int i = 0; i <= 9; i++){
        deck.add(new Card(i, "green", greens[i]));
    }
    for(int i = 1; i <= 9; i++){
        deck.add(new Card(i, "green", greens[i]));
    }
    //skip = -2
    // reverse = -1
    //plus 2 = 10
    deck.add(new Card(-2, "green", greens[10]));
    deck.add(new Card(-2, "green", greens[10]));
    deck.add(new Card(-1, "green", greens[11]));
    deck.add(new Card(-1, "green", greens[11]));
    deck.add(new Card(10, "green", greens[12]));
    deck.add(new Card(10, "green", greens[12]));
    for(int i = 0; i <= 9; i++){
        deck.add(new Card(i, "red", reds[i]));
    }
    for(int i = 1; i <= 9; i++){
        deck.add(new Card(i, "red", reds[i]));
    }
    //skip = -2
    // reverse = -1
    //plus 2 = 10
    deck.add(new Card(-2, "red", reds[10]));
    deck.add(new Card(-2, "red", reds[10]));
    deck.add(new Card(-1, "red", reds[11]));
    deck.add(new Card(-1, "red", reds[11]));
    deck.add(new Card(10, "red", reds[12]));
    deck.add(new Card(10, "red", reds[12]));

    for(int i = 0; i <= 9; i++){
        deck.add(new Card(i, "blue", blue[i]));
    }
    for(int i = 1; i <= 9; i++){
        deck.add(new Card(i, "blue", blue[i]));
    }
    //skip = -2
    // reverse = -1
    //plus 2 = 10
    deck.add(new Card(-2, "blue", blue[10]));
    deck.add(new Card(-2, "blue", blue[10]));
    deck.add(new Card(-1, "blue", blue[11]));
    deck.add(new Card(-1, "blue", blue[11]));
    deck.add(new Card(10, "blue", blue[12]));
    deck.add(new Card(10, "blue", blue[12]));
    for(int i = 0; i <= 9; i++){
        deck.add(new Card(i, "yellow", yellows[i]));
    }
    for(int i = 1; i <= 9; i++){
        deck.add(new Card(i, "yellow", yellows[i]));
    }
    //skip = -2
    // reverse = -1
    //plus 2 = 10
    deck.add(new Card(-2, "yellow", yellows[10]));
    deck.add(new Card(-2, "yellow", yellows[10]));
    deck.add(new Card(-1, "yellow", yellows[11]));
    deck.add(new Card(-1, "yellow", yellows[11]));
    deck.add(new Card(10, "yellow", yellows[12]));
    deck.add(new Card(10, "yellow", yellows[12]));
    for(int i = 0; i < 4; i++){
        deck.add(new Card(11, "wild", wild));
        deck.add(new Card(12, "wild", wildPlus4));
    }
}
public void shuffle(){
        ArrayList<Card> newDeck = new ArrayList<>();
 while(!deck.isEmpty()){
     newDeck.add(deck.remove((int)(Math.random() * deck.size())));
    }
 deck = newDeck;
}
}
