import java.time.LocalDate;
import java.time.LocalDateTime;

public class Enrollment {
    private int id;
    private LocalDateTime enrollmentTime;
    private boolean concluded;
    private final Student student;
    private Course[] courses;
    private int qtdCourses;

    public Enrollment(Student student) {
        if(student == null || student.getId() == null){
            id = id;
            this.enrollmentTime = null;
            this.concluded = true;
            this.student = student;
        }else{
            id = ++id;
            this.student = student;
            courses = new Course[10];
        }


    }

    public boolean enroll(Course course) {
        if(course == null || concluded) return false;
        if(isColision(course))return false;
        int horas = totalMinutes() + course.getWeeklyDurationInMinutes();
        if(horas > 22 * 60)return false;

        courses[qtdCourses] = course;
        qtdCourses++;
        return true;
    }

    public boolean isColision(Course course) {
        for(int i = 0; i <qtdCourses; i++){
            if(courses[i].getDayOfWeek() == course.getDayOfWeek()){
                if(course.getStartTime().isBefore(courses[i].getEndTime()) &&
                        course.getEndTime().isAfter(courses[i].getStartTime())) return true;
            }
        }
        return false;
    }

    public int totalMinutes(){
        int soma = 0;
        for(int i = 0; i <qtdCourses; i++){
            soma+= courses[i].getWeeklyDurationInMinutes();
        }
        return soma;
    }

    public void remove(Course course) {
        if(courses == null || concluded) return;
        for(int i = 0; i < qtdCourses; i++){
            if(courses[i] == course){
                courses[i] = courses[qtdCourses - 1];
                courses[qtdCourses - 1] = null;
                qtdCourses--;
            }
        }
    }

    public void conclude(){
        concluded = true;
        enrollmentTime = LocalDateTime.now();
    }

    public String getStateAsString(){
        StringBuilder sb = new StringBuilder();
        if(!concluded) sb.append("Enrollment not concluded!\n");
        if(id == 0) sb.append("Invalid enrollment!");
        else {
            sb.append(student.getStateAsString()).append("\n");
            sb.append("Enrollment Time: ").append(enrollmentTime).append("\n");
            sb.append("-------------------------------------------------------------------------------------------------------------------------------");
            sb.append("Courses:\n");
                for (int i = 0; i < qtdCourses; i++) {
                    sb.append(courses[i].getStateAsString()).append("\n");
                }
        }
        return sb.toString();
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getEnrollmentTime() {
        return enrollmentTime;
    }

    public boolean isConcluded() {
        return concluded;
    }

    public Student getStudent() {
        return student;
    }
}
