import java.util.Scanner;

public class Entrada extends zonasEntradas {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("Elija una opcion de las siguientes");
            System.out.println("1. Mostrar número de entradas libres \n" +
                    "2. Vender entradas\n" +
                    "3. Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    mostrarEntradas();
                    break;
                case 2:
                    venderEntradas();
                    break;
                case 3:
                    System.out.println("Saliendo");
                    break;
            }
        } while (opcion != 3);
    }
}
