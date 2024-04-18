import java.util.ArrayList;

public class Round {
    private Card lastCard;
    private int place = 0;
    private int direction = 1;
    private String wildColor = "";
    private boolean isWild = false;
    private String winner = "";
    private long delay = 1000;

    public Round(Card card){
        lastCard = card;
    }

    public void setLastCard(Card newLastCard){
        lastCard = newLastCard;
    }

    public long getDelay() {
        return delay;
    }

    public void resetDelay(){
        delay = 1000;
    }

    public void increaseDelay(){
        delay += 1000;
    }

    public void setIsWild(boolean tof){
        isWild = tof;
    }

    public void setWildColor(String newColor){
        wildColor = newColor;
    }

    public Card getLastCard() {
        return lastCard;
    }

    public String getWinner(){
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public void reverse(){
        direction *= -1;
    }

    public int getNextIndex(){
        int nextIndex = place + direction;
        if(nextIndex > 3 || nextIndex < 0){
            if(direction < 0){nextIndex = 3;}
            else{nextIndex = 0;}
        }
        return nextIndex;
    }

    public void nextPlace(){
        place += direction;
        if(place > 3 || place < 0){
            if(direction < 0){
                place = 3;
            }
            else{
                place = 0;
            }
        }
    }

    public int getPlace(){
        return place;
    }

    private boolean checkForCard(ArrayList<Card> deck, String color, int number){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase(color) && x.getNumber() == number){
                if((!isWild && (x.getColor().equalsIgnoreCase(lastCard.getColor()) || x.getNumber() == lastCard.getNumber() )) || (isWild && (x.getColor().equalsIgnoreCase(wildColor))) || x.getColor().equalsIgnoreCase("wild")) {
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    public boolean[] checkOptions(ArrayList<Card> deck) {
        boolean[] options = new boolean[54];
        if (!isWild) {
            for (int i = 0, x = -2; i < 13; i++, x++) {
                options[i] = checkForCard(deck, "red", x);
            }
            for (int i = 13, x = -2; i < 26; i++, x++) {
                options[i] = checkForCard(deck, "yellow", x);
            }
            for (int i = 26, x = -2; i < 39; i++, x++) {
                options[i] = checkForCard(deck, "green", x);
            }
            for (int i = 39, x = -2; i < 52; i++, x++) {
                options[i] = checkForCard(deck, "blue", x);
            }
            options[52] = checkForCard(deck, "wild", 11);
            options[53] = checkForCard(deck, "wild", 12);
        }
        else{
            if(wildColor.equalsIgnoreCase("red")){
                for (int i = 0, x = -2; i < 13; i++, x++) {
                    options[i] = checkForCard(deck, "red", x);
                }
                options[52] = checkForCard(deck, "wild", 11);
                options[53] = checkForCard(deck, "wild", 12);
            }
            else if(wildColor.equalsIgnoreCase("yellow")){
                for (int i = 13, x = -2; i < 26; i++, x++) {
                    options[i] = checkForCard(deck, "yellow", x);
                }
                options[52] = checkForCard(deck, "wild", 11);
                options[53] = checkForCard(deck, "wild", 12);
            }
            else if(wildColor.equalsIgnoreCase("green")){
                for (int i = 26, x = -2; i < 39; i++, x++) {
                    options[i] = checkForCard(deck, "green", x);
                }
                options[52] = checkForCard(deck, "wild", 11);
                options[53] = checkForCard(deck, "wild", 12);
            }
            else{
                for (int i = 39, x = -2; i < 52; i++, x++) {
                    options[i] = checkForCard(deck, "blue", x);
                }
                options[52] = checkForCard(deck, "wild", 11);
                options[53] = checkForCard(deck, "wild", 12);
            }
        }

        return options;
    }

    public int getCardNumber(int index) {
        if (!(index > 51)) {
            while (index >= 13) {
                index -= 13;
            }
            return index - 2;
        }
        else{
            return index - 41;
        }
    }

    public void plus2(Player play, Computer comp1, Computer comp2, Computer comp3, DeckOfCards deck){
        if(direction > 0){
            if(place == 0){
                comp1.addCard(deck.drawCard());
                comp1.addCard(deck.drawCard());
            }
            else if(place == 1){
                comp2.addCard(deck.drawCard());
                comp2.addCard(deck.drawCard());
            }
            else if(place == 2){
                comp3.addCard(deck.drawCard());
                comp3.addCard(deck.drawCard());
            }
            else{
                play.addCard(deck.drawCard());
                play.addCard(deck.drawCard());
            }
        }
        else{
            if(place == 2){
                comp1.addCard(deck.drawCard());
                comp1.addCard(deck.drawCard());
            }
            else if(place == 3){
                comp2.addCard(deck.drawCard());
                comp2.addCard(deck.drawCard());
            }
            else if(place == 0){
                comp3.addCard(deck.drawCard());
                comp3.addCard(deck.drawCard());
            }
            else{
                play.addCard(deck.drawCard());
                play.addCard(deck.drawCard());
            }
        }
    }

}
