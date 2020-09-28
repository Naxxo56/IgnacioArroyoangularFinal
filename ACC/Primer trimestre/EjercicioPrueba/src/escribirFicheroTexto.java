import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class escribirFicheroTexto {
    public static void main(String[] args) throws IOException {
        //abrimos el fichero
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\archivo.txt");
        //creamos flujo de salida
        FileWriter fw = new FileWriter(fichero);
        String cadena = "Esto  es una prueba de FileWriter";
        //convertmos un string en un array de caracteres
        char[] cad = cadena.toCharArray();
        for (int i = 0; i <cad.length ; i++) {
            //escribimos caracter a caracter
            fw.write(cad[i]);
        }
        //añadimos un caracter final
        fw.append("\n*");
        //cerramos el fichero
        fw.close();
    }
}
