import javax.swing.*;

public class Card{
    private final ImageIcon icon;
    private final int number;
    private final String color;

    public Card(int number, String color, ImageIcon icon){
        this.icon = icon;
        this.number = number;
        this.color = color;
    }

public int getNumber(){
        return number;
}
public String getColor(){
        return  color;
}

public ImageIcon getIcon(){
return icon;
}

}
