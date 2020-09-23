package utils;

public class Persona {

    String nombre, dni;
    int edad, telefono, pasos;

    // constructores se llaman igual que la clase,y no retorna nada
    public Persona() {

    }

    public Persona(String nombre, String dni, int edad, int telefono) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.telefono = telefono;
        this.pasos = 1;
    }

    public void correr(double velocidad) {
        this.pasos = (int)(this.pasos * velocidad);
    }

    public String andar(double velocidad) {
        this.pasos = (int)(this.pasos + velocidad/2);
        return String.format("Has recorrido %d pasos %n",getPasos());
    }


    //Si lo comento tambien se puede acceder a él porque es un método ya incorporado

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", edad=" + edad +
                ", telefono=" + telefono +
                ", pasos=" + pasos +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getPasos() {
        return pasos;
    }

    public void setPasos(int pasos) {
        this.pasos = pasos;
    }
}
