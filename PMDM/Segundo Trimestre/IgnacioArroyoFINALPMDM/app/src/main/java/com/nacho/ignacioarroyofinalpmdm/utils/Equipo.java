package com.nacho.ignacioarroyofinalpmdm.utils;

import java.io.Serializable;

public class Equipo implements Serializable {

    String banner, nombre, descripcion, escudo, idEquipo, tw, fb, web, insta;

    public Equipo() {

    }

    public Equipo(String banner, String nombre, String descripcion, String escudo, String idEquipo, String tw, String fb, String web, String insta) {
        this.banner = banner;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.escudo = escudo;
        this.idEquipo = idEquipo;
        this.tw = tw;
        this.fb = fb;
        this.web = web;
        this.insta = insta;
    }

    public String getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(String idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getTw() {
        return tw;
    }

    public void setTw(String tw) {
        this.tw = tw;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getInsta() {
        return insta;
    }

    public void setInsta(String insta) {
        this.insta = insta;
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEscudo() {
        return escudo;
    }

    public void setEscudo(String escudo) {
        this.escudo = escudo;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "banner='" + banner + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", escudo='" + escudo + '\'' +
                ", idEquipo='" + idEquipo + '\'' +
                ", tw='" + tw + '\'' +
                ", fb='" + fb + '\'' +
                ", web='" + web + '\'' +
                ", insta='" + insta + '\'' +
                '}';
    }
}
