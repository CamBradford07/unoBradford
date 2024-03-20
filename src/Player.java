import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> deck;

    public Player(String name){
        deck = new ArrayList<Card>();
        this.name = name;
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public void addCard(Card newCard){
        deck.add(newCard);
    }

    public boolean hasYellows(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("yellow")){
                return true;
            }
        }
        return false;
    }

    public boolean hasReds(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("red")){
                return true;
            }
        }
        return false;
    }

    public boolean hasGreens(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("green")){
                return true;
            }
        }
        return false;
    }
  
    public boolean hasBlues(){
        for(Card x: deck){
            if(x.getColor().equalsIgnoreCase("blue")){
                return true;
            }
        }
        return false;
    }

  public boolean hasZeroes(){
      for(Card x: deck){
          if(x.getNumber() == 0){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasOnes(){
      for(Card x: deck){
          if(x.getNumber() == 1){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasTwos(){
      for(Card x: deck){
          if(x.getNumber() == 2){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasThrees(){
      for(Card x: deck){
          if(x.getNumber() == 3){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasFours(){
      for(Card x: deck){
          if(x.getNumber() == 4){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasFives(){
      for(Card x: deck){
          if(x.getNumber() == 5){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasSixes(){
      for(Card x: deck){
          if(x.getNumber() == 6){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasSevens(){
      for(Card x: deck){
          if(x.getNumber() == 7){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasEights(){
      for(Card x: deck){
          if(x.getNumber() == 8){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasNines(){
      for(Card x: deck){
          if(x.getNumber() == 9){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasSkips(){
      for(Card x: deck){
          if(x.getNumber() == -2){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasReverse(){
      for(Card x: deck){
          if(x.getNumber() == -1){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasPlus2(){
      for(Card x: deck){
          if(x.getNumber() == 10){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasWilds(){
      for(Card x: deck){
          if(x.getNumber() == 11){
              return true;
          }
      }
      return false;
  }
  
  public boolean hasPlus4(){
      for(Card x: deck){
          if(x.getNumber() == 12){
              return true;
          }
      }
      return false;
  }
  
}
