//comentario normal
/*
    comentario bloque
*/

console.log("Esto es un ejemplo de llamada js externa");   

const variableConstanteNumero = 2;
const variableConstanteLetra = "Letra";
const variableConstanteFloat = 5.6;
const variableConstanteBoolean = false;
const variableConstanteUndefined = undefined;
const variableConstanteArray = [];

console.log("La constante numero es:" + variableConstanteNumero);

//solo funciona con comilla tumbada lo del $ para concatenar sin el +.
console.log(`La constante letra es: ${variableConstanteLetra}`);

// tipos number:entero decimal,boolean,string,undefined,NaN.
console.log("El tipo de la constante float es:" + typeof variableConstanteFloat);
console.log("El tipo de la constante boolean es:" + typeof variableConstanteBoolean);
console.log("El tipo de la constante letra es:" + typeof variableConstanteLetra);
console.log("El tipo de la constante undefined es:" + typeof variableConstanteUndefined);
console.log("El tipo de la constante numero es:" + typeof variableConstanteNumero);
//console.log(`El tipo de la constante numero es: ${typeof variableConstanteNumero}`);

//ambito de clase y es mas segura.
let variableNumero = 3;
let variableNumeroDos = 3;
//variable statica que puede ser accedida por cualquier sitio, desde la consola se puede modificar esa variable.
var variableVarNumero = 6;
var variableVarNumeroDos = 6;





