package marketplace.backend.dto.responseDTO;

import java.util.Date;

public class OfferResponseDTO {

    private Long id;

    private Date date;

    private String description;

    private double price;

    private Long locationId;

    private Long vehicleId;

    private Long authenticatedUserId;

    private String imageUri;

    public OfferResponseDTO(Long id, Date date, String description, double price, Long locationId, Long vehicleId,
            Long authenticatedUserId, String imageUri) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.price = price;
        this.locationId = locationId;
        this.vehicleId = vehicleId;
        this.authenticatedUserId = authenticatedUserId;
        this.imageUri = imageUri;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getLocationId() {
        return this.locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getVehicleId() {
        return this.vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Long getAuthenticatedUserId() {
        return this.authenticatedUserId;
    }

    public void setAuthenticatedUserId(Long authenticatedUserId) {
        this.authenticatedUserId = authenticatedUserId;
    }

    public String getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

}
