import java.util.List;

public class FakeEmployeeRepository implements Repository<String, Employee> {
    private List<Employee> dataBase;

    @Override
    public void save(Employee entity) {
        dataBase.add(entity);
    }

    @Override
    public Employee getById(String id) {
        return dataBase.stream()
                .filter(employee -> employee.getId().equals(id)).findFirst().orElse(null);
    }

}
