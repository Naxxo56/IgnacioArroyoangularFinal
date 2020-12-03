package EjerciciosEvaluables;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio202 {
    public static void main(String[] args) throws IOException {
        String nombre, localidad;
        int id;
        int numeroDep = 4;
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\departamentos.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        Departamento departamentoUno = new Departamento(1,"Medicina","Madrid");
        Departamento departamentoDos = new Departamento(2,"Profesor","Valencia");
        Departamento departamentoTres = new Departamento(3,"Programador","Aragon");
        Departamento departamentoCuatro = new Departamento(4,"TecnicoDeRayos","Galicia");
        Departamento departamentoCinco = new Departamento(5,"Submarinista","Cataluña");

        FileOutputStream fileOut = new FileOutputStream(fichero);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
        objOut.writeObject(departamentoUno);
        objOut.writeObject(departamentoDos);
        objOut.writeObject(departamentoTres);
        objOut.writeObject(departamentoCuatro);
        objOut.writeObject(departamentoCinco);

    }
}