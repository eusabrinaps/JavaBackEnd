public interface Repository <K,T>{
    public void save(T entity);
    public T getById(K id);
}
