import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { usuario } from 'src/app/model/usuario.model';
import { UsuarioService } from 'src/app/servicios/acerca-de.service';

@Component({
  selector: 'app-editusuario',
  templateUrl: './editusuario.component.html',
  styleUrls: ['./editusuario.component.css']
})
export class EditusuarioComponent implements OnInit {

  usuario: usuario = null;
 

  constructor(private usuarioService: UsuarioService, private activatedRouter: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.usuarioService.getUsuario().subscribe(
      data => {
        this.usuario = data;
      }, err =>{
        alert("Error! No se pudo modificar experiencia");
          this.router.navigate(['']);
      }
    ) 
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.usuarioService.updateUsuario(id, this.usuario).subscribe(
      data => {
        this.router.navigate(['']);
        }, err =>{
          alert("Error! No se pudo modificar educación");
          this.router.navigate(['']);
        }
    )

  }


}
