package marketplace.backend.dto.requestDTO;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VehicleRequestDTO {

    @NotNull(message = "First registration date cannot be null.")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date firstRegistration;

    @NotNull(message = "Mileage cannot be null.")
    private int kilometer;

    @NotNull(message = "Power cannot be null.")
    private int power;

    @NotNull(message = "Cubic capacity cannot be null.")
    private int cubicCapacity;

    @NotNull(message = "Number of doors cannot be null.")
    private int numberOfDoors;

    @NotNull(message = "Model id cannot be null.")
    private Long modelId;

    @NotNull(message = "Vehicle type id cannot be null.")
    private Long vehicleTypeId;

    @NotNull(message = "Vehicle fuel type id cannot be null.")
    private Long fuelTypeId;

    public VehicleRequestDTO() {
    }

    public VehicleRequestDTO(Date firstRegistration, int kilometer, int power, int cubicCapacity, int numberOfDoors, Long modelId, Long vehicleTypeId, Long fuelTypeId) {
        this.firstRegistration = firstRegistration;
        this.kilometer = kilometer;
        this.power = power;
        this.cubicCapacity = cubicCapacity;
        this.numberOfDoors = numberOfDoors;
        this.modelId = modelId;
        this.vehicleTypeId = vehicleTypeId;
        this.fuelTypeId = fuelTypeId;
    }

    public Date getFirstRegistration() {
        return this.firstRegistration;
    }

    public int getKilometer() {
        return this.kilometer;
    }

    public int getPower() {
        return this.power;
    }

    public int getCubicCapacity() {
        return this.cubicCapacity;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public Long getModelId() {
        return this.modelId;
    }

    public Long getVehicleTypeId() {
        return this.vehicleTypeId;
    }

    public Long getFuelTypeId() {
        return this.fuelTypeId;
    }
    
}
