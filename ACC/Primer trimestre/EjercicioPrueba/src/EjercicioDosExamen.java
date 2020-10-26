import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class EjercicioDosExamen {
    public static void main(String[] args) throws IOException {
        int id, departamento;
        double salario, nuevoSalario;
        char[] nombre = new char[10];
        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduce el id");
        id = teclado.nextInt();
        System.out.println("Introduce salario");
        nuevoSalario = teclado.nextDouble();
        teclado.close();
        File fichero = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\Aleatorios.dat");
        RandomAccessFile rafile = new RandomAccessFile(fichero, "rw");
        long posicion = (id - 1) * 36;
        rafile.seek(posicion);
        id = rafile.readInt();
        if (id == 0) {
            System.out.println("No existe");
            System.exit(0);
        }
        for (int i = 0; i < nombre.length; i++) {
            nombre[i] = rafile.readChar();
        }
        String item = new String(nombre);
        departamento = rafile.readInt();
        salario = rafile.readDouble();
        if (salario != 0) {
            double auxSalario = salario;
            nuevoSalario += salario;
            posicion = ((id - 1) * 36) + 28;
            rafile.seek(posicion);
            rafile.writeDouble(nuevoSalario);
        }
        rafile.close();
        System.out.println("Nombre: " + nombre+ " Salario:" + salario + " El salario nuevo es:"  +  nuevoSalario + " Id:" + id +  " Departamento:" + departamento);

    }
}
