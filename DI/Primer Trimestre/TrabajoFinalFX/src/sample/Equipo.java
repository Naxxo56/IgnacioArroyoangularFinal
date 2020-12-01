package sample;

public class Equipo {
    String nombre, anio,escudo,descripcion;

    public Equipo(String nombre, String anio, String escudo,String descripcion) {
        this.nombre = nombre;
        this.anio = anio;
        this.escudo = escudo;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", anio='" + anio + '\'' +
                '}';
    }
}
