import java.io.*;

public class Ejercicio_09 {
    public static void main(String[] args) throws IOException {
        File archivo = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\pedidos.dat");
        FileInputStream filein = new FileInputStream(archivo);
        DataInputStream datain = new DataInputStream(filein);
        String nombre;
        int unidades;
        int precio;
        int precioMax = 0;
        try {
            while ((nombre = datain.readUTF()) != null) {
                //nombre = datain.readUTF();
                unidades = datain.readInt();
                precio = datain.readInt();
                int precioMulti = precio * unidades;
                if (precioMulti > precioMax) {
                    precioMax = precioMulti;
                }
                System.out.println("Nombre: " + nombre + ",Unidades:" + unidades + " Precio:" + precio);
            }
        } catch (EOFException e) {
            datain.close();
        }
        System.out.println("El precio maximo que podremos obtener es de: " + precioMax);
    }


}
