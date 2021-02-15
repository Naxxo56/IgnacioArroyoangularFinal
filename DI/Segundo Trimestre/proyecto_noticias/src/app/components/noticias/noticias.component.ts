import { Component, OnInit } from '@angular/core';
import { Noticia } from 'src/app/utils/Noticia';
import { NoticiasService } from '../services/noticias.service';

@Component({
  selector: 'app-noticias',
  templateUrl: './noticias.component.html',
  styleUrls: ['./noticias.component.css']
})
export class NoticiasComponent implements OnInit {

  mostrar: boolean = true;
  noticias: Noticia[];
  noticiasDetalle:Noticia;


  constructor(private servicioNoticias: NoticiasService) {
  }

  ngOnInit(): void {
    this.noticias = this.servicioNoticias.getAllNoticias();
  }

  mostrarNoticias(categoria: string) {
      if (categoria=='todas') {
        this.noticias=this.servicioNoticias.getAllNoticias();
      }
      this.noticias=this.servicioNoticias.getNoticiasFiltradas(categoria);
  }

  mostrarDetalle(item:Noticia){
    this.mostrar =true
    this.noticiasDetalle = item;
  }

}
