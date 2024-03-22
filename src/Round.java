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

    public boolean[] checkOptions(ArrayList<Card> deck, Player play){
        boolean[] options = new boolean[54];
        String lastCardColor = lastCard.getColor();
        int lastCardNum = lastCard.getNumber();
        if(lastCardColor.equalsIgnoreCase("red")){
            play.checkForCard(0, "red")
        }
        return options;
    }
}
