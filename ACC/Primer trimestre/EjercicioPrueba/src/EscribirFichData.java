import java.io.*;

public class EscribirFichData {
    public static void main(String[] args) throws IOException {
        //definimos el fichero
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\FichaData.dat");
        if (!fichero.exists()) {
            fichero.createNewFile();
        }
        FileOutputStream fileout = new FileOutputStream(fichero);
        //definimos las clases que nos permiten trabajar con datos primitivos
        DataOutputStream dataOS = new DataOutputStream(fileout);
        //Array nombres
        String nombres [] = {"Ana","Luis Miguel","Alicia","Pedro","Manuel","Andres","Julio","Antonio","Maria Jesus","Eva"};
        //Array de edades
        int edades [] = {19,21,23,25,26,18,19,24,23,20};
        //recorremos el array y escribimos en el fichero
        for (int i = 0; i <edades.length ; i++) {
            System.out.println("Escribiendo:" +nombres[i] + " con edad:"+edades[i]);
            dataOS.writeUTF(nombres[i]); //escribe el nombre
            dataOS.writeInt(edades[i]);// escribe edad
        }
        dataOS.close();
    }
}
