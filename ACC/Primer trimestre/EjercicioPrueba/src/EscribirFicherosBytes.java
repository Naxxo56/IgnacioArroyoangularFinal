import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class EscribirFicherosBytes {
    public static void main(String[] args) throws IOException {
        //fichero binario sobre el que vamos a trabajar
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\prueba.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        //creamos flujo de entrada
        FileInputStream filein = new FileInputStream(fichero);
        //creamos un flujo de salida hacia el fichero
        FileOutputStream fileout = new FileOutputStream(fichero);
        int i;
        for (i = 1; i < 100; i++) {
            fileout.write(i);
        }
        fileout.close();
        // leemos los datos del flujo de entrada
        while ((i = filein.read()) != -1) {
            //visualizamos los datos
            System.out.println(i);
        }
        filein.close();
    }
}
