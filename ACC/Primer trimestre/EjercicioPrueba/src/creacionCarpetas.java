import java.io.File;
import java.io.IOException;

public class creacionCarpetas {
    public static void main(String[] args) {
        //definimos la raiz sobre la que vamos a trabajar
        String dir = "C:\\Users\\digim\\Documents\\auxiliar_java";
        //definimos un objeto file con el nombre del nuevo dirctorio y lo crea
        File nuevodir = new File(dir,"nuevodir");
        nuevodir.mkdir();
        //definimos un objeto file pr cada archivo q queremos crear
        //Objeto file con directorio+nombre archivo
        File f1 = new File(nuevodir,"archivo1.txt");
        File f3 =new File(nuevodir,"archivo3.txt");
        //creamos los ficheros
        try{
            if(f1.createNewFile())
                System.out.println("fichero 1 creado correctamente");
                else
                System.out.println("no se ha podido crear el fichero 1");

                if(f3.createNewFile())
                    System.out.println("fichero 3 creado correctametne");
                else
                    System.out.println("nose ha podido crear el fichero3");
            }
        catch(IOException ioe){
            ioe.printStackTrace();
        }
        //renombre del fichero

        f3.renameTo(new File(nuevodir,"archivo2.txt"));

    }
}
