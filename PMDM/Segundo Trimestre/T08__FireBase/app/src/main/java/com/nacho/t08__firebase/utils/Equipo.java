package com.nacho.t08__firebase.utils;

public class Equipo {

    String nombre, liga;

    public Equipo(String nombre, String liga) {
        this.nombre = nombre;
        this.liga = liga;
    }

    public Equipo(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLiga() {
        return liga;
    }

    public void setLiga(String liga) {
        this.liga = liga;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "nombre='" + nombre + '\'' +
                ", liga='" + liga + '\'' +
                '}';
    }
}
