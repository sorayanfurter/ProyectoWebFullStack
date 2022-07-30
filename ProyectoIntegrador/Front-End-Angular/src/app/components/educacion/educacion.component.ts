import { Component, OnInit } from '@angular/core';
import { Educacion } from 'src/app/model/educacion';
import { ImpEducacionServiceService } from 'src/app/servicios/imp-educacion-service.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-educacion',
  templateUrl: './educacion.component.html',
  styleUrls: ['./educacion.component.css']
})
export class EducacionComponent implements OnInit {
  edu: Educacion[] = [];

  constructor(private impEduService: ImpEducacionServiceService, private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarEducacion();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }
  cargarEducacion(): void {
    this.impEduService.lista().subscribe(data => { this.edu = data })

  }

  delete(idEdu?: number) {
    if (idEdu != undefined) {
      this.impEduService.delete(idEdu).subscribe(data => {
        this.cargarEducacion();
      }, err => {
        alert("No se pudo borrar la educación")
      })
    }
  }

}
