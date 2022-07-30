import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EditusuarioComponent } from './components/acerca-de/editusuario.component';
import { EditEducacionComponent } from './components/educacion/edit-educacion.component';
import { NewEducacionComponent } from './components/educacion/new-educacion.component';
import { EditExperienciaComponent } from './components/experiencia/edit-experiencia.component';
import { ExperienciaComponent } from './components/experiencia/experiencia.component';
import { NewExperienciaComponent } from './components/experiencia/new-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditProyectoComponent } from './components/proyecto/edit-proyecto.component';
import { NewproyectoComponent } from './components/proyecto/newproyecto.component';
import { EditskillComponent } from './components/skills/editskill.component';
import { NewskillComponent } from './components/skills/newskill.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'nuevaexp', component: NewExperienciaComponent },
  { path: 'editexp/:id', component: EditExperienciaComponent },
  { path: 'nuevaedu', component: NewEducacionComponent },
  { path: 'editedu/:id', component: EditEducacionComponent },
  { path: 'nuevoproyecto', component: NewproyectoComponent },
  { path: 'editpro/:id', component: EditProyectoComponent },
  { path: 'nuevaskill', component: NewskillComponent },
  { path: 'editskill/:id', component: EditskillComponent },
  { path: 'editusuario/:id', component: EditusuarioComponent }
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
