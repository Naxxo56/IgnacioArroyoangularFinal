let objetoInicial = {

    propiedadUno: "valor",
    propiedadDos: 1,
    propiedadTres: false,
    propiedadCuatro: ["hola", "que", "tal", "estas"],
    propiedadCinco: { p1: "hola", p2: false, p3: 45 },

};

console.log(`La propiedad 1 es ${objetoInicial.propiedadUno}`);
console.log(`La propiedad 2 es ${objetoInicial.propiedadDos}`);
console.log(`La propiedad 3 es ${objetoInicial.propiedadTres}`);
//console.log(`La propiedad 4 es ${objetoInicial.propiedadCuatro}`);
objetoInicial.propiedadCuatro.forEach((element, index) => {
    console.log(`La propiedad del array es ${index + 1} es ${element}`);
});
console.log(`El valor 1 de la propiedad 5 es ${objetoInicial.propiedadCinco.p1}`);
console.log(`El valor 2 de la propiedad 5 es ${objetoInicial.propiedadCinco.p2}`);
console.log(`El valor 3 de la  propiedad 5 es ${objetoInicial.propiedadCinco.p3}`);

objetoInicial.propiedadUno = "Nueva propiedad";
console.log(`La propiedad modificada es ${objetoInicial.propiedadUno}`);

let calculadora = {
    /*
    sumar: function (p1, p2) {
        console.log(`La suma de los parametros es ${p1 + p2}`);
    },
    */
    sumarFlecha: (p1, p2) => {
        console.log(`La suma de los parametros es ${p1 + p2}`);
    },
    restarFlecha: (p1, p2) => {
        console.log(`La resta de los parametros es ${p1 - p2}`);
    },
    multiplicarFlecha: (p1, p2) => {
        console.log(`La multiplicacion de los parametros es ${p1 * p2}`);
    },
    dividirFlecha: (p1, p2) => {
        console.log(`La division de los parametros es ${p1 / p2}`);
    },
};

/*
calculadora.sumar(1,3);
calculadora.sumarFlecha(1, 4);
calculadora.restarFlecha(4, 2);
calculadora.multiplicarFlecha(1, 2);
calculadora.dividirFlecha(4, 2);
*/

function operar(num1,num2,operacion) {
    operacion(num1,num2);
}
operar(1,2,calculadora.sumarFlecha);