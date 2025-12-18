public class UpdateEmployeeService {
    private final EmployeDAO dao;

    public UpdateEmployeeService(EmployeDAO dao) {
        this.dao = dao;
    }

    void update(EmployeDTO employee) {
        if(dao.findOne(employee.id()).isEmpty()){throw new NoSuchElementException("Employee not found");}
        if(employee.id_manager() != 0){
            if(dao.findOne(employee.id_manager()).isEmpty()){
                throw new NoSuchElementException("Employee manager not found");
            }
        }
        dao.update(employee);
    }
}
