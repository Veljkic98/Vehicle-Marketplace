package marketplace.backend.service;

public interface MyService<T> {

    /**
     * Find and return entity if exists, otherwise throws exception. 
     * 
     * @param id The id of entity.
     * @return The entity if exists.
     * @throws EntityNotFoundException if entity does not exist.
     */
    public T findById(Long id);

    /**
     * Save entity.
     * 
     * @param entity The entity to save.
     * @return the saved entity.
     * @throws IllegalArgumentException if entity is not valid.
     */
    public T add(T entity);

    /**
     * Update entity.
     * 
     * @param entity the entity to updated.
     * @return the updated entity.
     * @throws EntityNotFoundException if there is no entity with {@literal entitiy} id.
     */
    public T update(T entity);

    /**
     * Delete entity.
     * 
     * @param id The id of entity.
     * @throws EntityNotFoundException if there is no entity with id.
     */
    public void deleteById(Long id);
}
