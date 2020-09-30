import java.util.ArrayList;

public class Concesionario {
     ArrayList<Empleado> listaEmpleados;
     ArrayList<Coche> listaCoches;

    public Concesionario() {
        Empleado empleadoUno = new Empleado(1, "Roberto", "1234A", "1234");
        Turismo turismoUno = new Turismo("Seat", "1234", 10000, 100);
        Turismo turismoDos = new Turismo("Ford", "2345", 15000, 150);
        Comercial comercialUno = new Comercial("Mercedes", "3456", 30000, 100);
        Comercial comercialDos = new Comercial("Bmw", "4567", 40000, 200);
        this.listaEmpleados = new ArrayList<>();
        this.listaCoches = new ArrayList<>();
        listaCoches.add(turismoDos);
        listaCoches.add(turismoUno);
        listaEmpleados.add(empleadoUno);
        listaCoches.add(comercialDos);
        listaCoches.add(comercialUno);
    }
    public  ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public  void setListaEmpleados(ArrayList<Empleado> listaEmpleados) {
       this.listaEmpleados = listaEmpleados;
    }

    public  ArrayList<Coche> getListaCoches() {
        return listaCoches;
    }

    public void setListaCoches(ArrayList<Coche> listaCoches) {
        this.listaCoches = listaCoches;
    }
    @Override
    public String toString() {
        return "Concesionario{" +
                "listaEmpleados=" + listaEmpleados +
                ", listaCoches=" + listaCoches +
                '}';
    }
    public  void mostrarCoches(){
        for (int i = 0; i < listaCoches.size(); i++) {
            System.out.println(listaCoches.get(i));
        }
    }
    public void buscarCoche(String matricula){
        for (int i = 0; i < listaCoches.size(); i++) {
          if(listaCoches.contains(matricula)){
              System.out.println(listaCoches);
          }else{
              System.out.println("Coche no encontrado");
          }
        }
    }
    public void verSalario(){
        System.out.println();
    }
}
