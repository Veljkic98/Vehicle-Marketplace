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

    @NotNull(message = "Make id cannot be null.")
    private Long makeId;

    public VehicleRequestDTO() {
    }

    public VehicleRequestDTO(Date firstRegistration, int kilometer, int power, int cubicCapacity, int numberOfDoors, Long makeId) {
        this.firstRegistration = firstRegistration;
        this.kilometer = kilometer;
        this.power = power;
        this.cubicCapacity = cubicCapacity;
        this.numberOfDoors = numberOfDoors;
        this.makeId = makeId;
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

    public Long getMakeId() {
        return this.makeId;
    }

}
