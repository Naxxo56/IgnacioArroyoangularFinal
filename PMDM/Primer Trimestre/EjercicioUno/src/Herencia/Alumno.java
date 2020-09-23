package Herencia;

public class Alumno extends Persona {
    int notaMedia;

    public Alumno(String nombre, String apellido, String dni, int notaMedia) {
        super(nombre, apellido, dni);
        this.notaMedia = notaMedia;
    }

    @Override
    public void metodoGenerico() {
        System.out.printf("Este es un alumno con estos datos %n Nombre: %s%n Apellido:" +
                "%s%n Dni: %s%n Nota media:%d", getNombre(), getApellido(), getDni(), getNotaMedia());
    }

    public double getNotaMedia() {
        return notaMedia;
    }


    public void setNotaMedia(int notaMedia) {
        this.notaMedia = notaMedia;
    }
}
