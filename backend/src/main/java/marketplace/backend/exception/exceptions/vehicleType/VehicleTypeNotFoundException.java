package marketplace.backend.exception.exceptions.vehicleType;

public class VehicleTypeNotFoundException extends RuntimeException {

    private Long id;

    public VehicleTypeNotFoundException(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
    
}
