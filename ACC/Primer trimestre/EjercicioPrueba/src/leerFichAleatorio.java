import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class leerFichAleatorio {
    public static void main(String[] args) throws FileNotFoundException {
        File fichero = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\Aleatorios.dat");
        RandomAccessFile rafile = new RandomAccessFile(fichero,"rw");
    }
}
