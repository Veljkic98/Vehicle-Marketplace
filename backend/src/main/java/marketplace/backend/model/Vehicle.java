package marketplace.backend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

    @ManyToOne
    private Model model;

    @ManyToOne
    private VehicleType vehicleType;

    @ManyToOne
    private FuelType fuelType;

    public Vehicle() {
    }

    public Vehicle(Date firstRegistration, int kilometer, int power, int cubicCapacity, int numberOfDoors, Model model, VehicleType vehicleType, FuelType fuelType) {
        this.firstRegistration = firstRegistration;
        this.kilometer = kilometer;
        this.power = power;
        this.cubicCapacity = cubicCapacity;
        this.numberOfDoors = numberOfDoors;
        this.model = model;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
    }

    public Vehicle(Long id, Date firstRegistration, int kilometer, int power, int cubicCapacity, int numberOfDoors,
        Model model, VehicleType vehicleType, FuelType fuelType) {
        this.id = id;
        this.firstRegistration = firstRegistration;
        this.kilometer = kilometer;
        this.power = power;
        this.cubicCapacity = cubicCapacity;
        this.numberOfDoors = numberOfDoors;
        this.model = model;
        this.vehicleType = vehicleType;
        this.fuelType = fuelType;
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

    public Model getModel() {
        return this.model;
    }

    public void setModel(Model model) {
        this.model = model;
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
        return "{" + " id='" + getId() + "'" + ", firstRegistration='" + getFirstRegistration() + "'" + ", kilometer='"
                + getKilometer() + "'" + ", power='" + getPower() + "'" + ", cubicCapacity='" + getCubicCapacity() + "'"
                + ", numberOfDoors='" + getNumberOfDoors() + "'" + "}";
    }

}
