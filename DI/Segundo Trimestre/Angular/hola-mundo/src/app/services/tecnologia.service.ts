import { Injectable } from '@angular/core';
import { Tecnologia } from '../utils/Tecnologia';

@Injectable({
  providedIn: 'root'
})
export class TecnologiaService {

  tecnologias: Tecnologia[] = [new Tecnologia("Angular", "Framework JS para la creación de aplicaciones de tipo SPA", "assets/images/angular.png"),
  new Tecnologia("Java", "Lenguaje de programacion multiplataforma", "assets/images/java.png"),
  new Tecnologia("Js", "Lenguaje de programacion web interpretado por el navegador", "assets/images/js.jpg"),
  new Tecnologia("PowerShell", "Lenguaje de programacion orientado a seguridad y automatizacion", "assets/images/powershell.png"),
  new Tecnologia("Python", "Lenguaje de multiplataforma destinado al lado del servidor", "assets/images/python.jpg"),
  new Tecnologia("MySql", "Lenguaje de creación y gestión de base de datos", "assets/images/mysql.jpg"),
  new Tecnologia("Xml", "Lenguaje de marcado para el intercambio de datos", "assets/images/xml.jpg"),
  new Tecnologia("HTML", "Lenguaje de marcado destinado a la creción de webs estáticas", "assets/images/html.jpeg"),
  new Tecnologia("Tecnodefault", "Descripcion de tecnologia default","")];



  constructor() { }

  get getAllTecnologias() : Tecnologia[] {
    return this.tecnologias;
  }

  get getTecnologiasNombre():Tecnologia[]{
    return  [];
  }
}
