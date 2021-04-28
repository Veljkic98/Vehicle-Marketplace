package marketplace.backend.exception.exceptions.vehicleType;

/**
 * Should be thrown when trying to delete vehicle
 * type or fuel type which are referenced from model.
 * 
 * @author Veljko
 */
public class ModelReferenceConstraintViolationException extends RuntimeException {

    private Long id;

    private String type;

    /**
     * Class constructor.
     * 
     * First letter of type should be uppercase.
     * 
     * @param id    fuel type or vehicle type ID
     * @param type  is fuel type or vehicle type
     */
    public ModelReferenceConstraintViolationException(Long id, String type) {
        this.id = id;
        this.type = type;
    }

    public Long getId() {
        return this.id;
    }

    public String getType() {
        return this.type;
    }
}
