let cristiano = new Jugador("Cristiano", "Garcia", "Delantero"); 
let messi = new Jugador("Messi", "Soled", "Delantero");
let suarez = new Jugador("Luis", "Suarez", "Defensa");

function mostrarJugadores(j1, j2, j3) {
    j1.mostrarDatos();
    j2.mostrarDatos();
    j3.mostrarDatos();
}
mostrarJugadores(cristiano, messi, suarez);