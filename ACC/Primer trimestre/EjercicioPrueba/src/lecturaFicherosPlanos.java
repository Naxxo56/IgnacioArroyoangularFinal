import java.io.*;

public class lecturaFicherosPlanos {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Persona persona;
        Boolean salir = false;
        File fichero = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\FichPersona.dat");
        FileInputStream file_in = new FileInputStream(fichero);
        ObjectInputStream dataIS = new ObjectInputStream(file_in);
        try {
            while (!salir) {
                persona = (Persona) dataIS.readObject();
                System.out.println("Persona: " + persona.getNombre() + " tiene " + persona.getEdad() + " años.");
            }
        } catch (EOFException eo) {
            salir=true;
        } finally {
            dataIS.close();
        }


    }
}
