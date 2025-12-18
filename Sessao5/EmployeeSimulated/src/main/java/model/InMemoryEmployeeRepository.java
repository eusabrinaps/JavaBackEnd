package model;

import exception.EntityAlreadyExistsException;
import persistence.Repositoty;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryEmployeeRepository implements Repositoty<String, Employee> {
    private final Map<String, Employee> dataBase = new HashMap<>();

    @Override
    public void save(Employee entity) {
        if(entity != null) {
            if(dataBase.containsKey(entity.getId())) {
                throw new EntityAlreadyExistsException("Employee with id " + entity.getId() + " already exists");
            }
            dataBase.put(entity.getId(), entity);
        }
        System.out.println("Sucessfully added");
    }

    @Override
    public void update(Employee entity) {
        if(entity != null) {
            if(dataBase.containsKey(entity.getId())) {
                dataBase.put(entity.getId(), entity);
            }
            else{
                System.out.println("Employee with id " + entity.getId() + " not found");
            }
        }
    }

    @Override
    public Set<Employee> findById(String id) {
        Set<Employee> result = new HashSet<>();
        if(id == null)return result;
        Employee employee;
        if(dataBase.containsKey(id)) {
            employee = dataBase.get(id);
            result.add(employee);
            if(employee instanceof Consultant){
                for (Employee sub : ((Consultant) employee).getSubordinates()){
                    result.addAll(findById(sub.getId()));
                }
            }
        }
        return result;
    }

    public Map<String, Employee> getDataBase() {
        return dataBase;
    }
}
