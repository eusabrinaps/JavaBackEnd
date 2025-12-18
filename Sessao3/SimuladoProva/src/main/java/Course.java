import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;
import java.time.Period;

public class Course {
    public enum Room {C102, C104, C105, C106, C107, C209}

    private static int idPadrao;
    private final String name;
    private final String code;
    private final String professor;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final DayOfWeek dayOfWeek;
    private final Room room;

    public Course(String name, String code, String professor, LocalTime startTime, LocalTime endTime, DayOfWeek dayOfWeek, Room room) {
        if(name == null || code == null || professor == null ||room==null|| startTime == null
                || endTime == null || dayOfWeek == null)
        {
            this.name = "Default";
            this.code = "Default";
            this.professor = "Default";
            this.startTime = null;
            this.endTime = null;
            this.dayOfWeek = null;
            this.room = null;
        }else {
            idPadrao = ++idPadrao;
            this.name = name;
            this.code = code;
            this.professor = professor;
            this.startTime = startTime;
            this.endTime = endTime;
            this.dayOfWeek = dayOfWeek;
            this.room = room;
        }

    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public int getWeeklyDurationInMinutes(){
        if(startTime == null || endTime == null){
            System.out.println("Horários indefinidos");
        }
        return (int) Duration.between(startTime, endTime).toMinutes();
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public String getStateAsString(){
        return String.format("| id = %s | %s (%s) | %s | Start = %s | End = %s | %s | Room = %s",idPadrao,name,code,
                professor,startTime,endTime,room,dayOfWeek, room);
    }
}