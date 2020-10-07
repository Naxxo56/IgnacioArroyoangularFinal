package com.nacho.tema_02_intents.utils;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre, apellido;
    private int edad;
    private boolean experiencia;

    public Persona(String nombre, String apellido, int edad, boolean experiencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.experiencia = experiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isExperiencia() {
        return experiencia;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }
}
