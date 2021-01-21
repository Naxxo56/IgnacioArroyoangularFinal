/*
let objetoInicial = {

    propiedadUno: "valor",
    propiedadDos: 1,
    propiedadTres: false,
    propiedadCuatro: ["hola", "que", "tal", "estas"],
    propiedadCinco: { p1: "hola", p2: false, p3: 45 },

};
*/

class Jugador {

    nombre;
    apellido;
    posicion;

    constructor(nombre, apellido, posicion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
    }

    mostrarDatos() {
        console.log(`
        Nombre: ${this.nombre}
        Apellido: ${this.apellido}
        Posicion: ${this.posicion}
        `);
    }

    setPosicion(posicion) {
        this.posicion = posicion;
    }

    get getPosicion() {
        return this.posicion;
    }
}
let jugadorUno = new Jugador("Nacho", "Arroyo", "Portero");
//jugadorUno.posicion = "Delantero"

//set setPosicion(posicion)etc
//jugadorUno.setPosicion= "Delantero";

jugadorUno.setPosicion("Delantero");
jugadorUno.mostrarDatos();
console.log(`La posicion del jugador es ${jugadorUno.getPosicion}`);

