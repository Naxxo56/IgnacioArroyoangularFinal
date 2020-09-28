import java.io.*;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

public class lecturaYescritura {
    public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Usuario DAM2\\Documents\\archivo.txt", StandardCharsets.UTF_8));
            BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Usuario DAM2\\Documents\\archivodos.txt"));
            try {
                String linea;
                while ((linea = br.readLine()) != null) {
                    bw.write(linea);
                    bw.newLine();
                    bw.flush();
                }
            } catch (FileNotFoundException fnf) {
                System.out.println("No se encuentra el fichero de e/s");
            } finally {
                br.close();
                bw.close();
            }
        }
    }
