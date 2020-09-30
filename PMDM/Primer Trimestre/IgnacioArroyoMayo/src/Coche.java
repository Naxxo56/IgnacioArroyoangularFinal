import java.util.ArrayList;

public class Coche {
    protected String modelo,matricula;
    protected double precio;
    ArrayList<Empleado> listaEmpleados;
    ArrayList<Coche> listaCoches;
    public Coche(String modelo, String matricula, double precio) {
        this.modelo = modelo;
        this.matricula = matricula;
        this.precio = precio;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", matricula='" + matricula + '\'' +
                ", precio=" + precio +
                '}';
    }

}
