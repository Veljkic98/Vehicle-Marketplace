package marketplace.backend.dto.requestDTO;

import javax.validation.constraints.NotBlank;

public class LocationRequestDTO {

    @NotBlank(message = "Country cannot be blank.")
    private String country;

    @NotBlank(message = "City cannot be blank.")
    private String city;

    public LocationRequestDTO() {
    }

    public LocationRequestDTO(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getCity() {
        return this.city;
    }
    
}
