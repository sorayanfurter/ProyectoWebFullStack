import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginUsuariolog } from 'src/app/model/login-usuariolog';
import { AuthService } from 'src/app/servicios/auth.service';
import { TokenService } from 'src/app/servicios/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
isLogged = false;
isLoginFail = false;
loginUsuarioLog! : LoginUsuariolog;
nombreUsuarioLog!: string;
password!: string;
roles: string[] = [];
errMsj!: string;

  constructor(private tokenService: TokenService, private authService: AuthService, private router: Router) {}
  ngOnInit(): void {
      if(this.tokenService.getToken()){
       this.isLogged= true;
       this.isLoginFail= false;
       this.roles= this.tokenService.getAuthorities();
      }
  }

   onLogin():void{
    this.loginUsuarioLog = new LoginUsuariolog(this.nombreUsuarioLog, this.password);
     this.authService.login(this.loginUsuarioLog).subscribe(data =>{
        this.isLogged = true;
        this.isLoginFail = false;
        this.tokenService.setToken(data.token);
        this.tokenService.setUserNameLog(data.nombreUsuarioLog);
        this.tokenService.setAuthorities(data.authorities);
        this.roles= data.authorities;
        this.router.navigate([''])
      }, err => {
        this.isLogged=false;
        this.isLoginFail=true;
        this.errMsj = err.error.mensaje;
        console.log(this.errMsj);
        
      })
    
    }

  

}
