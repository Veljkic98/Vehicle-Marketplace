package marketplace.backend.model;

public class Location {

    private Long id;
    private String country;
    private String city;

    public Location() {
    }

    public Location(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public Location(Long id, String country, String city) {
        this.id = id;
        this.country = country;
        this.city = city;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", country='" + getCountry() + "'" + ", city='" + getCity() + "'" + "}";
    }

}
