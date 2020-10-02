import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio_08 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\pedidos.dat");
        if (!archivo.exists()) {
            archivo.createNewFile();
        }
        FileOutputStream fileOut = new FileOutputStream(archivo);
        DataOutputStream dataOs = new DataOutputStream(fileOut);
        String articulos[] = {"Camisa", "Pantalon", "Camiseta", "Chaqueta", "Zapatos"};
        int unidades[] = {100, 100, 150, 60, 40};
        int codigo[] = {90, 120, 20, 250, 110};
        for (int i = 0; i < unidades.length; i++) {
            System.out.println("Escribiendo:" + articulos[i] + " con este numero en stock:" + unidades[i] + " y con este precio:" + codigo[i]);
            dataOs.writeUTF(articulos[i]);
            dataOs.writeInt(unidades[i]);
            dataOs.writeInt(codigo[i]);
        }
        dataOs.close();
    }
}
