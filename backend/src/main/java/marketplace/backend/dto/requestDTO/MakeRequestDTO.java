package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.NotBlank;

public class MakeRequestDTO {

    @NotBlank(message = "Make name cannot be blank.")
    private String name;

    public MakeRequestDTO() {
    }

    public MakeRequestDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
