import java.util.ArrayList;

public class Round {
    private Card lastCard;
    private String[] order = {"player", "comp1", "comp2", "comp3"};
    private int place = 0;

    public Round(Card card){
        lastCard = card;
    }

    public void setLastCard(Card newLastCard){
        lastCard = newLastCard;
    }

    public Card getLastCard() {
        return lastCard;
    }

    public void reverse(){
        String[] newOrder = new String[order.length];
        for(int i = 0; i < newOrder.length; i++){
            newOrder[i] = order[order.length - 1 - i];
        }
    }

    private boolean checkForCard(ArrayList<Card> deck, String color, int number){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase(color) && x.getNumber() == number){
                return true;
            }
        }
        return false;
    }

    public boolean[] checkOptions(ArrayList<Card> deck){
        boolean[] options = new boolean[54];
        for(int i = 0, x = -2; i < 13; i++, x++){
            options[i] = checkForCard(deck, "red", x);
        }
        for(int i = 13, x = -2; i < 26; i++, x++){
            options[i] = checkForCard(deck, "yellow", x);
        }
        for(int i = 26, x = -2; i < 39; i++, x++){
            options[i] = checkForCard(deck, "green", x);
        }
        for(int i = 39, x = -2; i < 52; i++, x++){
            options[i] = checkForCard(deck, "blue", x);
        }
        options[52] = checkForCard(deck, "wild", 11);
        options[53] = checkForCard(deck, "wild", 12);
        return options;
    }
}
