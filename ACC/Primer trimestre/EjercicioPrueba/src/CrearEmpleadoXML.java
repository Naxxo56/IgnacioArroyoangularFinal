import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CrearEmpleadoXML {
    //no dado aun
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\Aleatorio.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        RandomAccessFile rafile = new RandomAccessFile(fichero, "r");
        int id, departamento;
        double salario;
        char[] nombre = new char[10];
        char aux;
        String apellido;
        //Acceso aleatorio.Variable para situar el puntero del fichero inicializando a 0 para el inicio.
        long posicion = 0;
        //Creamos una instancia de DocumentBuilderFactory para construir el parser.
        //Puede producir una excepcion ParserConfigurationException.
        DocumentBuilderFactory docfactory = DocumentBuilderFactory.newInstance();

    }
}
