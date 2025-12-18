import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("SC3045838", "Sabrina", LocalDate.of(2025,8,15));
        Student student2 = new Student("SC3049838", "Lucas", LocalDate.of(2023,8,22));

        Course bd1 = new Course("Banco de Dados", "BD", "Pablo", LocalTime.of(19,0),
                    LocalTime.of(22,0), DayOfWeek.MONDAY, Course.Room.C105);

        Course poo = new Course("Java", "POO", "Lucas", LocalTime.of(19,0),
                LocalTime.of(22,0), DayOfWeek.TUESDAY, Course.Room.C106);

        Course web = new Course("Javascript", "JS", "Carlao", LocalTime.of(13,0),
                LocalTime.of(15,0), DayOfWeek.TUESDAY, Course.Room.C106);


        //Fazendo duas Matriculas sem erro
        Enrollment enrollment1 = new Enrollment(student1);
        Enrollment enrollment2 = new Enrollment(student2);
        System.out.println(enrollment1.enroll(bd1));

        //Fazendo matricula com colisao de horario
        System.out.println(enrollment1.enroll(poo));
        System.out.println(enrollment1.enroll(web));

        //String sem concluir
        //System.out.println(enrollment1.getStateAsString());

        //String concluida
        enrollment1.conclude();
        System.out.println(enrollment1.getStateAsString());
    }
}
