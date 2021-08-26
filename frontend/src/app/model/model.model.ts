export class Model {
    public id: number;
    public name: string;
    public makeId: number;

    constructor(modelCfg: IModel) {
        this.id = modelCfg.id;
        this.name = modelCfg.name;
        this.makeId = modelCfg.makeId;
    }
}

interface IModel {
    id?: number;
    name: string;
    makeId: number;
}