import java.util.ArrayList;

public class Computer {
    private String name;
    private ArrayList<Card> personalDeck;
    public Computer(String name){
        this.name = name;
        personalDeck = new ArrayList<Card>();
    }

    public String getName(){
        return name;
    }






}
