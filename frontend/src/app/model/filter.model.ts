export class Filter {
    public firstRegFrom: string;
    public firstRegTo: string;
    public modelId: number;
    public makeId: number;
    public priceFrom: number;
    public priceTo: number;
    public ccFrom: number;
    public ccTo: number;
    public hpFrom: number;
    public hpTo: number;
    public kmFrom: number;
    public kmTo: number;
    public vehicleTypeId: number;
    public fuelTypeId: number;

    constructor() {
        // this.firstRegFrom = filterCfg.firstRegFrom;
        // this.firstRegTo = filterCfg.firstRegTo;
        // this.modelId = filterCfg.modelId;
        // this.makeId = filterCfg.makeId;
        // this.priceFrom = filterCfg.priceFrom;
        // this.priceTo = filterCfg.priceTo;
        // this.ccFrom = filterCfg.ccFrom;
        // this.ccTo = filterCfg.ccTo;
        // this.hpFrom = filterCfg.hpFrom;
        // this.hpTo = filterCfg.hpTo;
        // this.kmFrom = filterCfg.kmFrom;
        // this.kmTo = filterCfg.kmTo;
        // this.vehicleTypeId = filterCfg.vehicleTypeId;
        // this.fuelTypeId = filterCfg.fuelTypeId;
    }
}

interface IFilter {
    firstRegFrom: string;
    firstRegTo: string;
    modelId: number;
    makeId: number;
    priceFrom: number;
    priceTo: number;
    ccFrom: number;
    ccTo: number;
    hpFrom: number;
    hpTo: number;
    kmFrom: number;
    kmTo: number;
    vehicleTypeId: number;
    fuelTypeId: number;
}