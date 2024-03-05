import javax.swing.*;

public class Card{
    private ImageIcon icon;
    private int number;
    private String color;

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
