import { DatosService } from './../../services/datos.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Asignatura } from 'src/utils/Asignatura';
import { DatosCiclosService } from 'src/app/services/datos-ciclos.service';
import { Ciclo } from 'src/utils/Ciclo';

@Component({
  selector: 'app-ciclos',
  templateUrl: './ciclos.component.html',
  styleUrls: ['./ciclos.component.css'],
})
export class CiclosComponent implements OnInit {
  elementosDam: Asignatura[] = [];
  elementosDaw: Asignatura[] = [];
  ciclosPintar: Ciclo[] = [];

  constructor(
    private gestorRutasActivas: ActivatedRoute,
    private servicioDatos: DatosService,
    private servicioCiclo: DatosCiclosService,
    private gestorRutas: Router
  ) {}

  ngOnInit(): void {
    this.elementosDam = this.servicioDatos.getAsignaturasDam();
    this.elementosDaw = this.servicioDatos.getAsignaturaDaw();
    this.ciclosPintar = this.servicioCiclo.getCiclos();
  }
  irCiclo(nombreCiclo: string, cursoCiclo: number) {
    this.gestorRutas.navigate(['cicloDetalle', nombreCiclo, cursoCiclo]);
  }
}
