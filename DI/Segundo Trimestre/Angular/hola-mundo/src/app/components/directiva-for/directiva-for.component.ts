import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-directiva-for',
  templateUrl: './directiva-for.component.html',
  styleUrls: ['./directiva-for.component.css']
})
export class DirectivaForComponent implements OnInit {

  tecnologias:string []=["Java","MySql","JavaScript","Python","HTML","PowerShell","XML"];

  constructor() { }

  ngOnInit(): void {
  }

}
