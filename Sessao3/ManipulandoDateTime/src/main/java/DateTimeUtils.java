import java.time.*;

public class DateTimeUtils {

    //Métodos
    public static int calcularIdade(LocalDate nascimento){
        return Period.between(nascimento, LocalDate.now()).getYears();
    }

    public static long tempoDeTrabalho(LocalDateTime checkIn, LocalDateTime checkOut){
        return Duration.between(checkIn,checkOut).toHours();
    }


    public static String verificaDiaDaSemana(LocalDate dia){
        return "Dia da semana: " + dia.getDayOfWeek();
    }

    public static String adicionaDiasUteis(int dias){
        LocalDate data =  LocalDate.now();
        int diasAdicionados = 0;

        while (diasAdicionados < dias){
            data = data.plusDays(1);
            DayOfWeek diaSemana = data.getDayOfWeek();
            if(!diaSemana.equals(DayOfWeek.SATURDAY) && !diaSemana.equals(DayOfWeek.SUNDAY)){
                diasAdicionados++;
            }
        }

        return data.toString();
    }
}