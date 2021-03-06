import java.io.*;
import org.apache.commons.net.ftp.*;

public class DescargarFichero {
    public static void main(String[] args) {

        FTPClient cliente = new FTPClient(); //cliente
        String servidor = "ftp.rediris.es"; //servidor
        String user = "";
        String pasw = "";

        try {
            System.out.println("Conectandose a " + servidor);
            cliente.connect(servidor);
            boolean login = cliente.login(user, pasw);
            String direc = "servidor";

            if (login) {
                cliente.changeWorkingDirectory(direc);
                cliente.setFileType(FTP.BINARY_FILE_TYPE);

                //Stream de entrada con el fichero a descargar
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:\\Users\\Usuario DAM2\\Desktop\\descargass\\welcome.msg"));

                if (cliente.retrieveFile("welcome.msg", out)) {
                    System.out.println("Recuperado correctamente...");
                } else {
                    System.out.println("No se ha podido descargar...");
                }

                out.close(); //cerrar flujo
                cliente.logout(); //logout del usuario
                cliente.disconnect(); // desconexion del servidor
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
