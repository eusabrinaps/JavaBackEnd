package Persistence;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    void insert(T t);
    void update(T t);
    void delete(int id) throws SQLException;
    Optional<T> findOne(int id);
    List<T> findAll();
}
