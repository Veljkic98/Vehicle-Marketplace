import { FuelType } from "./fuelType.model";
import { Model } from "./model.model";
import { VehicleType } from "./vehicleType.model";

export class Vehicle {
    public id: number;
    public firstRegistration: Date;
    public kilometer: number;
    public power: number;
    public cubicCapacity: number;
    public numberOfDoors: number;
    public model: Model;
    public vehicleType: VehicleType;
    public fuelType: FuelType;

    constructor() {
        this.model = new Model();
        this.vehicleType = new VehicleType();
        this.fuelType = new FuelType();
    }
}