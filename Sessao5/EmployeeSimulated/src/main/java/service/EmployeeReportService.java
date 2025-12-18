package service;

import model.Consultant;
import model.Employee;
import model.InMemoryEmployeeRepository;

public class EmployeeReportService {
    private final InMemoryEmployeeRepository repository;
    public EmployeeReportService(InMemoryEmployeeRepository repository) {
        this.repository = repository;
    }

    public String reportOf(String id) {
        if (id != null) {
            if(repository.getDataBase().containsKey(id)){
                Employee employee = repository.getDataBase().get(id);
                if(employee instanceof Consultant){
                    StringBuilder sb = new StringBuilder();
                    sb.append(employee.getName());
                    ((Consultant) employee).getSubordinates().forEach(subordinate -> sb.append(subordinate.getName()));
                    return sb.toString();
                }
            }
            System.out.println("Id não encontrado no banco");
        }
        return "Id nulo";
    }
}
