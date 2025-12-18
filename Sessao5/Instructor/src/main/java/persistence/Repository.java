package persistence;

public interface Repository <K, T> {
    void save(T entity);
    void update(T entity);
    T findById(K id);
}
