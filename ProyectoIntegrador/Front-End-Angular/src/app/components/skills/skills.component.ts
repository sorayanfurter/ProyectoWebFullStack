import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Skill } from 'src/app/model/skill';
import { ImpSkillServiceService } from 'src/app/servicios/imp-skill-service.service';
import { NgCircleProgressModule } from 'ng-circle-progress';
import { NgForm } from '@angular/forms';
import { TokenService } from 'src/app/servicios/token.service';
@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {

  public skill: Skill[] = [];
  

  constructor(private impSkillService: ImpSkillServiceService, private tokenService: TokenService) { }
  isLogged = false;
  ngOnInit(): void {
     this.cargarSkill();
    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }

  }
  cargarSkill(): void {
    this.impSkillService.lista().subscribe(data => { this.skill = data })

  }

  delete(idSkill?: number) {
    if (idSkill != undefined) {
      this.impSkillService.delete(idSkill).subscribe(data => {
        this.cargarSkill();
      }, err => {
        alert("No se pudo borrar el proyecto")
      })
    }
  }
  }

  



  




