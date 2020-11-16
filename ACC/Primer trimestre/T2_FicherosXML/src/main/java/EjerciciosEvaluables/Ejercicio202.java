package EjerciciosEvaluables;

import java.io.*;

public class Ejercicio202 {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\departamentos.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        FileOutputStream fileOut = new FileOutputStream(fichero);
        ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
    }
}
