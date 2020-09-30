package Herencia;

public class Entrada {
    public static void main(String[] args) {
        Trabajador trabajador = new Trabajador("Nacho", "Arroyo", "53719219m", 2300, 8);
        //trabajador.metodoGenerico();
        Alumno alumno = new Alumno("Ernesto", "Gaspar", "81254f", 9);
        //alumno.metodoGenerico();
        Jefe jefe = new Jefe("Ernesto", "Gaspar", "81254f", 9);
        //jefe.metodoGenerico();


        Persona [] registro = new Persona[3];
        registro [0]=trabajador;
        registro[1] = alumno;
        registro[2] = jefe;

        Trabajo [] empresa = new Trabajo[2];
        empresa[0] = trabajador;
        empresa[1]= jefe;

        for (Persona persona: registro) {
            persona.mostrarDatos();
        }

        for (Trabajo trabajo:empresa) {
            trabajo.trabajar();
        }
    }


}
