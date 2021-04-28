package marketplace.backend.exception.exceptions.vehicleType;

/**
 * Should be thrown when trying to delete vehicle
 * type or fuel type which are referenced from model.
 * 
 * @author Veljko
 */
public class ModelReferenceTypeConstraintViolationException extends RuntimeException {

    private Long id;

    public ModelReferenceTypeConstraintViolationException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
