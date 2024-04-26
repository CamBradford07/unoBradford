import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("UNO");
        frame.setSize(1500,750);
        JFrame frame2 = new JFrame("UNO");
        frame2.setSize(500,500);
        JFrame optionFrame = new JFrame("Options");
        optionFrame.setSize(500,500);
        JFrame winnerFrame = new JFrame("Winner");
        winnerFrame.setSize(500, 500);

        JPanel playerShowDeck = new JPanel();
        JPanel panel = new JPanel(new GridLayout(12,10));
        JPanel optionPanel = new JPanel();
        JPanel winnerPanel = new JPanel();

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
        ImageIcon unoIcon = new ImageIcon("Images/uno.png");

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
        unoIcon.setImage(unoIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));

        DeckOfCards gameCards = new DeckOfCards(reds, blues, yellows, greens, wildIcon, wildPlus4Icon);
        gameCards.shuffle();

        Computer comp1 = new Computer("Seaver");
        Computer comp2 = new Computer("Alex");
        Computer comp3 = new Computer("Cam");

        Player play = new Player("Player");

        Round round = new Round(new Card(0,"blank",blankIcon));

        JButton showDeck = new JButton("see deck");
        JButton draw = new JButton("Draw card");
        JLabel label = new JLabel();

        JButton returnToGame = new JButton("return to game");

        Card firstCard = gameCards.drawCard();
        while(firstCard.getColor().equalsIgnoreCase("wild")){
            firstCard = gameCards.drawCard();
        }
        round.setLastCard(firstCard);
        label.setIcon(round.getLastCard().getIcon());

        JButton red0 = new JButton(red0Icon);
        JButton red1 = new JButton(red1Icon);
        JButton red2 = new JButton(red2Icon);
        JButton red3 = new JButton(red3Icon);
        JButton red4 = new JButton(red4Icon);
        JButton red5 = new JButton(red5Icon);
        JButton red6 = new JButton(red6Icon);
        JButton red7 = new JButton(red7Icon);
        JButton red8 = new JButton(red8Icon);
        JButton red9 = new JButton(red9Icon);
        JButton redSkip = new JButton(redSkipIcon);
        JButton redReverse = new JButton(redReverseIcon);
        JButton redPlus2 = new JButton(redPlus2Icon);

        JButton yellow0 = new JButton(yellow0Icon);
        JButton yellow1 = new JButton(yellow1Icon);
        JButton yellow2 = new JButton(yellow2Icon);
        JButton yellow3 = new JButton(yellow3Icon);
        JButton yellow4 = new JButton(yellow4Icon);
        JButton yellow5 = new JButton(yellow5Icon);
        JButton yellow6 = new JButton(yellow6Icon);
        JButton yellow7 = new JButton(yellow7Icon);
        JButton yellow8 = new JButton(yellow8Icon);
        JButton yellow9 = new JButton(yellow9Icon);
        JButton yellowSkip = new JButton(yellowSkipIcon);
        JButton yellowReverse = new JButton(yellowReverseIcon);
        JButton yellowPlus2 = new JButton(yellowPlus2Icon);

        JButton blue0 = new JButton(blue0Icon);
        JButton blue1 = new JButton(blue1Icon);
        JButton blue2 = new JButton(blue2Icon);
        JButton blue3 = new JButton(blue3Icon);
        JButton blue4 = new JButton(blue4Icon);
        JButton blue5 = new JButton(blue5Icon);
        JButton blue6 = new JButton(blue6Icon);
        JButton blue7 = new JButton(blue7Icon);
        JButton blue8 = new JButton(blue8Icon);
        JButton blue9 = new JButton(blue9Icon);
        JButton blueSkip = new JButton(blueSkipIcon);
        JButton blueReverse = new JButton(blueReverseIcon);
        JButton bluePlus2 = new JButton(bluePlus2Icon);

        JButton green0 = new JButton(green0Icon);
        JButton green1 = new JButton(green1Icon);
        JButton green2 = new JButton(green2Icon);
        JButton green3 = new JButton(green3Icon);
        JButton green4 = new JButton(green4Icon);
        JButton green5 = new JButton(green5Icon);
        JButton green6 = new JButton(green6Icon);
        JButton green7 = new JButton(green7Icon);
        JButton green8 = new JButton(green8Icon);
        JButton green9 = new JButton(green9Icon);
        JButton greenSkip = new JButton(greenSkipIcon);
        JButton greenReverse = new JButton(greenReverseIcon);
        JButton greenPlus2 = new JButton(greenPlus2Icon);

        JButton wild = new JButton(wildIcon);
        JButton wildPlus4 = new JButton(wildPlus4Icon);

        JButton redPick = new JButton("RED");
        redPick.setBackground(Color.RED);
        JButton yellowPick = new JButton("YELLOW");
        yellowPick.setBackground(Color.YELLOW);
        JButton bluePick = new JButton("BLUE");
        bluePick.setBackground(Color.CYAN);
        JButton greenPick = new JButton("GREEN");
        greenPick.setBackground(Color.GREEN);

        redPick.setVisible(false);
        yellowPick.setVisible(false);
        greenPick.setVisible(false);
        bluePick.setVisible(false);

        JLabel playName = new JLabel(play.getName());
        JLabel comp1Name = new JLabel(comp1.getName());
        JLabel comp2Name = new JLabel(comp2.getName());
        JLabel comp3Name = new JLabel(comp3.getName());

        JLabel playCardCount = new JLabel("Cards: ");
        JLabel comp1CardCount = new JLabel("Cards: ");
        JLabel comp2CardCount = new JLabel("Cards: ");
        JLabel comp3CardCount = new JLabel("Cards: ");

        JLabel winnerLabel = new JLabel("");

        for(int i = 0; i < 7; i++){
            play.addCard(gameCards.drawCard());
        }
        for(int i = 0; i < 7; i++){
            comp1.addCard(gameCards.drawCard());
        }
        for(int i = 0; i < 7; i++){
            comp2.addCard(gameCards.drawCard());
        }
        for(int i = 0; i < 7; i++){
            comp3.addCard(gameCards.drawCard());
        }

        playCardCount.setText("Cards: " + play.getCardCount());
        comp1CardCount.setText("Cards: " + comp1.getCardCount());
        comp2CardCount.setText("Cards: " + comp2.getCardCount());
        comp3CardCount.setText("Cards: " + comp3.getCardCount());

        Timer timer = new Timer();
        JButton[] allButtons = {redSkip, redReverse, red0, red1, red2, red3, red4, red5, red6, red7, red8, red9, redPlus2, yellowSkip, yellowReverse, yellow0, yellow1, yellow2, yellow3, yellow4, yellow5, yellow6, yellow7, yellow8, yellow9, yellowPlus2, greenSkip, greenReverse, green0, green1, green2, green3, green4, green5, green6, green7, green8, green9, greenPlus2, blueSkip, blueReverse, blue0, blue1, blue2, blue3, blue4, blue5, blue6, blue7, blue8, blue9, bluePlus2, wild, wildPlus4};

        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                play.addCard(gameCards.drawCard());
                playCardCount.setText("Cards: " + play.getCardCount());
                JButton[] allButtons = {redSkip, redReverse, red0, red1, red2, red3, red4, red5, red6, red7, red8, red9, redPlus2, yellowSkip, yellowReverse, yellow0, yellow1, yellow2, yellow3, yellow4, yellow5, yellow6, yellow7, yellow8, yellow9, yellowPlus2, greenSkip, greenReverse, green0, green1, green2, green3, green4, green5, green6, green7, green8, green9, greenPlus2, blueSkip, blueReverse, blue0, blue1, blue2, blue3, blue4, blue5, blue6, blue7, blue8, blue9, bluePlus2, wild, wildPlus4};
                boolean[] options = round.checkOptions(play.getDeck());
                for(int i = 0; i < allButtons.length; i++){
                    allButtons[i].setVisible(options[i]);
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
                frame2.add(playerShowDeck);
                frame.setVisible(false);
                frame2.setVisible(true);
            }
        });

        returnToGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setSize(1500,750);
                for(Component x: playerShowDeck.getComponents()){
                    playerShowDeck.remove(x);
                }
                for(Component x: optionPanel.getComponents()){
                    optionPanel.remove(x);
                }
                frame2.setVisible(false);
                optionFrame.setVisible(false);
                frame.setVisible(true);
            }
        });

        red0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 0));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp2CardCount.setText("Cards: " + comp2.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 1));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 3));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 4));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 5));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 6));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 7));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 8));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        red9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 9));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        redSkip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", -2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
              round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });
        
        redReverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", -1));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                round.reverse();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        redPlus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("red", 10));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                if(round.getDirection() > 0){comp1.plus2(gameCards);}
                else{comp3.plus2(gameCards);}
                round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 0));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 1));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 3));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 4));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 5));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 6));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 7));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 8));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellow9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 9));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellowSkip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", -2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellowReverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", -1));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                round.reverse();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellowPlus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("yellow", 10));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                if(round.getDirection() > 0){comp1.plus2(gameCards);}
                else{comp3.plus2(gameCards);}
                round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 0));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 1));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 3));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);
                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 4));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 5));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 6));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 7));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 8));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        green9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 9));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        greenSkip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", -2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
               round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        greenReverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", -1));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                round.reverse();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        greenPlus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("green", 10));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                if(round.getDirection() > 0){comp1.plus2(gameCards);}
                else{comp3.plus2(gameCards);}
                round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 0));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 1));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 3));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 4));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 5));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 6));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        JButton[] allButtons = {redSkip, redReverse, red0, red1, red2, red3, red4, red5, red6, red7, red8, red9, redPlus2, yellowSkip, yellowReverse, yellow0, yellow1, yellow2, yellow3, yellow4, yellow5, yellow6, yellow7, yellow8, yellow9, yellowPlus2, greenSkip, greenReverse, green0, green1, green2, green3, green4, green5, green6, green7, green8, green9, greenPlus2, blueSkip, blueReverse, blue0, blue1, blue2, blue3, blue4, blue5, blue6, blue7, blue8, blue9, bluePlus2, wild, wildPlus4};
                        boolean[] options = round.checkOptions(play.getDeck());
                        for(int i = 0; i < allButtons.length; i++){
                            allButtons[i].setVisible(options[i]);
                        }
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 7));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 8));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blue9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 9));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blueSkip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", -2));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
               round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        blueReverse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", -1));
                round.setLastCard(playedCard);
                round.reverse();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        bluePlus2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("blue", 10));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(false);
                if(round.getDirection() > 0){comp1.plus2(gameCards);}
                else{comp3.plus2(gameCards);}
                round.nextPlace();

                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        wild.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("wild", 11));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(true);
                redPick.setVisible(true);
                yellowPick.setVisible(true);
                greenPick.setVisible(true);
                bluePick.setVisible(true);
                round.hideButtons(allButtons);
                if(play.getCardCount() == 0){
                    round.setWinner(play.getName());
                    winnerPanel.setBackground(Color.GREEN);
                    winnerFrame.setBackground(Color.GREEN);
                    winnerLabel.setText("Winner: " + round.getWinner());
                    winnerPanel.add(winnerLabel);
                    winnerFrame.add(winnerPanel);
                    frame.setVisible(false);
                    winnerFrame.setVisible(true);
                }

            }
        });

        wildPlus4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Card playedCard = play.playCard(play.findCardIndex("wild", 12));
                round.setLastCard(playedCard);
                playCardCount.setText("Cards: " + play.getCardCount());
                label.setIcon(playedCard.getIcon());
                round.setIsWild(true);
                redPick.setVisible(true);
                yellowPick.setVisible(true);
                greenPick.setVisible(true);
                bluePick.setVisible(true);
                if(round.getDirection() > 0){comp1.plus4(gameCards);}
                else{comp3.plus4(gameCards);}
                round.nextPlace();
                round.hideButtons(allButtons);
                if(play.getCardCount() == 0){
                    round.setWinner(play.getName());
                    winnerPanel.setBackground(Color.GREEN);
                    winnerFrame.setBackground(Color.GREEN);
                    winnerLabel.setText("Winner: " + round.getWinner());
                    winnerPanel.add(winnerLabel);
                    winnerFrame.add(winnerPanel);
                    frame.setVisible(false);
                    winnerFrame.setVisible(true);
                }

            }
        });

        redPick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                round.setWildColor("red");
                redPick.setVisible(false);
                yellowPick.setVisible(false);
                greenPick.setVisible(false);
                bluePick.setVisible(false);
                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        yellowPick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                round.setWildColor("yellow");
                redPick.setVisible(false);
                yellowPick.setVisible(false);
                greenPick.setVisible(false);
                bluePick.setVisible(false);
                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        greenPick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                round.setWildColor("green");
                redPick.setVisible(false);
                yellowPick.setVisible(false);
                greenPick.setVisible(false);
                bluePick.setVisible(false);
                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        bluePick.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                round.setWildColor("blue");
                redPick.setVisible(false);
                yellowPick.setVisible(false);
                greenPick.setVisible(false);
                bluePick.setVisible(false);
                round.hideButtons(allButtons);

                if(play.getCardCount() == 0){round.win(play, frame, winnerFrame, winnerPanel, winnerLabel);}
                round.nextPlace();

                ArrayList<ImageIcon> cardIcons = round.runComputers(play, comp1, comp2, comp3, gameCards);
                round.seeTurns(timer, label, cardIcons);
                comp1CardCount.setText("Cards: " + comp1.getCardCount());
                comp3CardCount.setText("Cards: " + comp3.getCardCount());
                playCardCount.setText("Cards: " + play.getCardCount());

                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                            if(comp1.checkIsWinner()){round.win(comp1, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp2.checkIsWinner()){round.win(comp2, frame, winnerFrame, winnerPanel, winnerLabel);}
                            else if(comp3.checkIsWinner()){round.win(comp3, frame, winnerFrame, winnerPanel, winnerLabel);}
                        
                        round.seeOptions(allButtons, play);
                    }
                }, (cardIcons.size() + 1) * 1000);

            }
        });

        JButton[] skips = {redSkip, yellowSkip, blueSkip, greenSkip};
        JButton[] plus2 = {redPlus2, yellowPlus2, bluePlus2, greenPlus2};
        JButton[] reverses = {greenReverse, blueReverse, yellowReverse, redReverse};
        JButton[] redNums = {red0, red1, red2, red3, red4, red5, red6, red7, red8, red9};
        JButton[] yellowNums = {yellow0, yellow1, yellow2, yellow3, yellow4, yellow5, yellow6, yellow7, yellow8, yellow9};
        JButton[] blueNums = {blue0, blue1, blue2, blue3, blue4, blue5, blue6, blue7, blue8, blue9};
        JButton[] greenNums = {green0, green1, green2, green3, green4, green5, green6, green7, green8, green9};

        round.seeOptions(allButtons,play);

        panel.add(playName);
        panel.add(new JLabel(blankIcon));
        panel.add(new JLabel(blankIcon));
        panel.add(comp1Name);
        panel.add(new JLabel(blankIcon));
        panel.add(new JLabel(blankIcon));
        panel.add(comp2Name);
        panel.add(new JLabel(blankIcon));
        panel.add(new JLabel(blankIcon));
        panel.add(comp3Name);
        panel.add(playCardCount);
        panel.add(new JLabel(blankIcon));
        panel.add(new JLabel(blankIcon));
        panel.add(comp1CardCount);
        panel.add(new JLabel(blankIcon));
        panel.add(new JLabel(blankIcon));
        panel.add(comp2CardCount);
        panel.add(new JLabel(blankIcon));
        panel.add(new JLabel(blankIcon));
        panel.add(comp3CardCount);
        for(int i = 0; i < 10; i++){
            panel.add(new JLabel(blankIcon));
        }
        panel.add(new JLabel(blankIcon));
        panel.add(redPick);
        panel.add(yellowPick);
        panel.add(new JLabel(blankIcon));
        panel.add(label);
        panel.add(new JLabel(unoIcon));
        panel.add(new JLabel(blankIcon));
        panel.add(greenPick);
        panel.add(bluePick);
        panel.add(new JLabel(blankIcon));
        for(int i = 0; i < 20; i++){
            panel.add(new JLabel(blankIcon));
        }
        for(JButton button: plus2){
            panel.add(button);
        }
        for(int i = 0; i < 3; i++){
            panel.add(new JLabel(blankIcon));
        }
        panel.add(draw);
        panel.add(showDeck);
        panel.add(new JLabel(blankIcon));
        for(JButton button: skips){
            panel.add(button);
        }
        panel.add(wild);
        panel.add(wildPlus4);
        for(JButton button: reverses){
            panel.add(button);
        }
        for(JButton button: redNums){
            panel.add(button);
        }
        for(JButton button: yellowNums){
            panel.add(button);
        }
        for(JButton button: blueNums){
            panel.add(button);
        }
        for(JButton button: greenNums){
            panel.add(button);
        }

        frame.add(panel);
        frame.setVisible(true);
    }
}