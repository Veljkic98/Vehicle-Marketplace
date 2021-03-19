package marketplace.backend.model;

public class VehicleType {

    private Long id;
    private String name;

    public VehicleType() {
    }

    public VehicleType(String name) {
        this.name = name;
    }

    public VehicleType(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + "}";
    }

}
