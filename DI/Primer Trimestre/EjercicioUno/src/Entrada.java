import java.util.Scanner;

public class Entrada {

    public static void main(String[] args) {
        int kilometro = 0;

        Vehiculo vehiculo = new Vehiculo();

        Bicicleta bicicleta1 = new Bicicleta();
        vehiculo.setVehiculosCreados(vehiculo.getVehiculosCreados() + 1);

        Coche coche1 = new Coche();
        vehiculo.setVehiculosCreados(vehiculo.getVehiculosCreados() + 1);

        //System.out.println(vehiculo.getVehiculosCreados());

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1ºAnda con la bicicleta");
            System.out.println("2ºHaz el caballito con la bicicleta");
            System.out.println("3ºAnda con el coche");
            System.out.println("4ºQuema rueda con el coche ");
            System.out.println("5ºVer kilometraje de la bicicleta ");
            System.out.println("6ºVer kilometraje del coche");
            System.out.println("7ºVer kilometraje total");
            System.out.println("8ºSalir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    kilometro += (int) bicicleta1.andar();
                    System.out.println("los km recorridos por la bicicleta son : " + kilometro);
                    vehiculo.setKilometrosRecorridos((int) (vehiculo.getKilometrosRecorridos()+kilometro));
                    bicicleta1.setkilometrosIndividuales((int)(bicicleta1.getKilometrosRecorridos()+kilometro));
                    break;
                case 2:

                    break;
                case 3:
                    kilometro += (int) coche1.andar();
                    System.out.println("los km recorridos por el coche son : " + kilometro);
                    vehiculo.setKilometrosRecorridos((int) (vehiculo.getKilometrosRecorridos()+kilometro));
                    coche1.setkilometrosIndividuales((int)(coche1.getKilometrosRecorridos()+kilometro));
                    break;
                case 4:

                    break;
                case 5:
                    System.out.println(bicicleta1.getkilometrosIndividuales());
                    break;
                case 6:
                    System.out.println(coche1.getkilometrosIndividuales());
                    break;
                case 7:
                    System.out.println(vehiculo.getKilometrosRecorridos());
                    break;
                case 8:

                    break;
            }
        } while (opcion != 8);
    }
}
