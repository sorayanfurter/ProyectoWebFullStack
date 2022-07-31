import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Educacion } from '../model/educacion';

@Injectable({
  providedIn: 'root'
})
export class ImpEducacionServiceService {
 eduURL= 'https://intense-dusk-90424.herokuapp.com/educacion/'

  constructor(private httpClient:HttpClient) { }

  public lista():Observable<Educacion[]>{
    return this.httpClient.get<Educacion[]>(this.eduURL + 'listar/');
  }

  public detail(id:number): Observable<Educacion>{
    return this.httpClient.get<Educacion>(this.eduURL + `listar/${id}`)
  }

  public saveEducacion(educacion: Educacion):Observable<any>{
    return this.httpClient.post<Educacion>(this.eduURL + 'crear', educacion)
  }

  public update(id: number, educacion: Educacion): Observable<any> {
    return this.httpClient.put<any>(this.eduURL + `editar/${id}`, educacion);
  }

  public delete(id: number): Observable<any>{
    return this.httpClient.delete<any>(this.eduURL + `borrar/${id}`);
  }
}
