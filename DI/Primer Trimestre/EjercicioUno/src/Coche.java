public class Coche extends Vehiculo {

    public Coche() {

    }


    @Override
    public int getVehiculosCreados() {
        return super.getVehiculosCreados();
    }

    @Override
    public void setVehiculosCreados(int vehiculosCreados) {
        super.setVehiculosCreados(vehiculosCreados);
    }

    @Override
    public double getKilometrosTotales() {
        return super.getKilometrosTotales();
    }

    @Override
    public void setKilometrosTotales(int kilometrosTotales) {
        super.setKilometrosTotales(kilometrosTotales);
    }

    @Override
    public double getKilometrosRecorridos() {
        return super.getKilometrosRecorridos();
    }

    @Override
    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        super.setKilometrosRecorridos(kilometrosRecorridos);
    }

    public int getkilometrosIndividuales() {
        return this.kilometrosIndividuales;
    }

    public void setkilometrosIndividuales(int km) {
        this.kilometrosIndividuales = km;
    }

    public void quemarRueda() {

    }


}
