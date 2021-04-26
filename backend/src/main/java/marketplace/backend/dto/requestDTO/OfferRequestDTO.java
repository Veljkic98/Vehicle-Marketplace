package marketplace.backend.dto.requestDTO;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OfferRequestDTO {

    @NotNull(message = "Post date cannot be null.")
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date date;

    @NotNull(message = "Description cannot be null.")
    private String description;

    @NotNull(message = "Price cannot be null.")
    private double price;

    @NotNull(message = "Location id cannot be null.")
    private Long locationId;
    
    @NotNull(message = "vehicle id cannot be null.")
    private Long vehicleId;

    public OfferRequestDTO() {
    }

    public OfferRequestDTO(Date date, String description, double price, Long locationId, Long vehicleId) {
        this.date = date;
        this.description = description;
        this.price = price;
        this.locationId = locationId;
        this.vehicleId = vehicleId;
    }

    public Date getDate() {
        return this.date;
    }

    public String getDescription() {
        return this.description;
    }

    public double getPrice() {
        return this.price;
    }

    public Long getLocationId() {
        return this.locationId;
    }

    public Long getVehicleId() {
        return this.vehicleId;
    }
    
}
