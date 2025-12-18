import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Meeting aula = new Meeting("Aula Web2", LocalTime.of(19,10), LocalTime.of(20,30));
        Meeting aula2 = new Meeting("Aula Web3", LocalTime.of(19,10), LocalTime.of(20,30));
        Meeting estudos = new Meeting("Estudos pós aula", LocalTime.of(21,10), LocalTime.of(23,30));

        Schedule agenda = new Schedule(LocalDate.now(), LocalTime.of(12,0), LocalTime.of(23,40));

        agenda.addMeeting(aula);
        agenda.addMeeting(aula2);
        agenda.addMeeting(estudos);
        agenda.removeMeeting(estudos);
        System.out.printf("Tempo de trabalho em porcentagem: %.2f \n",agenda.percentageSpentInMeetings());

        System.out.println(agenda.scheduleAsString());
    }
}
