import javax.smartcardio.Card;

public class Player {
    private final String name;
    private final int score=0;
    private Card[] cards;

    public Player(String name) {
        this.name = name;
    }

    public void setCards(Card[] cards) {


    }

    public Card chooseCard(){

    }

    public void increaseScore(){
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
