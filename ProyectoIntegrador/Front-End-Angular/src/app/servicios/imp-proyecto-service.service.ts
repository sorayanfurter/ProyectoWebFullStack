import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Proyecto } from '../model/proyecto';

@Injectable({
  providedIn: 'root'
})
export class ImpProyectoServiceService {

  proURL = "http://localhost:8080/proyecto/"

  constructor( private httpClient: HttpClient) { }

  public lista():Observable<Proyecto[]>{
    return this.httpClient.get<Proyecto[]>(this.proURL + 'listar/');
  }

  public detail(id:number): Observable<Proyecto>{
    return this.httpClient.get<Proyecto>(this.proURL + `listar/${id}`)
  }

  public saveProyecto(proyecto: Proyecto):Observable<any>{
    return this.httpClient.post<Proyecto>(this.proURL + 'crear', proyecto)
  }

  public updateProyecto(id: number, proyecto: Proyecto): Observable<any> {
    return this.httpClient.put<any>(this.proURL + `editar/${id}`, proyecto);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.proURL + `borrar/${id}`);
  }
}