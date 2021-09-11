import { Make } from "./make.model";

export class Model {
    public id: number;
    public name: string;
    public make: Make;

    constructor() {
        this.make = new Make();
    }
}