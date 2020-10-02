import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejercicio08 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\pedidos.dat");
        if(!archivo.exists()){
            archivo.createNewFile();
        }
        FileOutputStream fileOut = new FileOutputStream(archivo);
        DataOutputStream dataOs = new DataOutputStream(fileOut);
        String articulos [] = {"camisa","pantalon","camiseta","chaqueta","zapatos"};
        int unidades [] = {100,100,50,20,15};
        int codigo [] = {20,10,3,4,5};
    }
}
