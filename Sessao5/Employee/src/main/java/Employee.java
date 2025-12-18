import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee {
    private final String id;
    private final String name;
    private final String jobTtile;
    private final double salary;
    private final LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTtile, double salary, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTtile = jobTtile;
        this.salary = salary;
        this.dateOfEmployment = dateOfEmployment;
    }

    public double getYearsOfService(){
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }
    public double calculateBonus(){
        return salary*0.1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTtile='" + jobTtile + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTtile() {
        return jobTtile;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
