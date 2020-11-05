package com.nacho.examenpmdm.utils;

public class Restaurante {
    String nombre, direccion, tipo;
    int telefono, valoracion;

    public Restaurante(String nombre, String direccion, int telefono,String tipo, int valoracion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.tipo = tipo;
        this.telefono = telefono;
        this.valoracion = valoracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }


}
