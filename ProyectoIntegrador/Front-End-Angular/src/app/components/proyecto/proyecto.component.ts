import { Component, OnInit } from '@angular/core';
import { Proyecto } from 'src/app/model/proyecto';
import { ImpProyectoServiceService } from 'src/app/servicios/imp-proyecto-service.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-proyecto',
  templateUrl: './proyecto.component.html',
  styleUrls: ['./proyecto.component.css']
})
export class ProyectoComponent implements OnInit {

  pro: Proyecto[] = [];
  

  constructor(private impProyectoService: ImpProyectoServiceService, private tokenService: TokenService ) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarProyecto();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }
  cargarProyecto(): void {
    this.impProyectoService.lista().subscribe(data => { this.pro = data })

  }

  delete(idProyecto?: number) {
    if (idProyecto != undefined) {
      this.impProyectoService.delete(idProyecto).subscribe(data => {
        this.cargarProyecto();
      }, err => {
        alert("No se pudo borrar el proyecto")
      })
    }
  }

 

}
