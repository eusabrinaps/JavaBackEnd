import java.time.LocalDate;

public final class Manager extends Employee {
    private String department;

    public Manager(String id, String name, String jobTitle, String department, double salary, LocalDate dateOfEmployment) {
        setId(id);
        setName(name);
        setJobTitle(jobTitle);
        setSalary(salary);
        setDateOfEmployment(dateOfEmployment);
        this.department = department;
    }


    public double calculateProfitSharing(double profit){
        return (getYearsOfService() / 5) * profit * 0.0001;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
