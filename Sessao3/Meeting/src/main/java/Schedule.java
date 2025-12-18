import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private final LocalDate day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final Meeting[] meetings;
    private int qtdMeetings;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        meetings = new Meeting[10];
    }

    public void addMeeting(Meeting meeting){
        if(meeting == null)return;
        if(meeting.getStartTime().isBefore(startTime) || meeting.getStartTime().isAfter(endTime)){
            System.out.println("Fora da hr de trabalho");}
        if(!isColision(meeting)){
            meetings[qtdMeetings] = meeting;
            System.out.println("Agendado");
            qtdMeetings++;
        }
        else{
            System.out.println("Já existe compromisso");
        }
    }

    private boolean isColision(Meeting meeting){
        if(meetings.length == 0){return false;}
        for(int i = 0; i <qtdMeetings; i++){
            if(meeting.getStartTime().isBefore(meetings[i].getEndTime())
            && meeting.getEndTime().isAfter(meetings[i].getStartTime()))return true;
        }
        return false;
    }

    public void removeMeeting(Meeting meeting){
        if(meeting == null)return;
        for (int i = 0; i <qtdMeetings; i++) {
            if(meetings[i] == meeting){
                for(int j = i; j < qtdMeetings-1; j++){
                    meetings[j] = meetings[j+1];
                }
            }
        }
        meetings[qtdMeetings - 1] = null;
        qtdMeetings--;
    }

    public double percentageSpentInMeetings(){
        long totalReuniao = 0;
        long totalTrabalho = Duration.between(startTime,endTime).toMinutes();
        if(totalTrabalho == 0)return 0;
        for(int i = 0; i < qtdMeetings; i++){
            totalReuniao += meetings[i].getDurationInMinutes();
        }

        return (double) totalReuniao /totalTrabalho * 100;
    }

    public String scheduleAsString(){
        StringBuilder sb = new StringBuilder("Schedule day");
        sb.append("\n");
        sb.append("|Day: ").append(day);
        sb.append("| Start Time: ").append(startTime);
        sb.append("| End Time: ").append(endTime).append("\n");
        sb.append("\nMeetings:\n ");
        for (int i = 0; i <qtdMeetings; i++) {
            sb.append(meetings[i].getStateAsString()).append("\n");
        }
        return sb.toString();
    }
}
