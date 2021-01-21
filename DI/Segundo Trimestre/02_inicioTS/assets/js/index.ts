//tipado de variables
let nombre: string = "Nacho";
let numero: number = 1;
let acierto: boolean = false;
let arrayDatos: string[] = ["asd"];
let arrayCosas: any[] = ["asd", false, 3, "da"];
let arraynumeros: number[] = [1, 2, 3, 4];

let variableFuncion = () => {
    console.log("Funcion ejecutada");

}

function funcionParametros(nombre: string, edad: number) {
    console.log(`${nombre},${edad}`);

}

function funcionRetorno(opUno: number, opDos: number, operacion: string): number {
    let resultado: number = 0;
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

function funcionParametrosMultiples(parametroObligatorio: boolean, parametroObligatorioDos: boolean, ...parametroMulti: string[]) {

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


    parametroMulti.length > 0 ? parametroMulti.forEach(element => {
        console.log("Los parametros multiples son :" + element);
    }) : console.log("No hay parametros multiples");

}

function funcionOptativos(nombre: string, edad: number, altura?: number) {
    //altura!=undefined
    if (altura) {
        console.log(`Tu nombre es:${nombre},tu edad es:${edad} años y tu altura es:${altura}`);
    } else {
        console.log(`Tu nombre es:${nombre} y tu edad es:${edad} años`);
    }
}

function funcionParametrosDefecto(nombre: string, apellido: string, edad: number = 18) {
    console.log(`Tu nombre es:${nombre},tu apellido es:${apellido} y tu edad es:${edad}`);
}

/*
funcionParametrosMultiples(true,false,"hola","adios","ad","sgf","sh");
funcionParametrosMultiples(false,true);
funcionOptativos("Nachito",20,1.78);
funcionOptativos("Nachito",20);
funcionParametrosDefecto("Nacho","Arroyo");
funcionParametrosDefecto("Nacho","Arroyo",20);
*/

interface alumno {
    nombre: string;
    apellido: string;
    edad: number;
    hobbies: [];
    mostrarDatos();
}

let alumnoUno = { nombre: "Nacho", apellido: "Arroyo", edad: 20, hobbies: [], mostrarDatos: () => { }, }
