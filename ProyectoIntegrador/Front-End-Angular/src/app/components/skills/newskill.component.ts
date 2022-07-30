import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { ImpSkillServiceService } from 'src/app/servicios/imp-skill-service.service';

@Component({
  selector: 'app-newskill',
  templateUrl: './newskill.component.html',
  styleUrls: ['./newskill.component.css']
})
export class NewskillComponent implements OnInit {
  nombreSkill: string;
  imgSkill: string;
  porcentajeSkill: number;
  

  constructor( private impSkillService: ImpSkillServiceService, private router:Router) { }

  ngOnInit(): void {
  }

  onCreate():void{
    const skill = new Skill(this.nombreSkill, this.imgSkill, this.porcentajeSkill);
    this.impSkillService.saveSkill(skill).subscribe(
      data =>{
        alert("Skill añadida con éxito");
        this.router.navigate(['']);
      }, err =>{
        alert ("Falló")
      }
    )
  }

}
