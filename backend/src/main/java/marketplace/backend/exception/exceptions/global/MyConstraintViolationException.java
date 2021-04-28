package marketplace.backend.exception.exceptions.global;

/**
 * This custom exception should be thrown when, for example,
 * trying to delete entity which we can not delete.
 * 
 * @author Veljko
 */
public class MyConstraintViolationException extends RuntimeException {

    private String primaryEntity;

    private String foreignEntity;
    
    private Long id;

    public MyConstraintViolationException(String primaryEntity, String foreignEntity, Long id) {
        this.primaryEntity = primaryEntity;
        this.foreignEntity = foreignEntity;
        this.id = id;
    }

    public String getPrimaryEntity() {
        return this.primaryEntity;
    }

    public String getForeignEntity() {
        return this.foreignEntity;
    }

    public Long getId() {
        return this.id;
    }
    
}
