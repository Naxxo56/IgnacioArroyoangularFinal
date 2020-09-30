import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    static int opcion;
    static Scanner teclado = new Scanner(System.in);
  
    public static void main(String[] args) {
        Concesionario concesionario = new Concesionario();
        do {
            System.out.println("Elija una opcion");
            System.out.println("1. Ver los coches en stock\n" +
                    "2. Buscar un coche concreto\n" +
                    "3. Vender un coche\n" +
                    "4. Ver salario\n" +
                    "5. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                  concesionario.mostrarCoches();
                  break;
                case 2:
                    String matricula;
                    System.out.println("Introduzca matricula");
                    matricula = teclado.next();
                    concesionario.buscarCoche(matricula);
                    break;
                case 3:

                    break;
                case 4:
                
                    break;
                case 5:
                    System.out.println("Saliendo");
                    break;
            }
        } while (opcion != 5);
    }
}



