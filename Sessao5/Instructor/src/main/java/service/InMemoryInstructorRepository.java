package service;

import exception.EntityAlreadyExistsException;
import model.Instructor;
import persistence.Repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryInstructorRepository implements Repository<String, Instructor> {
    private final Map<String, Instructor> dataBase = new HashMap<>();

    @Override
    public void save(Instructor entity) {
        if (dataBase.containsKey(entity.getId())) {
            throw new EntityAlreadyExistsException(entity.getId() + "Já exist");
        }
        dataBase.put(entity.getId(), entity);
        System.out.println("Instructor saved: " + entity.getId());
    }

    @Override
    public void update(Instructor entity) {
        if (dataBase.containsKey(entity.getId())) {
            dataBase.put(entity.getId(), entity);
            System.out.println("Instructor updated: " + entity.getId());
        }
        System.out.println("Id não encontrado: " + entity.getId());
    }

    @Override
    public Instructor findById(String id) {
        return dataBase.get(id);
    }

    public Map<String, Instructor> getDataBase() {
        return dataBase;
    }
}
