import java.time.*;

public class Main {
    public static void main(String[] args) {
//        final LocalDate employeeEmploymentDate = LocalDate.of(2022,12,22);
//        final LocalDate birthDate = LocalDate.of(2005,8,22);
//        Employee employee = new Employee("Sabrina",  employeeEmploymentDate, birthDate);
//
//        final LocalDate internEmploymentDate = LocalDate.parse("2020-10-30");
//        final LocalDate internBirthDate = LocalDate.parse("2001-01-23");
//        final Employee intern = new Employee("Dennis Ritchie", internEmploymentDate, internBirthDate);
//
//        System.out.println(employee.isBirth());
//        System.out.println(employee.getYearsOfService());
//
//        System.out.println(intern.isBirth());
//        System.out.println(intern.getYearsOfService());
//
//        //final LocalDate future = LocalDate.now().plusYears(1).plusMonths(4).plusDays(4);
//        LocalDate future = LocalDate.now().plus(Period.of(1,4,4));
//        System.out.println(future);

       final WorkDay  workDay = new WorkDay();
       workDay.checkIn(LocalDateTime.of(2025,9,4,8,2));
       workDay.checkOut(LocalDateTime.of(LocalDate.now(), LocalTime.of(16,59,0)));

       long workedTimeInMinutes = workDay.getWorkedTimeInMinutes();
        System.out.println(workedTimeInMinutes);
        System.out.println(Duration.ofMinutes(workedTimeInMinutes).toHours());
    }
}
