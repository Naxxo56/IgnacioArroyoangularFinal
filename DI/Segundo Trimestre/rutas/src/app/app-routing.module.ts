import { AsignaturasComponent } from './components/asignaturas/asignaturas.component';
import { CiclosComponent } from './components/ciclos/ciclos.component';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CicloDetalleComponent } from './components/ciclo-detalle/ciclo-detalle.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'ciclos', component: CiclosComponent },
  { path: 'ciclos/:id', component: CiclosComponent },
  { path: 'asignaturas', component: AsignaturasComponent },
  { path: 'cicloDetalle', component: CicloDetalleComponent },
  { path: 'cicloDetalle/:ciclo/:curso', component: CicloDetalleComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
