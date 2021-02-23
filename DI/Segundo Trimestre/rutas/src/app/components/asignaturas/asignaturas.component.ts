import { Component, OnInit } from '@angular/core';
import { DatosService } from 'src/app/services/datos.service';
import { Asignatura } from 'src/utils/Asignatura';

@Component({
  selector: 'app-asignaturas',
  templateUrl: './asignaturas.component.html',
  styleUrls: ['./asignaturas.component.css'],
})
export class AsignaturasComponent implements OnInit {
  
  asignaturasPintar: Asignatura[];
  asignaturasBusqueda:Asignatura[]=[];
  numero:number= 1;

  constructor(private servicio: DatosService) {}

  ngOnInit(): void {
    this.asignaturasPintar = this.servicio.getAsignaturas();
  }

  buscarAsignatura(nombre:string,ciclo:string){
    this.asignaturasBusqueda=[];
    this.asignaturasPintar.forEach((asig)=>{
      if (asig.nombre.toLowerCase().includes(nombre.toLowerCase()) || asig.ciclo.toLowerCase().includes(ciclo.toLowerCase())) {
        this.asignaturasPintar.push(asig);    
      }
    })
  }
}
