import { Model } from "./model.model";
import { Make } from "./make.model";
import { VehicleType } from "./vehicleType.model";
import { FuelType } from "./fuelType.model";

export class Filter {
    public firstRegFrom: string;
    public firstRegTo: string;
    public model: Model;
    public make: Make;
    public priceFrom: number;
    public priceTo: number;
    public ccFrom: number;
    public ccTo: number;
    public hpFrom: number;
    public hpTo: number;
    public kmFrom: number;
    public kmTo: number;
    public vehicleType: VehicleType;
    public fuelType: FuelType;

    constructor() {
    }
}