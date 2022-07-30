import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ImpExperienciaServiceService } from 'src/app/servicios/imp-experiencia-service.service';



@Component({
  selector: 'app-new-experiencia',
  templateUrl: './new-experiencia.component.html',
  styleUrls: ['./new-experiencia.component.css']
})
export class NewExperienciaComponent implements OnInit {
  nombreExp: string = '';
  lugarExp: string = '';
  fechaExp: string = '';
  descripcionExp: string = '';

  constructor(private impExpService: ImpExperienciaServiceService, private router: Router) { }

  ngOnInit(): void {
  }
  onCreate(): void {
    const exp = new Experiencia(this.nombreExp, this.lugarExp, this.fechaExp, this.descripcionExp);
    this.impExpService.save(exp).subscribe(
      data => {
        alert("Experiencia añadida");
        this.router.navigate(['']);
      }, err => {
        alert("Falló");
        this.router.navigate(['']);
      }
    )
  }
}
