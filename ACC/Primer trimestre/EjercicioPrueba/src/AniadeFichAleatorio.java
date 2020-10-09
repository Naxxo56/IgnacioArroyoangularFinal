import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AniadeFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\Aleatorios.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        //declaramos el fichero de acceso aleatorio
        RandomAccessFile rafile = new RandomAccessFile(fichero,"rw");
        //buffer para tratar el apellido
        StringBuffer buffer = null;
        //posicion final del fichero
        //long posicion = rafile.length();
        //rafile.seek(posicion);

        //Datos a añadir ; id,apellido,departamento,salario
        int id=10;
        String apellido = "BARTOLOME";
        int dep = 60;
        double salario = 3450.00;

        //vamos a insertar un empleado con ID 10.En vez de insertar al final del tdo , vamos a calcular su posicion
        long posicion = (id-1) * 36;
        //posicion = (posicion-1) *36
        rafile.seek(posicion);

        rafile.writeInt(id);
        buffer = new StringBuffer(apellido);
        buffer.setLength(10);
        rafile.writeChars(buffer.toString());
        rafile.writeInt(dep);
        rafile.writeDouble(salario);

    }

}
