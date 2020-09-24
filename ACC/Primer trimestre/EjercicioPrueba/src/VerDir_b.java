import java.io.File;

public class VerDir_b {
    public static void main(String[] args) {
        System.out.println("Ficheros en el directorio actual");
        File dir = new File("C:\\Users\\digim\\OneDrive\\Escritorio\\Fotos");
        String [] archivos = dir.list();
       for (int i = 0; i < archivos.length ; i++) {
            System.out.println(archivos[i]);
        }
    }
}
