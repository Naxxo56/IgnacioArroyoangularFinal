package com.borja.t3_elementos.utils;

public class Hamburguesa {

    private String nombre,carne;
    private int calorias,imagen;

    public Hamburguesa(String nombre, String carne, int calorias,int imagen) {
        this.nombre = nombre;
        this.carne = carne;
        this.calorias = calorias;
        this.imagen = imagen;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarne() {
        return carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Hamburguesa{" +
                "nombre='" + nombre + '\'' +
                ", carne='" + carne + '\'' +
                ", calorias=" + calorias +
                '}';
    }
}
