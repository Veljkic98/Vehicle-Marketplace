export class Make {
    public id: number;
    public name: string;

    constructor(makeCfg: IMake) {
        this.id = makeCfg.id;
        this.name = makeCfg.name;
    }
}

interface IMake {
    id?: number;
    name: string;
}