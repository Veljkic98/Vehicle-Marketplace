package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.NotBlank;

public class VehicleTypeRequestDTO {

    @NotBlank(message = "Name of vehicle type cannot be blank.")
    private String name;

    public VehicleTypeRequestDTO() {
    }

    public VehicleTypeRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
}
