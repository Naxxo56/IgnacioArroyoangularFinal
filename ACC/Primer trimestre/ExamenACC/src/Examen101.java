import java.io.*;
import java.nio.charset.StandardCharsets;

public class Examen101 {
    public static void main(String[] args) throws IOException {
        /*
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\origen.txt");
        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String[] palabras = null;
        //String [] cadena = {"“Tras las míticas piezas de ajedrez de Montglane\n" +
               // "se oculta un secreto celosamente preservado durante siglos...”"};
        while ((linea=br.readLine())!=null)
            System.out.println(linea);
            //palabras = linea.split(" ");
        //File fichero2 = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\salida.txt");
        String ajedrez = "ajedrez";
        //String parchis = "parchis";
        String piezas = "piezas";
        //String fichas = "fichas";
        /*
        for (int i = 0; i <cadena.length ; i++) {
            if (cadena[i].equals(ajedrez)){
                cadena[i]=("parchis");
            }
            if(cadena[i].equals(piezas)){
                cadena[i]="fichas";
            }
        }
        FileWriter fw = new FileWriter(fichero);
        for (int i = 0; i <cadena.length ; i++) {
            fw.write(cadena[i]);
        }

         */
        // fw.close();
        File ficheroOrigen = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\origen.txt");
        File ficheroSalida = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\salida.txt");
        FileReader fr = new FileReader(ficheroOrigen);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter(ficheroSalida);
        String[] frase;
        try {
            String linea;
            while ((linea = br.readLine()) != null) {
                frase = linea.split(" ");

                for (int i = 0; i < frase.length; i++) {

                    if (frase[i].equals("ajedrez")) {
                        frase[i] = "parchis";
                    }
                    else if (frase[i].equals("piezas")) {
                        frase[i] = "fichas";
                    }
                    for (int o = 0; o < frase.length; o++) {
                        if (frase[o].equals("piezas")) {
                            frase[o] = "fichas";
                        }
                    }
                    System.out.print(frase[i] + " ");
                    fw.write(frase[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

