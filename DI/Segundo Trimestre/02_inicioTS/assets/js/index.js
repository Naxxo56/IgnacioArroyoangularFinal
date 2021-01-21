//tipado de variables
var nombre = "Nacho";
var numero = 1;
var acierto = false;
var arrayDatos = ["asd"];
var arrayCosas = ["asd", false, 3, "da"];
var arraynumeros = [1, 2, 3, 4];
var variableFuncion = function () {
    console.log("Funcion ejecutada");
};
function funcionParametros(nombre, edad) {
    console.log(nombre + "," + edad);
}
function funcionRetorno(opUno, opDos, operacion) {
    var resultado = 0;
    switch (operacion) {
        case "suma":
            resultado = opUno + opDos;
            break;
        case "resta":
            resultado = opUno - opDos;
            break;
        case "multi":
            resultado = opUno * opDos;
            break;
        case "div":
            resultado = opUno / opDos;
            break;
    }
    return resultado;
}
/*
console.log(`${nombre},${numero}`);
variableFuncion();
funcionParametros("Nacho", 20);
console.log(funcionRetorno(4, 3, "suma"));
*/
function funcionParametrosMultiples(parametroObligatorio, parametroObligatorioDos) {
    /*
    if (parametroMulti.length>0) {
        console.log("Los parametros multiples son:")
        parametroMulti.forEach(element => {
            console.log(element);
        });
    } else {
        console.log("No hay parametros multiples");
    }
    */
    var parametroMulti = [];
    for (var _i = 2; _i < arguments.length; _i++) {
        parametroMulti[_i - 2] = arguments[_i];
    }
    parametroMulti.length > 0 ? parametroMulti.forEach(function (element) {
        console.log("Los parametros multiples son :" + element);
    }) : console.log("No hay parametros multiples");
}
function funcionOptativos(nombre, edad, altura) {
    //altura!=undefined
    if (altura) {
        console.log("Tu nombre es:" + nombre + ",tu edad es:" + edad + " a\u00F1os y tu altura es:" + altura);
    }
    else {
        console.log("Tu nombre es:" + nombre + " y tu edad es:" + edad + " a\u00F1os");
    }
}
function funcionParametrosDefecto(nombre, apellido, edad) {
    if (edad === void 0) { edad = 18; }
    console.log("Tu nombre es:" + nombre + ",tu apellido es:" + apellido + " y tu edad es:" + edad);
}
var alumnoUno = { nombre: "Nacho", apellido: "Arroyo", edad: 20, hobbies: [], mostrarDatos: function () { } };
