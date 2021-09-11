import { Location } from './location.model';
import { AuthUser } from "./authUser.model";
import { Vehicle } from "./vehicle.model";

export class Offer {
    public id: number;
    public date: Date;
    public description: string;
    public price: number;
    public location: Location;
    public vehicle: Vehicle;
    public authenticatedUser: AuthUser;
    public imageUri: string;

    constructor() {
        this.location = new Location();
        this.vehicle = new Vehicle();
        this.authenticatedUser = new AuthUser();
    }
}
