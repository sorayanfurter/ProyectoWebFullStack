import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JtwDto } from '../model/jtw-dto';
import { LoginUsuariolog } from '../model/login-usuariolog';
import { NuevoUsuariolog } from '../model/nuevo-usuariolog';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  authURL = 'http://localhost:8080/auth/';

  constructor(private httpClient: HttpClient) { }

  public nuevo(nuevoUsuarioLog: NuevoUsuariolog): Observable<any>{
    return this.httpClient.post<any>(this.authURL + 'nuevo', nuevoUsuarioLog);
  }

  public login(loginUsuarioLog: LoginUsuariolog): Observable<JtwDto>{
    return this.httpClient.post<JtwDto>(this.authURL + 'login', loginUsuarioLog)
  }
}
