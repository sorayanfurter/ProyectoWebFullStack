export class usuario{
    idUsuario: number;
    nombre: string;
    apellido: string;
    titulo: string;
    imgBanner: string;
    fotoPerfil: string;
    descripcion: string;

    constructor(nombre: string, apellido: string,titulo: string, imgBanner:string, fotoPerfil: string, descripcion: string){
        this.nombre = nombre;
        this.apellido= apellido;
        this.titulo= titulo;
        this.imgBanner = this.imgBanner;
        this.fotoPerfil= fotoPerfil;
        this.descripcion=descripcion;
    }
}