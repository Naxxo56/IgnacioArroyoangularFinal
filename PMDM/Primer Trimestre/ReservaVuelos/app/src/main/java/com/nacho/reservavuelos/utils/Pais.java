package com.nacho.reservavuelos.utils;

import android.graphics.drawable.Drawable;
import android.net.Uri;

public class Pais {
    String nombre;
    int imagen;

    public Pais(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
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

    public void setImagen(int imagenURL) {
        this.imagen = imagenURL;
    }


}

