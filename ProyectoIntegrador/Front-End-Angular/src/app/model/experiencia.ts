export class Experiencia {
    idExp?: number;
    nombreExp: string;
    lugarExp: string;
    fechaExp: string;
    descripcionExp: string;

    constructor(nombreExp: string, lugarExp: string, fechaExp: string, descripcionExp: string) {
        this.nombreExp = nombreExp;
        this.lugarExp = lugarExp;
        this.fechaExp = fechaExp;
        this.descripcionExp = descripcionExp;

    }

}
