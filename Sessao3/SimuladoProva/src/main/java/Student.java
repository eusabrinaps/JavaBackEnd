import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private final String id;
    private final String name;
    private final LocalDate admissionDate;


    public Student(String id, String name, LocalDate admissionDate) {
        if(isValid(id)){
            this.id = id;
            this.name = name;
            this.admissionDate = admissionDate;
        }else{
            this.id = null;
            this.name = "Default";
            this.admissionDate = LocalDate.of(1, 1, 1);
        }

    }

    public boolean isValid(String id) {
        if(id == null) return false;
        if(id.length() != 9) return false;
        if(!id.startsWith("SC"))return false;
        if(!Character.isDigit(id.charAt(8)) && id.charAt(8) != 'X') return false;

        for(int i =2; i <8; i++){
            if(!Character.isDigit(id.charAt(i))) return false;
        }

        return true;
    }

    public int getSemester(){
        long period = Period.between(LocalDate.now(), admissionDate).toTotalMonths();
        return (int) period/6 + 1;
    }

    public String getStateAsString(){
        DateTimeFormatter dataFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        return String.format("%s | %s | Admission date = %s", id, name, admissionDate.format(dataFormatter));
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public LocalDate getAdmissionDate() {
        return admissionDate;
    }


}
