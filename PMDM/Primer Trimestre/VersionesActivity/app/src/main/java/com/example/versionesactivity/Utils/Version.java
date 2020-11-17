package com.example.versionesactivity.Utils;

import java.io.Serializable;

public class Version implements Serializable {
    private String nombre, fechaVersion, numeroVersion, descripcion;
    private int logo;

    public Version(String nombre, String fechaVersion, String numeroVersion, String descripcion, int logo) {
        this.nombre = nombre;
        this.fechaVersion = fechaVersion;
        this.numeroVersion = numeroVersion;
        this.descripcion = descripcion;
        this.logo = logo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaVersion() {
        return fechaVersion;
    }

    public String getNumeroVersion() {
        return numeroVersion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getLogo() {
        return logo;
    }
}
