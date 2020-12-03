package com.company;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
public class MainCliente {
    public static void main(String[] args) {
        int puerto = 0;
        String servidor = "";
        String mensaje = "";

        if (args.length == 3) {
            servidor = args[1];
            try {
                puerto = Integer.parseInt(args[1]);
            } catch (Exception e) {
                System.out.println("Debe indicar un número de" +
                        " puerto válido que no esté en uso.");
                System.exit(1);
            }
            mensaje = args[2];
        } else {
            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.print("Introduce la dirección del servidor: ");
            servidor = lecturaTeclado.nextLine();
            System.out.print("Introduce el puerto de conexión con el servidor: ");
            try {
                puerto = Integer.parseInt(lecturaTeclado.nextLine());
            } catch (Exception e) {
                System.out.println("Debe indicar un número " +
                        "de puerto válido que no esté en uso.");
                System.exit(1);
            }
            System.out.print("Introduce el mensaje a enviar: ");
            mensaje = lecturaTeclado.nextLine();
        }
        if (puerto > 0) {
            try {
                System.out.println(FechaActual() + " Conectando con servidor " + servidor + " por puerto: " + puerto + "...");
                Socket clientSocket = new Socket(servidor, puerto);
                System.out.println(FechaActual() + " Conectado a servidor: " + clientSocket.getInetAddress());
                DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
                System.out.println(FechaActual() + " Enviando mensaje a servidor...");
                outputStream.writeUTF(mensaje);
                System.out.println(FechaActual() + " Mensaje enviado a servidor: " + mensaje);
                clientSocket.close();
            } catch (UnknownHostException ex) {
                System.out.println("Servidor no encontrado: " + ex.getMessage());
                System.exit(1);
            } catch (IOException ex) {
                System.out.println("Error al conectar al servidor: " + ex.getMessage());
                System.exit(2);
            }
        } else {
            System.out.println("Debe indicar un puerto, una" +
                    " IP (o DNS) y un mensaje para el envío.");
            System.exit(1);
        }
    }
    public static String FechaActual() {
        Date fechaHoraActual = new Date();
        String fechaFormateada =
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(fechaHoraActual);
        return fechaFormateada;
    }
}
