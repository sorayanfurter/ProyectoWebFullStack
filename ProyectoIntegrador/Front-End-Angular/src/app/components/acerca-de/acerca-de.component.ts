import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { usuario } from 'src/app/model/usuario.model';
import { UsuarioService } from 'src/app/servicios/acerca-de.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-acerca-de',
  templateUrl: './acerca-de.component.html',
  styleUrls: ['./acerca-de.component.css']
})
export class AcercaDeComponent implements OnInit {
  usuario: usuario = new usuario("nombre", "", "", "", "", ""); 
    

  constructor(public usuarioService: UsuarioService, private tokenService: TokenService) { }
  isLogged = false;
  ngOnInit(): void {
   this.usuarioService.getUsuario().subscribe(data => {this.usuario=data})
   if (this.tokenService.getToken()) {
    this.isLogged = true;
  } else {
    this.isLogged = false;
  }
  }

  public getUsuario(): void {
    this.usuarioService.getUsuario().subscribe({
      next: (response: usuario) => {
        this.usuario = response;
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message)
      }
    })
  }
}
