export class OfferRes {
    public id: number;
    public date: Date;
    public description: string;
    public price: number;
    public locationId: number;
    public vehicleId: number;
    public authenticatedUserId: number;
    public imageUri: string;

    constructor(offerCfg: IOffer) {
        this.id = offerCfg.id;
        this.date = offerCfg.date;
        this.description = offerCfg.description;
        this.price = offerCfg.price;
        this.locationId = offerCfg.locationId;
        this.vehicleId = offerCfg.vehicleId;
        this.authenticatedUserId = offerCfg.authenticatedUserId;
        this.imageUri = offerCfg.imageUri;
    }
}

interface IOffer {
    id?: number;
    date: Date;
    description: string;
    price: number;
    locationId: number;
    vehicleId: number;
    authenticatedUserId: number;
    imageUri: string;
}