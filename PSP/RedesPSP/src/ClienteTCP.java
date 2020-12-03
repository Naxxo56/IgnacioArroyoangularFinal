import java.io.IOException;
import java.net.InetAddress;
import java.net.NoRouteToHostException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClienteTCP {
    public static void main(String args[]) {

        Scanner teclado = new Scanner(System.in);
        System.out.println("Introduzca una URL");
        String URL = teclado.next();
        connect(URL,80);


        //connect("www.google.es",80);
    }
    public static void connect(String url, int port) {
        try {
            InetAddress adress = InetAddress.getByName(url);
            Socket socket = new Socket(adress, port);
            System.out.println("Conectando...");
            System.out.println("Conectado");
            System.out.println("Puerto remoto = " + socket.getPort());
            System.out.println("Puerto local = " + socket.getLocalPort());
            System.out.println("IP remoto = " + socket.getInetAddress());
            System.out.println("IP local = " + socket.getLocalAddress());
            socket.close();
        } catch (UnknownHostException e) {
            System.out.println("Error no se ha encontrado host, el nombre especificado!");
        } catch (NoRouteToHostException e) {
            System.out.println("No se puede conectar!");
        } catch (IOException e) {
            System.out.println("Error al conectar!");
        }
    }
}
