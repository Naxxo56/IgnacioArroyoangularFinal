import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int opcion = 0;
        ArrayList<Coche> listaCoches = new ArrayList();
        Boolean salir = false;
        Coche coche = new Coche();
        String marca = "";
        String modelo = "";
        int unidades = 0;
        double precio = 0;
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\coches.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        do {
            System.out.println("Seleccione una opcion");
            System.out.printf("1ºDar de alta%n" +
                    "2ºDar de baja %n" +
                    "3ºModificar%n" +
                    "4ºSalir%n");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca la marca");
                    marca = teclado.next();
                    System.out.println("Introduzca la modelo");
                    modelo = teclado.next();
                    System.out.println("Introduzca la unidades");
                    unidades = teclado.nextInt();
                    System.out.println("Introduzca la precio");
                    precio = teclado.nextInt();
                    coche = new Coche(marca, modelo, unidades, precio);
                    listaCoches.add(coche);
                    FileOutputStream fileOut = new FileOutputStream(fichero);
                    ObjectOutputStream objetOut = new ObjectOutputStream(fileOut);
                    objetOut.writeObject(listaCoches);
                    objetOut.close();
                    break;
                case 2:
                    listaCoches.remove(coche);
                    /*
                    FileInputStream fileIn = new FileInputStream(fichero);
                    ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                    try{
                        while (!salir){
                            listaCoches = (ArrayList) objectIn.readObject();
                            for (Coche c: listaCoches) {
                                System.out.println(c);
                            }
                        }
                    }catch (EOFException eo){
                        salir=true;
                    }

                    finally {
                        objectIn.close();
                    }

                     */
                    break;
                case 3:
                    coche.setMarca(marca = teclado.next());
                    coche.setModelo(modelo = teclado.next());
                    coche.setUnidades(unidades = teclado.nextInt());
                    coche.setPrecio(precio = teclado.nextInt());
                    break;
                case 4:
                    System.out.println("SALIENDO");
                    break;
            }

        } while (opcion != 4);


    }
}
