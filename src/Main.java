import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame("UNO");
        frame.setSize(500,500);

        JPanel panel = new JPanel();

        ImageIcon red0Icon = new ImageIcon("Images/red0.png");
        red0Icon.setImage(red0Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red1Icon = new ImageIcon("Images/red1.png");
        red1Icon.setImage(red1Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red2Icon = new ImageIcon("Images/red2.png");
        red2Icon.setImage(red2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red3Icon = new ImageIcon("Images/red3.png");
        red3Icon.setImage(red3Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red4Icon = new ImageIcon("Images/red4.png");
        red4Icon.setImage(red4Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red5Icon = new ImageIcon("Images/red5.png");
        red5Icon.setImage(red5Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red6Icon = new ImageIcon("Images/red6.png");
        red6Icon.setImage(red6Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red7Icon = new ImageIcon("Images/red7.png");
        red7Icon.setImage(red7Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red8Icon = new ImageIcon("Images/red8.png");
        red8Icon.setImage(red8Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon red9Icon = new ImageIcon("Images/red9.png");
        red9Icon.setImage(red9Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon redReverseIcon = new ImageIcon("Images/redReverse.png");
        redReverseIcon.setImage(redReverseIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon redPlus2Icon = new ImageIcon("Images/redPlus2.png");
        redPlus2Icon.setImage(redPlus2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon redSkipIcon = new ImageIcon("Images/redSkip.png");
        redSkipIcon.setImage(redSkipIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green0Icon = new ImageIcon("Images/green0.png");
        green0Icon.setImage(green0Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green1Icon = new ImageIcon("Images/green1.png");
        green1Icon.setImage(green1Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green2Icon = new ImageIcon("Images/green2.png");
        green2Icon.setImage(green2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green3Icon = new ImageIcon("Images/green3.png");
        green3Icon.setImage(green3Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green4Icon = new ImageIcon("Images/green4.png");
        green4Icon.setImage(green4Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green5Icon = new ImageIcon("Images/green5.png");
        green5Icon.setImage(green5Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green6Icon = new ImageIcon("Images/green6.png");
        green6Icon.setImage(green6Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green7Icon = new ImageIcon("Images/green7.png");
        green7Icon.setImage(green7Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green8Icon = new ImageIcon("Images/green8.png");
        green8Icon.setImage(green8Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon green9Icon = new ImageIcon("Images/green9.png");
        green9Icon.setImage(green9Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon greenReverseIcon = new ImageIcon("Images/greenReverse.png");
        greenReverseIcon.setImage(greenReverseIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon greenPlus2Icon = new ImageIcon("Images/greenPlus2.png");
        greenPlus2Icon.setImage(greenPlus2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon greenSkipIcon = new ImageIcon("Images/greenSkip.png");
        greenSkipIcon.setImage(greenSkipIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue0Icon = new ImageIcon("Images/blue0.png");
        blue0Icon.setImage(blue0Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue1Icon = new ImageIcon("Images/blue1.png");
        blue1Icon.setImage(blue1Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue2Icon = new ImageIcon("Images/blue2.png");
        blue2Icon.setImage(blue2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue3Icon = new ImageIcon("Images/blue3.png");
        blue3Icon.setImage(blue3Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue4Icon = new ImageIcon("Images/blue4.png");
        blue4Icon.setImage(blue4Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue5Icon = new ImageIcon("Images/blue5.png");
        blue5Icon.setImage(blue5Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue6Icon = new ImageIcon("Images/blue6.png");
        blue6Icon.setImage(blue6Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue7Icon = new ImageIcon("Images/blue7.png");
        blue7Icon.setImage(blue7Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue8Icon = new ImageIcon("Images/blue8.png");
        blue8Icon.setImage(blue8Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blue9Icon = new ImageIcon("Images/blue9.png");
        blue9Icon.setImage(blue9Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blueReverseIcon = new ImageIcon("Images/blueReverse.png");
        blueReverseIcon.setImage(blueReverseIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon bluePlus2Icon = new ImageIcon("Images/bluePlus2.png");
        bluePlus2Icon.setImage(bluePlus2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon blueSkipIcon = new ImageIcon("Images/blueSkip.png");
        blueSkipIcon.setImage(blueSkipIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow0Icon = new ImageIcon("Images/yellow0.png");
        yellow0Icon.setImage(yellow0Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow1Icon = new ImageIcon("Images/yellow1.png");
        yellow1Icon.setImage(yellow1Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow2Icon = new ImageIcon("Images/yellow2.png");
        yellow2Icon.setImage(yellow2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow3Icon = new ImageIcon("Images/yellow3.png");
        yellow3Icon.setImage(yellow3Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow4Icon = new ImageIcon("Images/yellow4.png");
        yellow4Icon.setImage(yellow4Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow5Icon = new ImageIcon("Images/yellow5.png");
        yellow5Icon.setImage(yellow5Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow6Icon = new ImageIcon("Images/yellow6.png");
        yellow6Icon.setImage(yellow6Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow7Icon = new ImageIcon("Images/yellow7.png");
        yellow7Icon.setImage(yellow7Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow8Icon = new ImageIcon("Images/yellow8.png");
        yellow8Icon.setImage(yellow8Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellow9Icon = new ImageIcon("Images/yellow9.png");
        yellow9Icon.setImage(yellow9Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellowReverseIcon = new ImageIcon("Images/yellowReverse.png");
        yellowReverseIcon.setImage(yellowReverseIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellowPlus2Icon = new ImageIcon("Images/yellowPlus2.png");
        yellowPlus2Icon.setImage(yellowPlus2Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon yellowSkipIcon = new ImageIcon("Images/yellowSkip.png");
        yellowSkipIcon.setImage(yellowSkipIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon wildIcon = new ImageIcon("Images/wild.png");
        wildIcon.setImage(wildIcon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));
        ImageIcon wildPlus4Icon = new ImageIcon("Images/wildPlus4.png");
        wildPlus4Icon.setImage(wildPlus4Icon.getImage().getScaledInstance(80, 110, Image.SCALE_DEFAULT));

        ImageIcon[] yellows = {yellow0Icon, yellow1Icon ,yellow2Icon, yellow3Icon, yellow4Icon, yellow5Icon, yellow6Icon, yellow7Icon, yellow8Icon, yellow9Icon, yellowSkipIcon, yellowReverseIcon, yellowPlus2Icon};
        ImageIcon[] blues = {blue0Icon, blue1Icon ,blue2Icon, blue3Icon, blue4Icon, blue5Icon, blue6Icon, blue7Icon, blue8Icon, blue9Icon, blueSkipIcon, blueReverseIcon, bluePlus2Icon};
        ImageIcon[] greens = {green0Icon, green1Icon ,green2Icon, green3Icon, green4Icon, green5Icon, green6Icon, green7Icon, green8Icon, green9Icon, greenSkipIcon, greenReverseIcon, greenPlus2Icon};
        ImageIcon[] reds = {red0Icon, red1Icon ,red2Icon, red3Icon, red4Icon, red5Icon, red6Icon, red7Icon, red8Icon, red9Icon, redSkipIcon, redReverseIcon, redPlus2Icon};

        DeckOfCards gameCards = new DeckOfCards(reds, blues, yellows, greens, wildIcon, wildPlus4Icon);
        gameCards.shuffle();

        Computer comp1 = new Computer("Seaver");
        Computer comp2 = new Computer("Alex");
        Computer comp3 = new Computer("Cam");

        JButton draw = new JButton("Draw card");
        JLabel label = new JLabel();


        draw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setIcon(gameCards.drawCard().getIcon());
                if(gameCards.getSize() == 0){
                    gameCards.reset(reds, blues, yellows, greens);
                    gameCards.shuffle();
                }
            }
        });

        panel.add(label);
        panel.add(draw);
        frame.add(panel);
        frame.setVisible(true);
    }
}