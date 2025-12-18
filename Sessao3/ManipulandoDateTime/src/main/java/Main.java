
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        int idade = DateTimeUtils.calcularIdade(LocalDate.of(2005,8,22));
        System.out.println(idade);

        LocalDateTime entrada = LocalDateTime.of(2025,9,4,7,0);
        LocalDateTime saida = LocalDateTime.of(2025,9,4,15,0);
        long tempo = DateTimeUtils.tempoDeTrabalho(entrada,saida);
        System.out.printf("%d Horas", tempo);

        String hoje = DateTimeUtils.verificaDiaDaSemana(LocalDate.now());
        System.out.println("\n" + hoje);

        String diasAdicionados = DateTimeUtils.adicionaDiasUteis(2);
        System.out.println("\n" + diasAdicionados);
    }
}
