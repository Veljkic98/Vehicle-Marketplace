package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class MakeRequestDTO {

    @NotBlank(message = "Make name cannot be blank.")
    private String name;

    @NotNull(message = "Model id cannot be null.")
    private Long modelId;

    public MakeRequestDTO() {
    }

    public MakeRequestDTO(String name, Long modelId) {
        this.name = name;
        this.modelId = modelId;
    }

    public String getName() {
        return this.name;
    }

    public Long getModelId() {
        return this.modelId;
    }
    
}
