import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PerHourEmployee employee1 = new PerHourEmployee("25", "Alisson", "Arqueira",
                LocalDate.of(2025,01,10), 25, 5);

        PerHourEmployee employee2 = new PerHourEmployee("12", "Scott", "Pedreiro",
                LocalDate.of(2025,05,10), 25, 4);

        FullTimeEmployee employee3 = new FullTimeEmployee("33", "Lidia", "Enfermeira",
                LocalDate.of(2025,2,1), 1300);

        System.out.println(employee1.salary());
        System.out.println(employee2.salary());
        System.out.println(employee3.salary());

        employee3.setMonthlySalary(1500);
        System.out.println(employee3.salary());
    }
}
