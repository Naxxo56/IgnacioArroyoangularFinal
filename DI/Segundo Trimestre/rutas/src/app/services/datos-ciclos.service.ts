import { Injectable } from '@angular/core';
import { Ciclo } from 'src/utils/Ciclo';

@Injectable({
  providedIn: 'root'
})
export class DatosCiclosService {

  ciclosArray:Ciclo[]=[
    {
    nombre: 'DAM',
    curso: 1,
    asignaturas: [],
    imagen: 'assets/images/dam.jpeg',
  },
  {
    nombre: 'DAM',
    curso: 2,
    asignaturas: [],
    imagen: 'assets/images/dam.jpeg',
  },
  {
    nombre: 'DAW',
    curso: 1,
    asignaturas: [],
    imagen: 'assets/images/daw.jpeg',
  },
  {
    nombre: 'DAW',
    curso: 2,
    asignaturas: [],
    imagen: 'assets/images/daw.jpeg',
  },
]

  constructor() { }

  getCiclos(): Ciclo[] {
    return this.ciclosArray;
  }

}
