import javax.smartcardio.Card;

public class Hand {
    private Card vira;
    private final Player player1;
    private final Player player2;
    private final Round[] rounds;
    private final int[] resultados =new int[3];
    private int qtdRounds;
    private int player1Score;
    private int player2Score;

    public Hand(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.rounds = new Round[3];
    }

    public void playRound(){
        if(qtdRounds >=3)return;

        Card card1 = player1.chooseCard();
        Card card2 = player2.chooseCard();
        Round round = new Round(player1.getName(), card1, player2.getName(), card2, vira);
        rounds[qtdRounds] = round;

        int resultadoRound = round.compareValueTo(card1, card2, vira);
        if(resultadoRound>0) resultados[qtdRounds] = 1;
        if(resultadoRound<0) resultados[qtdRounds] = 2;
        if(resultadoRound==0) resultados[qtdRounds] = 0;
        qtdRounds++;

        if(isDone())getWinner();
    }

    private String vencedorDaMao() {
        int r1 = resultados[0];
        int r2 = resultados[1];
        int r3 = resultados[2];

        for (int resultado : resultados) {
            if (resultado == 1) player1Score++;
            if (resultado == 2) player2Score++;
            if (player1Score ==2)return player1.getName();
            if (player2Score ==2)return player2.getName();
        }

        if(r1 == 0 && r2 == 1)return "Vencedor: " + player1.getName();
        if(r1 == 0 && r2 == 2)return "Vencedor: " + player2.getName();
        if(r1 == 1 && r2 == 0) return "Vencedor: " + player1.getName();
        if(r1 == 2 && r2 == 0) return "Vencedor: " + player2.getName();
        if(r1 == 0 && r2 == 0 && r3 == 1)return "Vencedor: " + player1.getName();
        if(r1 == 0 && r2 == 0 && r3 == 2)return "Vencedor: " + player2.getName();
        if(r1 == 1 && r2 ==2 && r3 == 0)return "Vencedor: " + player1.getName();
        if(r1 == 2 && r2 ==1 && r3 == 0)return "Vencedor: " + player2.getName();

        return "Ninguém ganha ponto";
    }

    public boolean isDone(){
        return player1Score == 2 || player2Score == 2 || qtdRounds == 3;
    }

    public String getWinner(){
        return vencedorDaMao();
    }

    public void setVira(Card vira){
        this.vira = vira;
    }
}
