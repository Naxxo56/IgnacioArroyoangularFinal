package com.nacho.ignacioarroyofinalpmdm.utils;

import java.io.Serializable;

public class Liga implements Serializable {
    String nombreLiga, id;

    public Liga(String nombreLiga, String id) {
        this.nombreLiga = nombreLiga;
        this.id = id;

    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
