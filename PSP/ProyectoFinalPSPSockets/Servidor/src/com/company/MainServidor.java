package com.company;

import java.util.Scanner;

public class MainServidor {

    public static void main(String[] args) {
        int puerto = 0;
        if (args.length == 1) {
            try {
                puerto = Integer.parseInt(args[0]);
            } catch (Exception e) {
                System.out.println("Debe indicar un número de" +
                        " puerto válido que no esté en uso.");
                System.exit(1);
            }
        } else {
            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.print("Introduce el puerto de escucha " +
                    "(no debe estar en uso por otra aplicación): ");
            try {
                puerto = Integer.parseInt(lecturaTeclado.nextLine());
            } catch (Exception e) {
                System.out.println("Debe indicar un número " +
                        "de puerto válido que no esté en uso.");
                System.exit(1);
            }
        }
        if (puerto > 0) {
            Servidor prepararServidor = new Servidor(puerto);
            prepararServidor.start();
        } else {
            System.out.println("Debe indicar un número " +
                    "de puerto válido que no esté en uso.");
            System.exit(1);
        }
    }
}
