package Colecciones;

import java.util.ArrayList;

public class Entrada {
    public static void main(String[] args) {
        //colecciones infinitas ---> Arrays
        String [] palabras = new String[5];
        palabras[0]="as";
        palabras[1]="asd";
        palabras[2]="ase";
        palabras[3]="aaws";
        palabras[4]="aset";

        ArrayList<String>listaPalabras = new ArrayList();
        if(listaPalabras.add("primera palabra")){
            System.out.println("Elemento añadido");
        }else{
            System.out.println("No añadido");
        }

        // este metodo de eliminacion por posicion te muestra el elemento borrado
        System.out.println(listaPalabras.remove(0));




     }
}
