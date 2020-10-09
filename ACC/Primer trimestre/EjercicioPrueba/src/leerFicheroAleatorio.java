import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class leerFicheroAleatorio {
    public static void main(String[] args) throws IOException {
       File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\Aleatorios.dat");
       //Acceso a traves de fichero aleatorio
        RandomAccessFile rafile = new RandomAccessFile(fichero,"r");

        int id,dep,posicion;
        double salario;
        char apellido [] = new char[10],aux;
        //Nos posicionamos en el inicio del fichero
        posicion=0;
        for (;;) {
            //puntero a la posicion que queremos leer
            rafile.seek(posicion);
            id = rafile.readInt();
            //recuperamos el apellido caracter a caracter
            for (int i = 0; i < apellido.length; i++) {
                aux = rafile.readChar();
                apellido[i] = aux;
            }
            //convierto el array quye hemos recuperado a String
            String apellidos = new String(apellido);
            //recuperamos el departamento
            dep=rafile.readInt();
            //recuperamos el salario
            salario=rafile.readDouble();
            //imprimimos el resultado
            System.out.println("ID empleado" + id + "apellido:"+apellidos+"departamento:"+dep+"salario:"+salario);
            //desplazamos el puntero del fichero a la longitud del fichero
            posicion+=36;
            //compruebo si he llegado al final del fichero y, si es asi,salgo
            if(rafile.getFilePointer()==rafile.length())break;
        }
        rafile.close();
    }
}
