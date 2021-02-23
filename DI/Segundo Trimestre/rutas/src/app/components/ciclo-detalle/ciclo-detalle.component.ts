import { stringify } from '@angular/compiler/src/util';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DatosCiclosService } from 'src/app/services/datos-ciclos.service';
import { DatosService } from 'src/app/services/datos.service';
import { Asignatura } from 'src/utils/Asignatura';
import { Ciclo } from 'src/utils/Ciclo';

@Component({
  selector: 'app-ciclo-detalle',
  templateUrl: './ciclo-detalle.component.html',
  styleUrls: ['./ciclo-detalle.component.css'],
})
export class CicloDetalleComponent implements OnInit {
  conocimiento: Asignatura[] = [];
  conofiltrado: Asignatura[] = [];

  constructor(
    private gestorRutasActivas: ActivatedRoute,
    private datosAsignatura: DatosService,
    private datosCiclos: DatosCiclosService
  ) {}
  cicloo: string;
  cursoo: number;
  imagen: string;

  ngOnInit(): void {
    this.gestorRutasActivas.paramMap.subscribe((param) => {
      this.cicloo = param.get('ciclo');
      this.cursoo = parseInt(param.get('curso'));

      if (this.cicloo == 'DAM' && this.cursoo == 1) {
        this.conocimiento = this.datosAsignatura.getAsignaturasDam();
        this.imagen = 'assets/images/dam.jpeg';
        for (let index = 0; index < this.conocimiento.length; index++) {
          const element = this.conocimiento[index];
          if (element.ciclo == 'DAM | DAW' && element.curso == 1) {
            this.conofiltrado.push(element);
          }
        }
      } else if (this.cicloo == 'DAM' && this.cursoo == 2) {
        this.conocimiento = this.datosAsignatura.getAsignaturasDam();
        this.imagen = 'assets/images/dam.jpeg';
        for (let index = 0; index < this.conocimiento.length; index++) {
          const element = this.conocimiento[index];
          if (
            element.ciclo == 'DAM' ||
            (element.ciclo == 'DAM | DAW' && element.curso == 2)
          ) {
            this.conofiltrado.push(element);
          }
        }
      } else if (this.cicloo == 'DAW' && this.cursoo == 1) {
        this.conocimiento = this.datosAsignatura.getAsignaturaDaw();
        this.imagen = 'assets/images/daw.jpeg';
        for (let index = 0; index < this.conocimiento.length; index++) {
          const element = this.conocimiento[index];
          if (element.ciclo == 'DAM | DAW' && element.curso == 1) {
            this.conofiltrado.push(element);
          }
        }
      } else if (this.cicloo == 'DAW' && this.cursoo == 2) {
        this.conocimiento = this.datosAsignatura.getAsignaturaDaw();
        this.imagen = 'assets/images/daw.jpeg';
        for (let index = 0; index < this.conocimiento.length; index++) {
          const element = this.conocimiento[index];
          if (element.ciclo == 'DAW' && element.curso == 2) {
            this.conofiltrado.push(element);
          }
        }
      }
    });
  }
}
