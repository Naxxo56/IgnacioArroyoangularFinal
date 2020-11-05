package sample.utils;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class Pizza {
    String nombre;
    String telefono;
    Boolean estado;
    String pizza;
    SimpleStringProperty nombrePropiedad, apellidoPropiedad,pizzaPropiedad;
    SimpleStringProperty telefonoPropiedad;
    SimpleBooleanProperty estadoPropiedad;

    public Pizza(String pizza,String nombre, String telefono, Boolean estado) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.pizza = pizza;
        nombrePropiedad=new SimpleStringProperty(nombre);
        pizzaPropiedad=new SimpleStringProperty(pizza);
        telefonoPropiedad=new SimpleStringProperty(telefono);
        estadoPropiedad=new SimpleBooleanProperty(estado);
        this.estado=false;
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

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public String getApellidoPropiedad() {
        return apellidoPropiedad.get();
    }

    public String getPizzaPropiedad() {
        return pizzaPropiedad.get();
    }

    public SimpleStringProperty pizzaPropiedadProperty() {
        return pizzaPropiedad;
    }

    public void setPizzaPropiedad(String pizzaPropiedad) {
        this.pizzaPropiedad.set(pizzaPropiedad);
    }

    public SimpleStringProperty apellidoPropiedadProperty() {
        return apellidoPropiedad;
    }

    public void setApellidoPropiedad(String apellidoPropiedad) {
        this.apellidoPropiedad.set(apellidoPropiedad);
    }

    public String getTelefonoPropiedad() {
        return telefonoPropiedad.get();
    }

    public SimpleStringProperty telefonoPropiedadProperty() {
        return telefonoPropiedad;
    }

    public void setTelefonoPropiedad(String telefonoPropiedad) {
        this.telefonoPropiedad.set(telefonoPropiedad);
    }

    public boolean isEstadoPropiedad() {
        return estadoPropiedad.get();
    }

    public SimpleBooleanProperty estadoPropiedadProperty() {
        return estadoPropiedad;
    }

    public void setEstadoPropiedad(boolean estadoPropiedad) {
        this.estadoPropiedad.set(estadoPropiedad);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
