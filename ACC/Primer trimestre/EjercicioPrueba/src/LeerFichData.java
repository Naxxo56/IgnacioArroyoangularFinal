import javax.xml.crypto.Data;
import java.io.*;

public class LeerFichData {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\FichaData.dat");
        FileInputStream filein = new FileInputStream(fichero);
        DataInputStream dataIS = new DataInputStream(filein);
        String nombre;
        int edad;
        try{
            while ((nombre = dataIS.readUTF())!=null){
                edad = dataIS.readInt();
                System.out.println("Nombre:" + nombre +",Edad:"+edad);
            }
        } catch (IOException e) {
            dataIS.close();
        }
    }
}
