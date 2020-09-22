public class Vehiculo {
    private int vehiculosCreados,kilometrosRecorridos;
    double kilometrosTotales;
    int kilometrosIndividuales;

    public Vehiculo() {

    }


    public double andar() {
        return Math.random() * 10;
    }

    public int getVehiculosCreados() {
        return vehiculosCreados;
    }

    public void setVehiculosCreados(int vehiculosCreados) {
        this.vehiculosCreados = vehiculosCreados;
    }

    public double getKilometrosTotales() {
        return kilometrosTotales;
    }

    public void setKilometrosTotales(int kilometrosTotales) {
        this.kilometrosTotales = kilometrosTotales;
    }

    public double getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

}
