import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class leerFicheroTexto {
    public static void main(String[] args) throws IOException {
        //abrimos el fichero
        File archivo = new File("C:\\Users\\Usuario DAM2\\Documents\\archivo.txt");
        //creamos el flujo de entrada
        //indicamos el juego de caracteres estandar para poder leer tildes
        //al ser de texto usamos el filereader
        FileReader fr = new FileReader(archivo, StandardCharsets.UTF_8);
        //uso de bufferedReader
        BufferedReader br = new BufferedReader(fr);
        //leemos el fichero
        String linea;
        while((linea=br.readLine()) !=null)
            System.out.println(linea);
        //cerramos fichero
            fr.close();
    }
}
