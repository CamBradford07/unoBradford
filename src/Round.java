import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.Timer;

public class Round {
    private Card lastCard;
    private int place = 0;
    private int direction = 1;
    private String wildColor = "";
    private boolean isWild = false;
    private String winner = "";

    public Round(Card card){
        lastCard = card;
    }

    public void setLastCard(Card newLastCard){
        lastCard = newLastCard;
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


    private boolean checkForCard(ArrayList<Card> deck, String color, int number){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase(color) && x.getNumber() == number){
                return (!isWild && (x.getColor().equalsIgnoreCase(lastCard.getColor()) || x.getNumber() == lastCard.getNumber())) || (isWild && (x.getColor().equalsIgnoreCase(wildColor))) || x.getColor().equalsIgnoreCase("wild");
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

    public int getDirection() {
        return direction;
    }

public ArrayList<ImageIcon> runComputers(Player play, Computer comp1, Computer comp2, Computer comp3, DeckOfCards deck){
        ArrayList<ImageIcon> playedCardIcons = new ArrayList<>();
        Computer[] comps = {comp1, comp2, comp3};
        while(place != 0){
            Card playedCard = comps[place - 1].randomTurn(this,deck);
            lastCard = playedCard;
            playedCardIcons.add(playedCard.getIcon());
            if(lastCard.getNumber() == 12){
                if(place == 1){
                    if(direction > 0){comp2.plus4(deck);}
                    else if(direction < 0){play.plus4(deck);}
                }
                else if(place == 2){
                    if(direction > 0){comp3.plus4(deck);}
                    else if(direction < 0){comp1.plus4(deck);}
                }
                else{
                    if(direction > 0){play.plus4(deck);}
                    else if(direction < 0){comp1.plus4(deck);}
                }
                nextPlace();
            }
            else if(lastCard.getNumber() == 10){
                if(place == 1){
                    if(direction > 0){comp2.plus2(deck);}
                    else if(direction < 0){play.plus2(deck);}
                }
                else if(place == 2){
                    if(direction > 0){comp3.plus2(deck);}
                    else if(direction < 0){comp1.plus2(deck);}
                }
                else{
                    if(direction > 0){play.plus2(deck);}
                    else if(direction < 0){comp2.plus2(deck);}
                }
                nextPlace();
            }
            else if(lastCard.getNumber() == -2){nextPlace();}
            else if(lastCard.getNumber() == -1){reverse();}

          if(place != 0){
            if(comps[place - 1].checkIsWinner()){break;}
          }
            nextPlace();
        }
        return playedCardIcons;
}

public void win(Player play, JFrame game, JFrame winFrame, JPanel winpanel, JLabel winnerLabel){
    setWinner(play.getName());
    winpanel.setBackground(Color.GREEN);
    winFrame.setBackground(Color.GREEN);
    winnerLabel.setText("Winner: " + getWinner());
    winpanel.add(winnerLabel);
    winFrame.add(winpanel);
    game.setVisible(false);
    winFrame.setVisible(true);
}

    public void win(Computer comp, JFrame game, JFrame winFrame, JPanel winpanel, JLabel winnerLabel){
        setWinner(comp.getName());
        winpanel.setBackground(Color.RED);
        winFrame.setBackground(Color.RED);
        winnerLabel.setText("Winner: " + getWinner());
        winpanel.add(winnerLabel);
        winFrame.add(winpanel);
        game.setVisible(false);
        winFrame.setVisible(true);
    }

    public void hideButtons(JButton[] buttons){
        for(JButton but: buttons){
            but.setVisible(false);
        }
    }

    public void seeOptions(JButton[] buttons, Player play){
        boolean[] options = checkOptions(play.getDeck());
        for(int i = 0; i < buttons.length; i++){
            buttons[i].setVisible(options[i]);
        }
    }

    public void seeTurns(Timer timer, JLabel label, ArrayList<ImageIcon> cardIcons){
        for(int i = 1; i <= cardIcons.size(); i++){
            final int finali = i;
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    label.setIcon(cardIcons.get(finali - 1));
                }
            }, 1000 * i);
        }
    }
  
}
