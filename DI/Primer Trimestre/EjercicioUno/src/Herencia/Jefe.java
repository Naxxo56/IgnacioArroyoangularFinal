package Herencia;

public class Jefe extends Persona implements Trabajo {
    int beneficios;

    public Jefe(String nombre, String apellido, String dni, int beneficios) {
        super(nombre, apellido, dni);
        this.beneficios = beneficios;
    }

    @Override
    public void metodoGenerico() {
        System.out.printf("Este es un trabajador con estos datos %n Nombre: %s%n Apellido:%s%n Dni: %s%n Sueldo:" +
                " %d%n", getNombre(), getApellido(), getDni(),getBeneficios());
    }

    public int getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(int beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public String trabajar() {
        return "Ha trabajado muy poco";
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
        System.out.printf("Beneficios:%d%n ",getBeneficios());
    }
}
