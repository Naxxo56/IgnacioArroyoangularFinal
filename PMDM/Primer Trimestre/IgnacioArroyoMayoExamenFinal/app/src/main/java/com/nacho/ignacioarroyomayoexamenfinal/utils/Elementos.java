package com.nacho.ignacioarroyomayoexamenfinal.utils;

public class Elementos {
    String nombre,equipo;
    int imagen;

    public Elementos(String nombre, String equipo, int imagen) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }
}
