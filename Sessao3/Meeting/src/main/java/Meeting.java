import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long getDurationInMinutes() {
        return Duration.between(startTime, endTime).toMinutes();
    }

    public String getDescription() {
        return description;
    }

    public String getStateAsString() {
        return description +" "+ startTime.toString() + " - " + endTime.toString();
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
