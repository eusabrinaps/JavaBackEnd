import javax.smartcardio.Card;

public class Round {
    private String winner;

    public Round(String player1, Card card1, String player2, Card card2,
                 Card vira){
        this.player1 = player1;
        this.card1 = card1;
        this.player2 = player2;
        this.card2 = card2;
        this.vira = vira;
    }

    public String getWinner(){
        return winner;
    }
}
