package com.example.fragmentscorreo.utils;

import java.io.Serializable;

public class Tecnologias implements Serializable {

    private String nombre, caracteristicas;
    private int imagen;

    public Tecnologias(String nombre, int imagen, String caracteristicas) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.caracteristicas = caracteristicas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    @Override
    public String toString() {
        return "Tecnologias{" +
                "nombre='" + nombre + '\'' +
                ", caracteristicas='" + caracteristicas + '\'' +
                ", imagen=" + imagen +
                '}';
    }
}
