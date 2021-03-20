package marketplace.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstRegistration", nullable = false)
    private Date firstRegistration;

    @Column(name = "kilometer", nullable = false)
    private int kilometer;

    @Column(name = "power", nullable = false)
    private int power;

    @Column(name = "cubicCapacity", nullable = false)
    private int cubicCapacity;

    @Column(name = "numberOfDoors", nullable = false)
    private int numberOfDoors;

    @Column(name = "price", nullable = false)
    private double price;

    @ManyToOne
    private Make make;

    @OneToOne
    private File images;

    public Vehicle() {
    }

    public Vehicle(Date firstRegistration, int kilometer, int power, int cubicCapacity, int numberOfDoors, double price,
            Make make, File images) {
        this.firstRegistration = firstRegistration;
        this.kilometer = kilometer;
        this.power = power;
        this.cubicCapacity = cubicCapacity;
        this.numberOfDoors = numberOfDoors;
        this.price = price;
        this.make = make;
        this.images = images;
    }

    public Vehicle(Long id, Date firstRegistration, int kilometer, int power, int cubicCapacity, int numberOfDoors,
            Make make, double price, File images) {
        this.id = id;
        this.firstRegistration = firstRegistration;
        this.kilometer = kilometer;
        this.power = power;
        this.cubicCapacity = cubicCapacity;
        this.numberOfDoors = numberOfDoors;
        this.price = price;
        this.make = make;
        this.images = images;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFirstRegistration() {
        return this.firstRegistration;
    }

    public void setFirstRegistration(Date firstRegistration) {
        this.firstRegistration = firstRegistration;
    }

    public int getKilometer() {
        return this.kilometer;
    }

    public void setKilometer(int kilometer) {
        this.kilometer = kilometer;
    }

    public int getPower() {
        return this.power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getCubicCapacity() {
        return this.cubicCapacity;
    }

    public void setCubicCapacity(int cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Make getMake() {
        return this.make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public File getImages() {
        return this.images;
    }

    public void setImages(File images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", firstRegistration='" + getFirstRegistration() + "'" + ", kilometer='"
                + getKilometer() + "'" + ", power='" + getPower() + "'" + ", cubicCapacity='" + getCubicCapacity() + "'"
                + ", numberOfDoors='" + getNumberOfDoors() + "'" + ", price='" + getPrice() + "'" + "}";
    }

}
