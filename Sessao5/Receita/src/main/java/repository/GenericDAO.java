package repository;

import model.Declaracao;

import java.util.*;

public abstract class GenericDAO<K, T extends Entidade<K>> {
    private final Map <K, T> dataBase = new HashMap<>();

    public void create(T entidade) {
        dataBase.put(entidade.getId(), entidade);
        System.out.println("Criado com sucesso");
    }

    public void update(T entidade) {
        if(dataBase.containsKey(entidade.getId())) {
            dataBase.put(entidade.getId(), entidade);
            System.out.println("Atualizado com sucesso");
        }
        System.out.println("Não existe no banco");
    }

    public Optional<T> getById(K id) {
        return  Optional.ofNullable(dataBase.get(id));
    }

    public void deleteById(K id) {dataBase.remove(id);}

    public List<T> getAll() {
        return new ArrayList<>(dataBase.values());
    }

}
