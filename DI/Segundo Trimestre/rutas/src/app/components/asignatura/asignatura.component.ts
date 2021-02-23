import { Component, Input, OnInit } from '@angular/core';
import { Asignatura } from 'src/utils/Asignatura';

@Component({
  selector: 'app-asignatura',
  templateUrl: './asignatura.component.html',
  styleUrls: ['./asignatura.component.css']
})
export class AsignaturaComponent implements OnInit {

  @Input() asignatura:Asignatura;

  constructor() { }

  ngOnInit(): void {
  }

}
