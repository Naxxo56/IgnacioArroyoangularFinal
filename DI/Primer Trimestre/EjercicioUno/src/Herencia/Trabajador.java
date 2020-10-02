package Herencia;

public class Trabajador extends Persona implements Trabajo {

    int sueldo, horasContrato;

    public Trabajador(String nombre, String apellido, String dni, int sueldo, int horasContrato) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
        this.horasContrato = horasContrato;
    }

    @Override
    public void metodoGenerico() {
        System.out.printf("Este es un trabajador con estos datos %n Nombre: %s%n Apellido:%s%n Dni: %s%n Sueldo:" +
                " %d%n Horas de contrato: %d%n", getNombre(), getApellido(), getDni(), getSueldo(), getHorasContrato());
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getHorasContrato() {
        return horasContrato;
    }

    public void setHorasContrato(int horasContrato) {
        this.horasContrato = horasContrato;
    }

    @Override
    public String trabajar() {
        return "Ha trabajado mucho";
    }

    @Override
    public void descansar() {

    }

    @Override
    public void votar(int voto) {

    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.printf("Sueldo: %d%n Horas de contrato:%d%n",getSueldo(),getHorasContrato());
    }
}
