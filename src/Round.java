public class Round {
    private Card lastCard;

    public Round(Card card){
        lastCard = card;
    }

    public void setLastCard(Card newLastCard){
        lastCard = newLastCard;
    }

    public Card getLastCard() {
        return lastCard;
    }
}
