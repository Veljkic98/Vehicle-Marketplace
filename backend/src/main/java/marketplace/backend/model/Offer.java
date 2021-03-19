package marketplace.backend.model;

import java.util.Date;

public class Offer {

    private Long id;
    private Date date; // post date
    private String description;
    private Location location;
    private Vehicle vehicle;

    public Offer() {
    }

    public Offer(Date date, String description, Location location, Vehicle vehicle) {
        this.date = date;
        this.description = description;
        this.location = location;
        this.vehicle = vehicle;
    }

    public Offer(Long id, Date date, String description, Location location, Vehicle vehicle) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.location = location;
        this.vehicle = vehicle;
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

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "{" + " date='" + getDate() + "'" + ", description='" + getDescription() + "'" + "}";
    }

}
