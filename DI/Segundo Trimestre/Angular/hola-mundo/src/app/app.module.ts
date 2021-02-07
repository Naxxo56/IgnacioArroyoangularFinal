import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ColumnaUnoComponent } from './components/columna-uno/columna-uno.component';
import { ColumnaDosComponent } from './components/columna-dos/columna-dos.component';
import { ColumnaTresComponent } from './components/columna-tres/columna-tres.component';
import {BarraNavegacionComponent} from './components/barra-navegacion/barra-navegacion.component';
import { MateriaComponent } from './components/materia/materia.component';
import { DirectivaIfComponent } from './components/directiva-if/directiva-if.component';
import { DirectivaSwitchComponent } from './components/directiva-switch/directiva-switch.component';
import { DirectivaForComponent } from './components/directiva-for/directiva-for.component';
import { TecnologiaService } from './services/tecnologia.service';
import { PersonalizadoPipe } from './pipe/personalizado.pipe';
import { ImagenPipe } from './pipe/imagen.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ColumnaUnoComponent,
    ColumnaDosComponent,
    ColumnaTresComponent,
    BarraNavegacionComponent,
    MateriaComponent,
    DirectivaIfComponent,
    DirectivaSwitchComponent,
    DirectivaForComponent,
    PersonalizadoPipe,
    ImagenPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [TecnologiaService],
  bootstrap: [AppComponent]
})
export class AppModule { }
