export class FuelType {
    public id: number;
    public name: string;

    constructor(fuelTypeCfg: IFuelType) {
        this.id = fuelTypeCfg.id;
        this.name = fuelTypeCfg.name;
    }
}

interface IFuelType {
    id?: number;
    name: string;
}