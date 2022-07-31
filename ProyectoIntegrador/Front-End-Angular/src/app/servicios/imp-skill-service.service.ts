import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Skill } from "../model/skill";

@Injectable({
    providedIn: 'root'
  })
  export class ImpSkillServiceService {
  skillURL = 'https://intense-dusk-90424.herokuapp.com/skill/'

  constructor( private httpClient: HttpClient) { }

  public lista():Observable<Skill[]>{
    return this.httpClient.get<Skill[]>(this.skillURL + 'listar/');
  }

  public detail(id:number): Observable<Skill>{
    return this.httpClient.get<Skill>(this.skillURL + `listar/${id}`)
  }

  public saveSkill(skill: Skill):Observable<any>{
    return this.httpClient.post<Skill>(this.skillURL + 'crear', skill)
  }

  public updateSkill(id: number, skill: Skill): Observable<any> {
    return this.httpClient.put<any>(this.skillURL + `editar/${id}`, skill);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.skillURL + `borrar/${id}`);
  }
  } 