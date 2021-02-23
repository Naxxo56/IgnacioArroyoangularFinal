
export interface Asignatura {
  nombre:string;
  profesor: string;
  conocimientos:Conocimiento[];
  ciclo:string;
  curso: number;
}
 interface Conocimiento{
   nombre:string;
   imagen:string;
 }
