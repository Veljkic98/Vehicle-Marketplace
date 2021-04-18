package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.NotBlank;

public class FuelTypeRequestDTO {

    @NotBlank(message = "Name of fuel type cannot be blank.")
    private String name;

    public FuelTypeRequestDTO() {
    }

    public FuelTypeRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
}
