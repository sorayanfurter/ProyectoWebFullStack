import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Educacion } from 'src/app/model/educacion';
import { ImpEducacionServiceService } from 'src/app/servicios/imp-educacion-service.service';

@Component({
  selector: 'app-new-educacion',
  templateUrl: './new-educacion.component.html',
  styleUrls: ['./new-educacion.component.css']
})
export class NewEducacionComponent implements OnInit {
  nombreEdu: string = '';
  lugarEdu: string = '';
  fechaEdu: string = '';
  descripcionEdu: string = '';

  constructor(private impEduService: ImpEducacionServiceService, private router: Router) { }

  ngOnInit(): void {
    
    
  }

  onCreate(): void {
    const edu = new Educacion(this.nombreEdu, this.lugarEdu, this.fechaEdu, this.descripcionEdu);
    this.impEduService.saveEducacion(edu).subscribe(
      data => {
        alert("Educación añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }

}
