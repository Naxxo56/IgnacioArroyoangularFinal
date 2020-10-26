import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Examen103 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\alumnos.bin");
        ArrayList<Alumno> listaAlumnos = new ArrayList();
        //creamos este if por si no detecta el .bin
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        //declaramos todas las variables necesarias
        String nombre, especialidad;
        int id, curso, opcion;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Opcion 1:Crear alumno");
            System.out.println("Opcion 2:Mostrar por pantalla");
            System.out.println("Opcion 3:Salir");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Introduzca el nombre");
                    nombre = teclado.next();
                    System.out.println("Introduzca la especialidad");
                    especialidad = teclado.next();
                    System.out.println("Introduzca el id");
                    id = teclado.nextInt();
                    System.out.println("Introduzca el curso");
                    curso = teclado.nextInt();
                    Alumno alumno = new Alumno(nombre, especialidad, id, curso);
                    listaAlumnos.add(alumno);
                    //declaramos un fileOUTput y un objectOutput para escribir en el fichero, y usamos el Object porque tratamos con objetos
                    FileOutputStream fileOn = new FileOutputStream(fichero);
                    ObjectOutputStream objOut = new ObjectOutputStream(fileOn);
                    objOut.writeObject(listaAlumnos);
                    objOut.close();
                    break;
                case 2:
                    /*
                    Boolean salir=false;
                    try{

                        FileInputStream fileIn = new FileInputStream(fichero);
                        ObjectInputStream objIn = new ObjectInputStream(fileIn);
                        //Alumno alumnoLeer = (Alumno) objIn.readObject();
                        Object aux = objIn.readObject();
                        while (aux!=null)
                        {
                            if (aux instanceof Alumno)
                                System.out.println(aux);
                            aux = objIn.readObject();
                        }
                        objIn.close();
                    }catch (EOFException eofe) {
                        salir = true;
                    }
                         */
                    /*
                    FileInputStream fileIn = null;
                    ObjectInputStream fileOut = null;
                    ArrayList<Alumno> listaRecuperada = null;
                    boolean salir = false;
                    try {
                        // Creamos el flujo entrada
                        fileIn = new FileInputStream(fichero);
                        fileOut = new ObjectInputStream(fileIn);
                        while (!salir) {
                            listaRecuperada = (ArrayList<Alumno>) fileOut.readObject();
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (EOFException eofe) {
                        salir = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                            fileOut.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(listaRecuperada.size());
                    for (int i = 0; i < listaRecuperada.size(); i++) {
                        listaAlumnos.add(listaRecuperada.get(i));
                    }

                     */
                    System.out.println("Mostrando lista alumnos");
                    for (Alumno alum : listaAlumnos) {
                        System.out.println(alum.toString());
                    }
                    //este metodo sirve para guardar el archivo y que no se borren los datos
                    almacenarAlumno(fichero, listaAlumnos);
                    break;
                case 3:
                    System.out.println("saliendo");
                    break;

            }
        } while (opcion != 3);
    }

    public static void almacenarAlumno(File f, ArrayList<Alumno> co) {
        FileInputStream fileIn = null;
        ObjectInputStream fileOut = null;

        ArrayList<Alumno> listaRecuperada = null;
        boolean salir = false;

        try {
            //declaramos un fileINput y un objectINput para leer en el fichero, y usamos el Object porque tratamos con objetos
            fileIn = new FileInputStream(f);
            fileOut = new ObjectInputStream(fileIn);
            while (!salir) {
                listaRecuperada = (ArrayList<Alumno>) fileOut.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (EOFException eofe) {
            salir = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fileOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < listaRecuperada.size(); i++) {
            co.add(listaRecuperada.get(i));
        }
    }


}
