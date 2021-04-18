package marketplace.backend.dto.responseDTO;

public class ModelResponseDTO {

    private Long id;

    private String name;

    private Long vehicleTypeId;

    private Long fuelTypeId;

    public ModelResponseDTO(Long id, String name, Long vehicleTypeId, Long fuelTypeId) {
        this.id = id;
        this.name = name;
        this.vehicleTypeId = vehicleTypeId;
        this.fuelTypeId = fuelTypeId;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getVehicleTypeId() {
        return this.vehicleTypeId;
    }

    public void setVehicleTypeId(Long vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public Long getFuelTypeId() {
        return this.fuelTypeId;
    }

    public void setFuelTypeId(Long fuelTypeId) {
        this.fuelTypeId = fuelTypeId;
    }
    
}
