package marketplace.backend.exception.exceptions.global;

/**
 * Exception should be thrown when trying to find
 * entity which not exists.
 * 
 * @author Veljko 
 */
public class MyEntityNotFoundException extends RuntimeException {

    private String entityName;

    private Long id;

    /**
     * Class constructor.
     * 
     * @param entityName    is name of entity. E.g User, Offer...
     * @param id            of entity
     */
    public MyEntityNotFoundException(String entityName, Long id) {
        this.entityName = entityName;
        this.id = id;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public Long getId() {
        return this.id;
    }
    
}
