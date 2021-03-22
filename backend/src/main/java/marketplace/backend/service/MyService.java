package marketplace.backend.service;

public interface MyService<T> {

    public T findById(Long id);

    public T add(T entity);

    public T update(T entity);

    public void deleteById(Long id);
}
