public class RegisterEmployeeService {
    private final EmployeDAO dao;

    public RegisterEmployeeService(EmployeDAO dao) {
        this.dao = dao;
    }
//    . Caso o registro já exista no
//    banco de dados, lance uma EntityAlreadyExistsException. Se o responsável pelo novo
//    funcionário for não nulo, mas não existir no banco de dados, lance uma
//    NoSuchElementException. Não deve ser possível inserir um usuário nulo ou com id nulo no
//    banco de dados.

    void register(EmployeDTO employee) {
        if(dao.findOne(employee.id()).isPresent()) {throw new EntityAlreadyExistsException("Employee already exists");}
        if(employee.id_manager() != 0){
            if(dao.findOne(employee.id_manager()).isEmpty()){
                throw new NoSuchElementException("Manager not found");
            }
        }
        dao.insert(employee);
    }

}
