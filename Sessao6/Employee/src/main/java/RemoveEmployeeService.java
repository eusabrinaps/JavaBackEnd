import java.util.List;
import java.util.Optional;

public class RemoveEmployeeService {
    private final EmployeDAO dao;

    public RemoveEmployeeService(EmployeDAO dao) {
        this.dao = dao;
    }

    void Remove(int id_employee) {
        EmployeDTO employeeToRemoved = dao.findOne(id_employee)
                .orElseThrow(() -> new NoSuchElementException("Employee not found"));
        if(employeToRemoved instanceof Consultant consultant){
            dao.findAll().stream()
                    .filter(emp -> emp.id_manager() == id_employee)
                    .map(emp -> new EmployeDTO(emp.id(), emp.name(), emp.id_manager()))
                    .forEach(dao::update);
        }
//        List<EmployeDTO> listEmployees = dao.findAll();
//        for(EmployeDTO employee: listEmployees){
//            if(employee.id_manager() == id_employee){
//                EmployeDTO employeeUpdate = new EmployeDTO(employee.id(),
//                        employee.name(),
//                        employee.id_manager());
//                dao.update(employeeUpdate);
//            }
//        }
        dao.delete(id_employee);
    }
}
