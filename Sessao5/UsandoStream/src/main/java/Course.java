import java.util.List;

public class Course {
    private String name;
    private List<String> students;
    // construtor, getters

    public Course(String name, List<String> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<String> getStudents() {
        return students;
    }
}


