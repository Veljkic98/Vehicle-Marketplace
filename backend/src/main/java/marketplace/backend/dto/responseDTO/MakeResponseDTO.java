package marketplace.backend.dto.responseDTO;

public class MakeResponseDTO {

    private Long id;

    private String name;

    private Long modelId;

    public MakeResponseDTO(Long id, String name, Long modelId) {
        this.id = id;
        this.name = name;
        this.modelId = modelId;
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

    public Long getModelId() {
        return this.modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }
    
}
