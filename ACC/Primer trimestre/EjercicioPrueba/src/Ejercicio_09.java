import java.io.*;

public class Ejercicio_09 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\pedidos.dat");
        FileInputStream filein = new FileInputStream(archivo);
        DataInputStream dataIS = new DataInputStream(filein);
        String nombre;
        int unidades;
        int precio;
        int precioMax = 0;
        try {
            while (true) {
                nombre = dataIS.readUTF();
                unidades = dataIS.readInt();
                precio = dataIS.readInt();
                for (int i = 0; i < 5; i++) {
                    int precioMulti = precio * unidades;
                    if (precioMulti > precioMax) {
                        precioMax = precioMulti;
                    }
                }
                System.out.println("Nombre: " + nombre + ",Unidades:" + unidades + " Precio:" + precio);
            }
        } catch (IOException e) {
            dataIS.close();
        }
        System.out.println("El precio maximo que podremos obtener es de" + precioMax);
    }


}
