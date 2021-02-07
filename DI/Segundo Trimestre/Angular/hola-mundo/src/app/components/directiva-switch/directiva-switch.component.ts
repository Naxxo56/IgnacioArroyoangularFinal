import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva-switch',
  templateUrl: './directiva-switch.component.html',
  styleUrls: ['./directiva-switch.component.css']
})
export class DirectivaSwitchComponent implements OnInit {

  valorInput: number = 2;
  constructor() { }

  ngOnInit(): void {

    
    
  }
  
  cambiarValorInput(valor: any) {
    this.valorInput = valor;
  }

}
