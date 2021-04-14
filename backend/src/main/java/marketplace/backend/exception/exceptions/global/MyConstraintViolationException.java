package marketplace.backend.exception.exceptions.global;

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
