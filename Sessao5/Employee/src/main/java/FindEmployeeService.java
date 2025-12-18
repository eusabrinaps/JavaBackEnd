public class FindEmployeeService {
    private final Repository<String, Employee> repository;

    public FindEmployeeService(Repository<String, Employee> repository) {
        this.repository = repository;
    }

    public Employee findById(String id) {
        if (id != null) {
            if (repository.getById(id) != null) {
                return repository.getById(id);
            }
        }
        System.out.println("Id não encontrado");
        return null;
    }
}
