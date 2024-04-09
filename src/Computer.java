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

    public void addCard(Card newCard){
        personalDeck.add(newCard);
    }

public int getCardCount(){
        return personalDeck.size();
}

private int findCardIndex(String color, int num){
        for(int i = 0; i < personalDeck.size(); i++){
            if(personalDeck.get(i).getColor().equalsIgnoreCase(color) && personalDeck.get(i).getNumber() == num){
                return i;
            }
        }
        return -1;
}
private Card playCard(String color, int num){
        return personalDeck.remove(findCardIndex(color, num));
}

public void colorTurn(Round round){
        boolean[] options = round.checkOptions(personalDeck);
        String lastCardColor = round.getLastCard().getColor();

}

public Card randomTurn(Round round, DeckOfCards gameDeck) {
    int pick = -1;
    boolean[] options = round.checkOptions(personalDeck);
    boolean isOption = false;
    for(boolean bool: options){
        if(bool){isOption = true;}
    }
    while(!isOption){
        personalDeck.add(gameDeck.drawCard());
        options = round.checkOptions(personalDeck);
        for(boolean bool: options){
            if(bool){isOption = true;}
        }
    }
    while (pick < 0) {
        pick = (int) (Math.random() * options.length);
        if (!options[pick]) {
            pick = -1;
        }
    }
    if (pick < 13) {
        round.setIsWild(false);
        return playCard("red", round.getCardNumber(pick));
    }
    else if (pick < 26) {
        round.setIsWild(false);
        return playCard("yellow", round.getCardNumber(pick));
    }
   else if (pick < 39) {
        round.setIsWild(false);
        return playCard("green", round.getCardNumber(pick));
    }
   else if (pick < 52) {
        round.setIsWild(false);
        return playCard("blue", round.getCardNumber(pick));
    }
   else{
       round.setIsWild(true);
       String[] colors = {"red", "yellow", "green", "blue"};
       int index = (int)(Math.random() * 4);
       round.setWildColor(colors[index]);
       return playCard("wild", round.getCardNumber(pick));
    }
}

public boolean checkIsWinner(){
        return personalDeck.isEmpty();
}

}
