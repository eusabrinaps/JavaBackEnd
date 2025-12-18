import java.time.LocalDate;

public final class PerHourEmployee extends Employee {
    private  double hourlyRate;
    private final int workedHour;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double hourlyRate,
                           int workedHour) {
        super(id, name, jobTitle, dateOfEmployment);
        this.hourlyRate = hourlyRate;
        this.workedHour = workedHour;
    }

    @Override
    public double salary() {
        return hourlyRate * workedHour;
    }

    @Override
    public String toString() {
        return "PerHourEmployee{" +
                "hourlyRate=" + hourlyRate +
                ", workedHour=" + workedHour +
                '}';
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getWorkedHour() {
        return workedHour;
    }
}
