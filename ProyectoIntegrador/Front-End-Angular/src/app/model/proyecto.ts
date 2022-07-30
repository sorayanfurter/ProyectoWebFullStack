export class Proyecto {

 idProyecto?: number;
 nombreProyecto: string;
 lugarProyecto: string;
 fechaProyecto: string;
 imgProyecto: string;
 descripcionProyecto: string;

 constructor(nombreProyecto: string, lugarProyecto: string, fechaProyecto: string, imgProyecto: string, descripcionProyecto: string){
    this.nombreProyecto = nombreProyecto;
    this.lugarProyecto = lugarProyecto;
    this.fechaProyecto = fechaProyecto;
    this.imgProyecto = imgProyecto;
    this.descripcionProyecto = descripcionProyecto;
 }

 
}
