import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Skill } from 'src/app/model/skill';
import { ImpSkillServiceService } from 'src/app/servicios/imp-skill-service.service';

@Component({
  selector: 'app-editskill',
  templateUrl: './editskill.component.html',
  styleUrls: ['./editskill.component.css']
})
export class EditskillComponent implements OnInit {
  skill: Skill = null;
  constructor(private impSkillService: ImpSkillServiceService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.impSkillService.detail(id).subscribe(
      data => {
        this.skill = data;
      }, err =>{
        alert("Error! No se pudo modificar la Skill");
          this.router.navigate(['']);
      }
    ) 
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.impSkillService.updateSkill(id, this.skill).subscribe(
      data => {
        this.router.navigate(['']);
        }, err =>{
          alert("Error! No se pudo modificar la skill");
          this.router.navigate(['']);
        }
    )

  }
}
