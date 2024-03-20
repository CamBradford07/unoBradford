import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("UNO");
        frame.setSize(500,500);
        JFrame frame2 = new JFrame("UNO");
        frame2.setSize(500,500);
        JFrame optionFrame = new JFrame("Options");
        optionFrame.setSize(500,500);

        JPanel playerShowDeck = new JPanel();
        JPanel panel = new JPanel();
        JPanel optionPanel = new JPanel();

        ImageIcon red0Icon = new ImageIcon("Images/red0.png");
        ImageIcon red1Icon = new ImageIcon("Images/red1.png");
        ImageIcon red2Icon = new ImageIcon("Images/red2.png");
        ImageIcon red3Icon = new ImageIcon("Images/red3.png");
        ImageIcon red4Icon = new ImageIcon("Images/red4.png");
        ImageIcon red5Icon = new ImageIcon("Images/red5.png");
        ImageIcon red6Icon = new ImageIcon("Images/red6.png");
        ImageIcon red7Icon = new ImageIcon("Images/red7.png");
        ImageIcon red8Icon = new ImageIcon("Images/red8.png");
        ImageIcon red9Icon = new ImageIcon("Images/red9.png");
        ImageIcon redReverseIcon = new ImageIcon("Images/redReverse.png");
        ImageIcon redPlus2Icon = new ImageIcon("Images/redPlus2.png");
        ImageIcon redSkipIcon = new ImageIcon("Images/redSkip.png");
        ImageIcon green0Icon = new ImageIcon("Images/green0.png");
        ImageIcon green1Icon = new ImageIcon("Images/green1.png");
        ImageIcon green2Icon = new ImageIcon("Images/green2.png");
        ImageIcon green3Icon = new ImageIcon("Images/green3.png");
        ImageIcon green4Icon = new ImageIcon("Images/green4.png");
        ImageIcon green5Icon = new ImageIcon("Images/green5.png");
        ImageIcon green6Icon = new ImageIcon("Images/green6.png");
        ImageIcon green7Icon = new ImageIcon("Images/green7.png");
        ImageIcon green8Icon = new ImageIcon("Images/green8.png");
        ImageIcon green9Icon = new ImageIcon("Images/green9.png");
        ImageIcon greenReverseIcon = new ImageIcon("Images/greenReverse.png");
        ImageIcon greenPlus2Icon = new ImageIcon("Images/greenPlus2.png");
        ImageIcon greenSkipIcon = new ImageIcon("Images/greenSkip.png");
        ImageIcon blue0Icon = new ImageIcon("Images/blue0.png");
        ImageIcon blue1Icon = new ImageIcon("Images/blue1.png");
        ImageIcon blue2Icon = new ImageIcon("Images/blue2.png");
        ImageIcon blue3Icon = new ImageIcon("Images/blue3.png");
        ImageIcon blue4Icon = new ImageIcon("Images/blue4.png");
        ImageIcon blue5Icon = new ImageIcon("Images/blue5.png");
        ImageIcon blue6Icon = new ImageIcon("Images/blue6.png");
        ImageIcon blue7Icon = new ImageIcon("Images/blue7.png");
        ImageIcon blue8Icon = new ImageIcon("Images/blue8.png");
        ImageIcon blue9Icon = new ImageIcon("Images/blue9.png");
        ImageIcon blueReverseIcon = new ImageIcon("Images/blueReverse.png");
        ImageIcon bluePlus2Icon = new ImageIcon("Images/bluePlus2.png");
        ImageIcon blueSkipIcon = new ImageIcon("Images/blueSkip.png");
        ImageIcon yellow0Icon = new ImageIcon("Images/yellow0.png");
        ImageIcon yellow1Icon = new ImageIcon("Images/yellow1.png");
        ImageIcon yellow2Icon = new ImageIcon("Images/yellow2.png");
        ImageIcon yellow3Icon = new ImageIcon("Images/yellow3.png");
        ImageIcon yellow4Icon = new ImageIcon("Images/yellow4.png");
        ImageIcon yellow5Icon = new ImageIcon("Images/yellow5.png");
        ImageIcon yellow6Icon = new ImageIcon("Images/yellow6.png");
        ImageIcon yellow7Icon = new ImageIcon("Images/yellow7.png");
        ImageIcon yellow8Icon = new ImageIcon("Images/yellow8.png");
        ImageIcon yellow9Icon = new ImageIcon("Images/yellow9.png");
        ImageIcon yellowReverseIcon = new ImageIcon("Images/yellowReverse.png");
        ImageIcon yellowPlus2Icon = new ImageIcon("Images/yellowPlus2.png");
        ImageIcon yellowSkipIcon = new ImageIcon("Images/yellowSkip.png");
        ImageIcon wildIcon = new ImageIcon("Images/wild.png");
        ImageIcon wildPlus4Icon = new ImageIcon("Images/wildPlus4.png");
        ImageIcon blankIcon = new ImageIcon("Images/blank.png");

        ImageIcon[] yellows = {yellow0Icon, yellow1Icon ,yellow2Icon, yellow3Icon, yellow4Icon, yellow5Icon, yellow6Icon, yellow7Icon, yellow8Icon, yellow9Icon, yellowSkipIcon, yellowReverseIcon, yellowPlus2Icon};
        ImageIcon[] blues = {blue0Icon, blue1Icon ,blue2Icon, blue3Icon, blue4Icon, blue5Icon, blue6Icon, blue7Icon, blue8Icon, blue9Icon, blueSkipIcon, blueReverseIcon, bluePlus2Icon};
        ImageIcon[] greens = {green0Icon, green1Icon ,green2Icon, green3Icon, green4Icon, green5Icon, green6Icon, green7Icon, green8Icon, green9Icon, greenSkipIcon, greenReverseIcon, greenPlus2Icon};
        ImageIcon[] reds = {red0Icon, red1Icon ,red2Icon, red3Icon, red4Icon, red5Icon, red6Icon, red7Icon, red8Icon, red9Icon, redSkipIcon, redReverseIcon, redPlus2Icon};

        for(ImageIcon x: yellows){
            x.setImage(x.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        }
        for(ImageIcon x: greens){
            x.setImage(x.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        }
        for(ImageIcon x: blues){
            x.setImage(x.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        }
        for(ImageIcon x: reds){
            x.setImage(x.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        }
        wildIcon.setImage(wildIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        wildPlus4Icon.setImage(wildPlus4Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));

        DeckOfCards gameCards = new DeckOfCards(reds, blues, yellows, greens, wildIcon, wildPlus4Icon);
        gameCards.shuffle();

        Computer comp1 = new Computer("Seaver");
        Computer comp2 = new Computer("Alex");
        Computer comp3 = new Computer("Cam");

        Player play = new Player("ricky");

        Round round = new Round(new Card(0,"blank",blankIcon));

        JButton showDeck = new JButton("see deck");
        JButton draw = new JButton("Draw card");
        JButton seeOptions = new JButton("See options");
        JLabel label = new JLabel();

        JButton returnToGame = new JButton("return to game");

        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card drawnCard = gameCards.drawCard();
                label.setIcon(drawnCard.getIcon());
                play.addCard(drawnCard);
                round.setLastCard(drawnCard);
                if(gameCards.getSize() == 0){
                    gameCards.reset(reds, blues, yellows, greens);
                    gameCards.shuffle();
                }
            }
        });

        showDeck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerShowDeck.add(returnToGame);
                for(Card x: play.getDeck()){
                    playerShowDeck.add(new JLabel(x.getIcon()));
                }
                //frame.remove(0);
                frame2.add(playerShowDeck);
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });

        returnToGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(500,500);
                for(Component x: playerShowDeck.getComponents()){
                    playerShowDeck.remove(x);
                }
                for(Component x: optionPanel.getComponents()){
                    optionPanel.remove(x);
                }
                //frame.remove(0);
                frame2.setVisible(false);
                optionFrame.setVisible(false);
                frame.setVisible(true);
            }
        });

        seeOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card lastCard = round.getLastCard();
                String color = lastCard.getColor();
                int number = lastCard.getNumber();
                ArrayList<Card> allCards = play.getDeck();
                ArrayList<Card> possibleCards = new ArrayList<Card>();
                for(int i = 0; i < allCards.size(); i++){
                    if(allCards.get(i).getColor().equalsIgnoreCase(color)){
                        possibleCards.add(allCards.remove(i));
                        i--;
                    }
                    else if(allCards.get(i).getNumber() == number){
                        possibleCards.add(allCards.remove(i));
                        i--;
                    }
                }
                optionPanel.add(returnToGame);
                for(Card x: possibleCards){
                    optionPanel.add(new JLabel(x.getIcon()));
                }
                optionFrame.add(optionPanel);
                frame.setVisible(false);
                optionFrame.setVisible(true);

            }
        });

        panel.add(label);
        panel.add(draw);
        panel.add(showDeck);
        panel.add(seeOptions);
        frame.add(panel);
        frame.setVisible(true);
    }
}