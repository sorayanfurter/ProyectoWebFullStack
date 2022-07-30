import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImpProyectoServiceService } from 'src/app/servicios/imp-proyecto-service.service';

@Component({
  selector: 'app-newproyecto',
  templateUrl: './newproyecto.component.html',
  styleUrls: ['./newproyecto.component.css']
})
export class NewproyectoComponent implements OnInit {
  nombreProyecto: string;
  fechaProyecto: string;
  lugarProyecto: string;
  imgProyecto: string;
  descripcionProyecto: string;

  constructor( private impProyectoService: ImpProyectoServiceService, private router:Router) { }

  ngOnInit(): void {
  }

  onCreate():void{
    const pro = new Proyecto(this.nombreProyecto, this.fechaProyecto, this.lugarProyecto, this.imgProyecto, this.descripcionProyecto);
    this.impProyectoService.saveProyecto(pro).subscribe(
      data =>{
        alert("Proyecto añadido con éxito");
        this.router.navigate(['']);
      }, err =>{
        alert ("Falló")
      }
    )
  }
}
