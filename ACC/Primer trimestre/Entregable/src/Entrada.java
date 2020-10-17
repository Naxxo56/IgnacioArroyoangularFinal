import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //creamos un coche
        Coche coche = new Coche();
        //creamos el array que contiene a los coches
        ArrayList<Coche> listaCoches = new ArrayList();
        //creamos el fichero donde se va a crear el coche.dat
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\coche.dat");
        //creamos este if por si no detecta el .dat para que lo cree
        if(!fichero.exists()){
            fichero.createNewFile();
        }
        //declaramos todas las variables necesarias
        Scanner teclado = new Scanner(System.in);
        int opcion;
        String marca;
        String modelo;
        int unidades;
        double precio;
        String modificacion = "";
        recuperar(fichero,listaCoches);
        //menu
        do {
            System.out.println("Introduzca una opcion");
            System.out.println("1-Meter coche");
            System.out.println("2-Quitar coche");
            System.out.println("3-Modificar coche");
            System.out.println("4-Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca la marca");
                    marca = teclado.next();
                    System.out.println("Introduzca el modelo");
                    modelo = teclado.next();
                    System.out.println("Introduzca las unidades");
                    unidades = teclado.nextInt();
                    System.out.println("Introduzca el precio");
                    precio = teclado.nextDouble();

                    coche = new Coche(marca, modelo, unidades, precio);
                    listaCoches.add(coche);
                    //declaramos un fileOUTput y un objectOutput para escribir en el fichero, y usamos el Object porque tratamos con objetos
                    FileOutputStream fileOn = new FileOutputStream(fichero);
                    ObjectOutputStream objOut = new ObjectOutputStream(fileOn);
                    //escribimos
                    objOut.writeObject(listaCoches);
                    //cerramos el flujo
                    objOut.close();
                    break;
                case 2:
                    System.out.println("Introduzca la marca del coche a eliminar");
                    marca = teclado.next();
                    System.out.println("Introduzca el modelo del coche a eliminar");
                    modelo = teclado.next();
                    if (marca.equals(coche.getMarca()) && modelo.equals(coche.getModelo())) {
                        listaCoches.remove(coche);
                    }
                    //declaramos un fileOUTput y un objectOutput para escribir en el fichero, y usamos el Object porque tratamos con objetos
                    FileOutputStream fileOn1 = new FileOutputStream(fichero);
                    ObjectOutputStream obOut1 = new ObjectOutputStream(fileOn1);
                    obOut1.writeObject(listaCoches);

                    break;
                case 3:
                    System.out.println("Introduce la marca del coche que quieras modificar");
                    marca = teclado.next();
                    System.out.println("Introduce el modelo del coche que quieras modificar");
                    modelo = teclado.next();
                    for (Coche coche1 : listaCoches) {

                        if (marca.equals(coche1.getMarca()) && modelo.equals(coche1.getModelo())) {
                            System.out.println("Que quieres modificar(marca,modelo,unidades o precio)");
                            modificacion = teclado.next();
                            switch (modificacion) {
                                case "marca":
                                    System.out.println("Introduce la marca");
                                    marca = teclado.next();
                                    coche1.setMarca(marca);
                                    break;
                                case "modelo":
                                    System.out.println("Introduce el modelo");
                                    modelo = teclado.next();
                                    coche1.setModelo(modelo);
                                    break;

                                case "unidades":
                                    System.out.println("Introduce las unidades");
                                    unidades = teclado.nextInt();
                                    coche1.setUnidades(unidades);
                                    break;

                                case "precio":
                                    System.out.println("Introduce el precio");
                                    precio = teclado.nextDouble();
                                    coche1.setPrecio(precio);
                                    break;

                            }
                            //declaramos un fileOUTput y un objectOutput para escribir en el fichero, y usamos el Object porque tratamos con objetos
                            FileOutputStream fileOn2 = new FileOutputStream(fichero);
                            ObjectOutputStream obOut2 = new ObjectOutputStream(fileOn2);
                            obOut2.writeObject(listaCoches);
                            break;
                        }
                    }

                    break;
                case 4:

                    break;
            }
        } while (opcion != 4);


    }
    public static void recuperar(File f,ArrayList<Coche> co) {
        ArrayList<Coche> listaAuxiliar = new ArrayList();
        FileInputStream fileIn = null;
        ObjectInputStream obOut4 = null;
        boolean salir= false;
        try {
            //declaramos un fileINput y un objectINput para leer en el fichero, y usamos el Object porque tratamos con objetos
            fileIn = new FileInputStream(f);
            obOut4 = new ObjectInputStream(fileIn);
            while (!salir) {
                listaAuxiliar = (ArrayList<Coche>) obOut4.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException e) {
            salir=true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                obOut4.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < listaAuxiliar.size(); i++) {
            co.add(listaAuxiliar.get(i));
        }
    }
}
