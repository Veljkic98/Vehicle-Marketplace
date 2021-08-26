export class VehicleType {
    public id: number;
    public name: string;

    constructor(vehicleTypeCfg: IVehicleType) {
        this.id = vehicleTypeCfg.id;
        this.name = vehicleTypeCfg.name;
    }
}

interface IVehicleType {
    id?: number;
    name: string;
}