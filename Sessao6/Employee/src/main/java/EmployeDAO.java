import java.util.List;
import java.util.Optional;

public interface EmployeDAO {
    void insert(EmployeDTO employee);
    void update(EmployeDTO employee);
    void delete(int id);
    Optional<EmployeDTO> findOne(int id);
    List<EmployeDTO> findAll();
}
