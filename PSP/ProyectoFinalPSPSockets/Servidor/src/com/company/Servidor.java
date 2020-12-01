package com.company;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

    public class Servidor extends Thread {
        private int puerto;
        private DataInputStream canalEntradaDatos;
        public Servidor(int puerto) {
            this.puerto = puerto;
        }
        @Override
        public void run() {
            try {
                ServerSocket socketServidor = new ServerSocket(this.puerto);
                System.out.println(FechaActual() + " Servidor esperando " +
                        "peticiones de clientes por puerto " + puerto + "...");
                String mensajeCliente = "";
                while(!mensajeCliente.equalsIgnoreCase("[[fin]]")) {
                    Socket socketCliente = socketServidor.accept();
                    System.out.println(FechaActual() +
                            " Cliente conectado: " + socketCliente.getInetAddress());
                    canalEntradaDatos = new DataInputStream(socketCliente.getInputStream());
                    mensajeCliente = canalEntradaDatos.readUTF();
                    System.out.println(FechaActual() + "[Mensaje recibido]");
                    System.out.println(FechaActual() +
                            " * Cliente: " + socketCliente.getInetAddress());
                    System.out.println(FechaActual() +
                            " * Mensaje: " + mensajeCliente);
                }
            } catch (IOException e) {
                System.out.println(FechaActual() + " Error al abrir puerto " + puerto +
                        " para escucha de servidor: " + e.getMessage());
                System.exit(2);
            }
        }
        public String FechaActual()
        {
            Date fechaHoraActual = new Date();
            String fechaFormateada =
                    new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(fechaHoraActual);
            return fechaFormateada;
        }
    }
