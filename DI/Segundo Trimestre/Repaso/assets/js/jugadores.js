let jugadoresMadrid = [];
let jugadoresBarsa = [];
let jugadoresAtleti = [];

let barsa = {
    nombre: "Barsa", posicion: 1, plantilla: jugadoresBarsa,
};

let madrid = {
    nombre: "Madrid", posicion: 2, plantilla: jugadoresMadrid,
};

let atleti = {
    nombre: "Atleti", posicion: 3, plantilla: jugadoresAtleti,
};

function addJugador(nombreJ, posicionJ, valorJ, equipoJ) {
    let jugador = {
        nombre: nombreJ, posicion: posicionJ, valor: valorJ
    };
    if (equipoJ == "Barsa") {
        jugadoresBarsa.push(jugador);
    } else if (equipoJ == "Madrid") {
        jugadoresAtleti.push(jugador);
    } else if (equipoJ == "Atleti") {
        jugadoresMadrid.push(jugador);
    } else {
        console.log("No existe este equipo");
    }
};
addJugador("Messi", "Delantero", 0, "Barsa");

/*
jugadoresBarsa.forEach(element => {
    console.log(element);
});
*/

//todo lo que tenga propiedades es un objeto.
let metodos = {

    listarPlantilla: (equipo) => {
        //console.log(`El nombre del equipo es:${equipo.nombre}`);
        //console.log(`La posicion del equipo es:${equipo.posicion}`);
        console.log(`El equipo es:${equipo.nombre} y su posicion ${equipo.posicion}`);
    },
    listarEquipo: (equipo) => {
        if(equipo.plantilla.length == 0){
            console.log(`No hay jugadores en la plantilla del ${equipo.nombre}` );
        }else{
            equipo.plantilla.forEach(element => {
                console.log(`Nombre:${element.nombre} Posicion:${element.posicion} Valor:${element.valor}`);   
            });
        }
    },
};

metodos.listarEquipo(barsa);
metodos.listarPlantilla(barsa);
metodos.listarEquipo(madrid);
metodos.listarPlantilla(madrid);
metodos.listarEquipo(atleti);
metodos.listarPlantilla(atleti);