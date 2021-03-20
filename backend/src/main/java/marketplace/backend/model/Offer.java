package marketplace.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date; // post date

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne
    private Location location;
    
    @OneToOne
    private Vehicle vehicle;

    @ManyToOne
    private AuthenticatedUser authenticatedUser;

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
