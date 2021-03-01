import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HomeComponent } from './components/home/home.component';
import { CiclosComponent } from './components/ciclos/ciclos.component';
import { AsignaturaComponent } from './components/asignatura/asignatura.component';
import { AsignaturasComponent } from './components/asignaturas/asignaturas.component';
import { CicloDetalleComponent } from './components/ciclo-detalle/ciclo-detalle.component';
import { ImagenesPipe } from './pipes/imagenes.pipe';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    HomeComponent,
    CiclosComponent,
    AsignaturaComponent,
    AsignaturasComponent,
    CicloDetalleComponent,
    ImagenesPipe,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
