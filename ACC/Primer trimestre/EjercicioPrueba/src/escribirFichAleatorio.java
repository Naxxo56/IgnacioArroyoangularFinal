import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class escribirFichAleatorio {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\Aleatorios.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        //declaramos el fichero de acceso aleatorio
        RandomAccessFile rafile = new RandomAccessFile(fichero,"rw");
        //array de datos
        //apellidos
        String apellido []={"FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA","CASILLA","REY"};
        //departamentos
        int departamento[] = {10,20,10,10,30,30,20};
        //salarios
        Double salario[] = {1000.25,2400.60,3000.0,1500.56,2200.0,1435.87,2000.0};
        /*
        Definimos un buffer para almacenar el apellido
        String: Representacion de una cadena de caracteres.Es una clase inmutable.
                Se almacena en JavaStirngPool (2 cadenas iguales son la misma referencia)
        StringBuffered : Es mutable, por lo que se puede modificar con el tiempo.
                Tiene una capacidad inicial de 16 caracteres y se almacena en el heap
                ya que es un objeto en si mismo.Sus metodos son sincronizados
        StringBuilder:No valida por aplicaciones multi-hilo
         */
        StringBuffer buffer = null;
        //recorremos los arrays
        for (int i = 0; i <apellido.length ; i++) {
            //incluimos un identificador del empleado
            rafile.writeInt(i+1);
            buffer = new StringBuffer(apellido[i]);
            //establecemos una longitud(por defecto 16)
            buffer.setLength(10);
            //escribimos el apellido,departamento y salario
            rafile.writeChars(buffer.toString());
            rafile.writeInt(departamento[i]);
            rafile.writeDouble(salario[i]);
        }
        rafile.close();
    }
}
