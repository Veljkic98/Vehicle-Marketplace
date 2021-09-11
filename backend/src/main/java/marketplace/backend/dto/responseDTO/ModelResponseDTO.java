package marketplace.backend.dto.responseDTO;

public class ModelResponseDTO {

    private Long id;

    private String name;

    private Long makeId;

    public ModelResponseDTO(Long id, String name, Long makeId) {
        this.id = id;
        this.name = name;
        this.makeId = makeId;
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

    public Long getMakeId() {
        return this.makeId;
    }

    public void setMakeId(Long makeId) {
        this.makeId = makeId;
    }

}
