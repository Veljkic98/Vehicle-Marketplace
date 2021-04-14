package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.NotBlank;

public class ModelRequestDTO {

    @NotBlank(message = "Model name cannot be blank.")
    private String name;

    @NotBlank(message = "Vehicle type id cannot be blank.")
    private Long vehicleTypeId;

    @NotBlank(message = "Fuel type id cannot be blank.")
    private Long fuelTypeId;

    public ModelRequestDTO() {
    }

    public ModelRequestDTO(String name, Long vehicleTypeId, Long fuelTypeId) {
        this.name = name;
        this.vehicleTypeId = vehicleTypeId;
        this.fuelTypeId = fuelTypeId;
    }

    public String getName() {
        return this.name;
    }

    public Long getVehicleTypeId() {
        return this.vehicleTypeId;
    }

    public Long getFuelTypeId() {
        return this.fuelTypeId;
    }
    
}
