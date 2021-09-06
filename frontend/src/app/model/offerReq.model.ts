export class OfferReq {
    public date: string;
    public description: string;
    public price: number;
    public locationId: number;
    public vehicleId: number;

    constructor(offerCfg: IOffer) {
        this.date = offerCfg.date;
        this.description = offerCfg.description;
        this.price = offerCfg.price;
        this.locationId = offerCfg.locationId;
        this.vehicleId = offerCfg.vehicleId;
    }
}

interface IOffer {
    date: string;
    description: string;
    price: number;
    locationId: number;
    vehicleId: number;
}