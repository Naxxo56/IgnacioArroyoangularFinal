import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva-if',
  templateUrl: './directiva-if.component.html',
  styleUrls: ['./directiva-if.component.css']
})
export class DirectivaIfComponent implements OnInit {

  jugadorUno = { nombre: "", puntuacion: 0 };
  jugadorDos = { nombre: "", puntuacion: 0 };
  mostrarJugadores: boolean = false;
  mostrar: boolean = false;
  constructor() { }

  ngOnInit(): void {
  }

  cambiarMostrar() {
    this.mostrar = !this.mostrar;
  }

  empezarJuego(nombreUno: string, nombreDos: string) {
    this.jugadorUno.nombre = nombreUno;
    this.jugadorDos.nombre = nombreDos;
    if (this.jugadorUno.nombre.length > 0) {
      this.mostrarJugadores = true;
    }

  }
  jugarRonda() {
    let aleatorioUno = Math.random() * 20;
    let aleatorioDos = Math.random() * 20;
    if (aleatorioUno > aleatorioDos) {
      this.jugadorUno.puntuacion++;
    } else if (aleatorioDos > aleatorioUno) {
      this.jugadorDos.puntuacion++;
    } else {
      this.jugadorUno.puntuacion++;
      this.jugadorDos.puntuacion++;
    }


  }

}
