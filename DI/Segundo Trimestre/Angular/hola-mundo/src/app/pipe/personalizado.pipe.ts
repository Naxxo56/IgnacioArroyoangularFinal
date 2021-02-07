import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'personalizado'
})
export class PersonalizadoPipe implements PipeTransform {

  transform(value: string, ...args: unknown[]): unknown {
    return value;
  }
}
