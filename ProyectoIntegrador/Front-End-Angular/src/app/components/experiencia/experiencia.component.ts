import { Component, OnInit } from '@angular/core';
import { Experiencia } from 'src/app/model/experiencia';
import { ImpExperienciaServiceService } from 'src/app/servicios/imp-experiencia-service.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  exp: Experiencia[] = [];

  constructor(private impExpService: ImpExperienciaServiceService, private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarExperiencia(): void {
    this.impExpService.lista().subscribe(data => { this.exp = data })

  }

  delete(idExp?: number) {
    if (idExp != undefined) {
      this.impExpService.delete(idExp).subscribe(data => {
        this.cargarExperiencia();
      }, err => {
        alert("No se pudo borrar la experiencia")
      })
    }
  }
}


