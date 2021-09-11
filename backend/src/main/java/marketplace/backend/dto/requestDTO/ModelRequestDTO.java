package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ModelRequestDTO {

    @NotBlank(message = "Model name cannot be blank.")
    private String name;

    @NotNull(message = "Vehicle make id cannot be null.")
    private Long makeId;

    public ModelRequestDTO() {
    }

    public ModelRequestDTO(String name, Long makeId) {
        this.name = name;
        this.makeId = makeId;
    }

    public String getName() {
        return this.name;
    }

    public Long getMakeId() {
        return this.makeId;
    }

}
