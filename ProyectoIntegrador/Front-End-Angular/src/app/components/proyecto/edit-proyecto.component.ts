import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ImpProyectoServiceService } from 'src/app/servicios/imp-proyecto-service.service';

@Component({
  selector: 'app-edit-proyecto',
  templateUrl: './edit-proyecto.component.html',
  styleUrls: ['./edit-proyecto.component.css']
})
export class EditProyectoComponent implements OnInit {
  pro: Proyecto = null;
  constructor(private impProyectoService: ImpProyectoServiceService,
    private activatedRouter: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.impProyectoService.detail(id).subscribe(
      data => {
        this.pro = data;
      }, err => {
        alert("Error al editar proyecto");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.impProyectoService.updateProyecto(id, this.pro).subscribe(
      data => {
        this.router.navigate(['']);
      }, err => {
        alert("Error al editar el proyecto");
        this.router.navigate(['']);
      }
    )
  }
}
