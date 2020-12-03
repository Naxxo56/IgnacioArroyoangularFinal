package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pedido {
    int numEnvio;
    String nombre, localidad, producto;
    SimpleStringProperty nombrePropiedad, localidadPropiedad, productoPropiedad;
    SimpleIntegerProperty numEnvioPropiedad;

    public Pedido(int numEnvio, String nombre, String localidad, String producto) {
        this.numEnvio = numEnvio;
        this.nombre = nombre;
        this.localidad = localidad;
        this.producto = producto;
        numEnvioPropiedad = new SimpleIntegerProperty(numEnvio);
        nombrePropiedad = new SimpleStringProperty(nombre);
        localidadPropiedad = new SimpleStringProperty(localidad);
        productoPropiedad = new SimpleStringProperty(producto);

    }

    public int getNumEnvio() {
        return numEnvio;
    }

    public void setNumEnvio(int numEnvio) {
        this.numEnvio = numEnvio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNombrePropiedad() {
        return nombrePropiedad.get();
    }

    public SimpleStringProperty nombrePropiedadProperty() {
        return nombrePropiedad;
    }

    public void setNombrePropiedad(String nombrePropiedad) {
        this.nombrePropiedad.set(nombrePropiedad);
    }

    public String getLocalidadPropiedad() {
        return localidadPropiedad.get();
    }

    public SimpleStringProperty localidadPropiedadProperty() {
        return localidadPropiedad;
    }

    public void setLocalidadPropiedad(String localidadPropiedad) {
        this.localidadPropiedad.set(localidadPropiedad);
    }

    public String getProductoPropiedad() {
        return productoPropiedad.get();
    }

    public SimpleStringProperty productoPropiedadProperty() {
        return productoPropiedad;
    }

    public void setProductoPropiedad(String productoPropiedad) {
        this.productoPropiedad.set(productoPropiedad);
    }

    public int getNumEnvioPropiedad() {
        return numEnvioPropiedad.get();
    }

    public SimpleIntegerProperty numEnvioPropiedadProperty() {
        return numEnvioPropiedad;
    }

    public void setNumEnvioPropiedad(int numEnvioPropiedad) {
        this.numEnvioPropiedad.set(numEnvioPropiedad);
    }
}
