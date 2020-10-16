import java.io.Serializable;

public class Coche implements Serializable {
    private static final long serialVersionUID = 1L;
    private String marca, modelo;
    private int unidades;
    private double precio;

    public Coche(String marca, String modelo, int unidades, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.unidades = unidades;
        this.precio = precio;
    }

    public Coche() {

    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
