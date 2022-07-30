export class Educacion {
    idEdu: number;
    nombreEdu: string;
    lugarEdu: string;
    fechaEdu: string;
    descripcionEdu: string;

    constructor(nombreEdu: string, lugarEdu: string, fechaEdu: string, descripcionEdu: string) {
        this.nombreEdu = nombreEdu;
        this.lugarEdu = lugarEdu;
        this.fechaEdu = fechaEdu;
        this.descripcionEdu = descripcionEdu;
    }
}
