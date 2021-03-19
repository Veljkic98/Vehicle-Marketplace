package marketplace.backend.model;

public class Model {

    private Long id;
    private String name;
    private VehicleType vehicleType;
    private FuelType fuelType;

    public Model() {
    }

    public Model(String name, VehicleType vehicleType, FuelType fuelType) {
        this.name = name;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
    }

    public Model(Long id, String name, VehicleType vehicleType, FuelType fuelType) {
        this.id = id;
        this.name = name;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
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

    public VehicleType getVehicleType() {
        return this.vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public FuelType getFuelType() {
        return this.fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", vehicleType='" + getVehicleType() + "'"
                + ", fuelType='" + getFuelType() + "'" + "}";
    }

}
