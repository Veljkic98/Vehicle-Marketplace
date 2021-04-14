package marketplace.backend.exception.exceptions.vehicleType;

public class ModelReferenceTypeConstraintViolationException extends RuntimeException {

    private Long id;

    public ModelReferenceTypeConstraintViolationException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
