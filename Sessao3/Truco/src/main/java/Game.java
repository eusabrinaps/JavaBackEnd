public class Game {
    private final Player player1;
    private final Player player2;
    private Hand[] hands;

    public Game(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(){

    }

    public boolean isDone(){

    }

    public Player getWinner(){
        int maior = Math.max(player1.getScore(), player2.getScore());
        return maior == player1.getScore() ? player1 : player2;
    }
}
