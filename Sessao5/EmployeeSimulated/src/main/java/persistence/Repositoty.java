package persistence;

import model.Employee;

import java.util.Set;

public interface Repositoty <K, T> {

    void save(T entity);
    void update(T entity);
    Set<Employee> findById(K id);
}
