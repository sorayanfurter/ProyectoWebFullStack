import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { usuario } from '../model/usuario.model';



@Injectable({
  providedIn: 'root'
})
export class UsuarioService {
  URL = 'https://intense-dusk-90424.herokuapp.com/usuario/';

  constructor(private httpClient: HttpClient) {}

    public getUsuario(): Observable<usuario>{
       return this.httpClient.get<usuario>(this.URL+`listar/1`);
    } 
    
    public lista():Observable<usuario[]>{
      return this.httpClient.get<usuario[]>(this.URL + 'listar/');
    }
  
    public detail(id:number): Observable<usuario>{
     return this.httpClient.get<usuario>(this.URL + `listar/${id}`)
    }
  
    public save(usuario: usuario):Observable<any>{
      return this.httpClient.post<any>(this.URL + 'crear', usuario);
    }
  
    public updateUsuario(id: number, usuario: usuario): Observable<usuario> {
      return this.httpClient.put<any>(this.URL + `editar/${id}`, usuario);
    }
  
    public delete(id: number): Observable<any>{
      return this.httpClient.delete<any>(this.URL + `borrar/${id}`);
    }
  }

