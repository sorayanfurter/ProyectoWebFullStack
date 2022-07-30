import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Experiencia } from 'src/app/model/experiencia';
import { ImpExperienciaServiceService } from 'src/app/servicios/imp-experiencia-service.service';

@Component({
  selector: 'app-edit-experiencia',
  templateUrl: './edit-experiencia.component.html',
  styleUrls: ['./edit-experiencia.component.css']
})
export class EditExperienciaComponent implements OnInit {
 exp: Experiencia = null;
  constructor(private impExpService: ImpExperienciaServiceService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.impExpService.detail(id).subscribe(
      data => {
        this.exp = data;
      }, err =>{
        alert("Error! No se pudo modificar experiencia");
          this.router.navigate(['']);
      }
    ) 
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.impExpService.update(id, this.exp).subscribe(
      data => {
        this.router.navigate(['']);
        }, err =>{
          alert("Error! No se pudo modificar experiencia");
          this.router.navigate(['']);
        }
    )

  }

}
