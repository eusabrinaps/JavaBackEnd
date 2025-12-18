import java.time.LocalDate;
import java.time.Period;

public class Employee {
    private String nome;
    private LocalDate dateOfEmployment;
    private LocalDate birthDate;


    public Employee(String nome, LocalDate dateOfEmployment, LocalDate birthDate) {
        this.nome = nome;
        this.dateOfEmployment = dateOfEmployment;
        this.birthDate = birthDate;
    }

    public int getYearsOfService(){
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public boolean isBirth(){
        return birthDate.getDayOfMonth() == LocalDate.now().getDayOfMonth() && birthDate.getMonth() == LocalDate.now().getMonth();
    }
}
