import { Component, OnInit } from '@angular/core';
import { TecnologiaService } from 'src/app/services/tecnologia.service';
import { Tecnologia } from 'src/app/utils/Tecnologia';
import { TecnologiaInterfaz } from '../../utils/TecnologiaInterfaz'


@Component({
  selector: 'app-materia',
  templateUrl: './materia.component.html',
  styleUrls: ['./materia.component.css']
})
export class MateriaComponent implements OnInit {


  /*
    angular: TecnologiaInterfaz = {
      nombre: "Angular 11.0",
      descripcion: "Framework JS para la creación de aplicaciones de tipo SPA",
      imagen: "assets/images/angular.png",
    };
  
    java: TecnologiaInterfaz = {
      nombre: "Java",
      descripcion: "Lenguaje de programacion multiplataforma",
      imagen: "assets/images/java.png",
    };
  
    js: TecnologiaInterfaz = {
      nombre: "Js",
      descripcion: "Lenguaje de programacion web interpretado por el navegador",
      imagen: "assets/images/js.jpg",
    };
  
    pw: TecnologiaInterfaz = {
      nombre: "PowerShell",
      descripcion: "Lenguaje de programacion orientado a seguridad y automatizacion",
      imagen: "assets/images/powershell.png",
    };
  
    python: TecnologiaInterfaz = {
      nombre: 'Python',
      descripcion: 'Lenguaje de multiplataforma destinado al lado del servidor',
      imagen: 'assets/images/python.jpg',
    };
    mysql: TecnologiaInterfaz = {
      nombre: 'MySQL',
      descripcion: 'Lenguaje de creación y gestión de base de datos',
      imagen: 'assets/images/mysql.jpg',
    };
    xml: TecnologiaInterfaz = {
      nombre: 'XML',
      descripcion: 'Lenguaje de marcado para el intercambio de datos',
      imagen: 'assets/images/xml.jpg',
    };
    html: TecnologiaInterfaz = {
      nombre: 'HTML',
      descripcion: 'Lenguaje de marcado destinado a la creción de webs estáticas',
      imagen: 'assets/images/html.jpeg',
    };
    tecnologiaInterfazArray: TecnologiaInterfaz[] = [this.angular, this.java, this.js, this.mysql, this.pw, this.python, this.html, this.xml];
  */
  tecnologiaArray: Tecnologia[] = [];
  tecnologiasArrayBusqueda: Tecnologia[] = [];

  constructor(private servicioTecnologia: TecnologiaService) {

  }

  ngOnInit(): void {
    this.tecnologiaArray = this.servicioTecnologia.getAllTecnologias;
  }

  buscarTecnologia(nombre: string) {
    this.tecnologiasArrayBusqueda = [];
    this.tecnologiaArray.forEach((tec) => {
      if (tec.nombre.toLowerCase().includes(nombre.toLowerCase())) {
        this.tecnologiasArrayBusqueda.push(tec);
        console.log(tec);
      }
    });
  }

}
