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
/*
let variableNumero = 3;
let variableNumeroDos = 3;
*/
//variable statica que puede ser accedida por cualquier sitio, desde la consola se puede modificar esa variable.
/*
var variableVarNumero = 6;
var variableVarNumeroDos = 6;
*/

//IF
let numero = 7;
// == valora el numero , === valora el tipo
if (numero == 7 ) {
    console.log("El numero es igual a 7");
} else {
    console.log("El numero es distinto a 7");
}

let numeroD = "7";
if (numeroD === 7 ) {
    console.log("El numero es igual a 7");
} else {
    console.log("El numero es distinto a 7");
}

//SWITCH
let opcion = 2;
switch (opcion) {
    case 1:
        console.log("Opcion 1 seleccionada");
        break;
        case 2:
            console.log("Opcion 2 seleccionada");
            break;
            case 3:
                console.log("Opcion 3 seleccionada");
                break;

    default:
        console.log("Caso no contemplado");
        break;
}

//FOR
let coleccion = ["hola","que","tal","estas","muy","bien"];
for (const iterator of coleccion) {
    console.log(iterator);
}
for (const key in coleccion) {
    console.log(key,coleccion[key]);
}
/*

for (let index = 0; index < 10; index++) {
    console.log(`Opcion ${index}`);
}



for (let index = 0; index < coleccion.length; index++) {
    console.log(coleccion[index]);
    //alert(coleccion[index]);
}

coleccion.forEach(item => {
    console.log(item);
});

console.log("FOR IN");

for (const key in coleccion) {
    console.log(coleccion[key]);
}

console.log("FOR OF");

for (const iterator of coleccion) {
    console.log(iterator);
}



*/



//añade un nuevo elemento al array
console.log(`La longitud del array antes de añadir es ${coleccion.length}`);
coleccion.push("as","vfferg","rimg","vmrtkoph");

coleccion.forEach(item => {
    console.log(item);
});

console.log(`La longitud del array despues de añadir es ${coleccion.length}`);

//sacar las palabras que tienen 5 o mas letras
//las llaves en funcion de flecha son obligatorias si son mas de 1 linea de codigo
console.log("Palabras mas de 4 letras");
coleccion.forEach(item => {
    if(item.length > 4){
        console.log(item);
    }
});

//elimina el primer elemento de la lista
console.log("Eliminando la primera posicion del array");
coleccion.shift();

coleccion.forEach(item => {
    console.log(item);
});

//elimina la ultima posicion del array
console.log("Eliminando la ultima posicion del array");
coleccion.pop();

coleccion.forEach(item => {
    console.log(item);
});

//añade un elemento en la primera posicion
console.log("Añadiendo algo en primera posicion");
coleccion.unshift("Estoy en primera posicion");

coleccion.forEach(item => {
    console.log(item);
});






