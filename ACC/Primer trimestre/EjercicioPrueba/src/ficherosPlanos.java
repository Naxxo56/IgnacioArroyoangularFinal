import java.io.*;

public class ficherosPlanos {
    public static void main(String[] args) throws IOException {
        Persona persona;
        File fichero = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\FichPersona.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        FileOutputStream file_out = new FileOutputStream(fichero);
        ObjectOutputStream dataOS = new ObjectOutputStream(file_out);
        String nombres[] = {"Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andres", "Julio", "Antonio", "Maria Jesus", "Eva"};
        int edades[] = {19, 21, 23, 25, 26, 18, 19, 24, 23, 20};
        for (int i = 0; i < nombres.length; i++) {
            persona = new Persona(nombres[i], edades[i]);
            dataOS.writeObject(persona);
        }
        dataOS.close();
    }
}
