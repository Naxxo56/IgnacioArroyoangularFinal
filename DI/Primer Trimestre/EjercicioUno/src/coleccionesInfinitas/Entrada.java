package coleccionesInfinitas;

import Herencia.Alumno;
import Herencia.Persona;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class Entrada {
    public static void main(String[] args) {
        /*

        String[] palabraPosiciones = new String[10];
        String[] palabraElementos = {"Uno", "Dos", "Tres"};
        palabraElementos[0] = "Valor";

        String[][] matriz = new String[2][3];
        String[][] matrizDatos = {{"uno", "dos"}, {"tres", "cuatro", "cinco"}};


        for (int i = 0; i < palabraElementos.length; i++) {
            System.out.println(palabraElementos[i]);
        }
        for (String item : palabraElementos) {
            System.out.println(item);
        }

        for (int i = 0; i < matrizDatos.length; i++) {
            for (int j = 0; j < matrizDatos[i].length ; j++) {
                System.out.println(matrizDatos[i][j]);
            }
        }
        for (String[]item:matrizDatos) {
            //recorre las filas
            for (String itemFinal:item) {
                System.out.println(itemFinal);
            }
        }


        ArrayList<String> listaPalabras = new ArrayList();
        listaPalabras.add(1,"algo");
        listaPalabras.add("algo nuevo");
        listaPalabras.get(0);
        listaPalabras.remove(1);
        listaPalabras.clear();
        listaPalabras.size();

        for (int i = 0; i < listaPalabras.size(); i++) {
            System.out.println(listaPalabras.get(i));
        }
        for (String item:listaPalabras) {
            System.out.println(item);
        }

        */

        Hashtable<String, Persona> listaPersonas = new Hashtable();
         /*
        listaPersonas.clear();
        listaPersonas.size();
        listaPersonas.remove(a1.getDni());
        listaPersonas.containsKey("12314a");
        listaPersonas.keys(); //todas las claves para recorrer
        listaPersonas.values(); //todos los elementos para recorrer
           */

        Alumno a1 = new Alumno("nacho", "arroyo", "1234", 4);
        Alumno a2 = new Alumno("ad", "arroyo", "2345", 10);
        Alumno a3 = new Alumno("ew", "arroyo", "3456", 3);
        Alumno a4 = new Alumno("ttq", "arroyo", "4567", 9);
        Alumno a5 = new Alumno("eqwe", "arroyo", "5678", 10);
        listaPersonas.put(a1.getDni(), a1);
        listaPersonas.put(a2.getDni(), a2);
        listaPersonas.put(a3.getDni(), a3);
        listaPersonas.put(a4.getDni(), a4);
        listaPersonas.put(a5.getDni(), a5);

        System.out.println(listaPersonas.size());
        Persona pBorrada= listaPersonas.remove("4567");
        if(pBorrada!=null){
            System.out.println("La persona borrada se llama "+pBorrada.getNombre());
        }else{
            System.out.println("No se ha encontrado la persona");
        }
        System.out.println(listaPersonas.size());

       Persona pEncontrada =  listaPersonas.get("1234");
        if(pEncontrada!=null){
            System.out.println("La persona encontrada se llama "+pEncontrada.getNombre());
        }else{
            System.out.println("No se ha encontrado la persona");
        }

       Enumeration<String> listaClaves= listaPersonas.keys();
        //k1,k2,k3,k3
        //Forma de recorrer enum-->

        while(listaClaves.hasMoreElements()){
            String key = listaClaves.nextElement();
            Persona persona = listaPersonas.get(key);
            System.out.println(persona.getNombre());
        }
        while(listaClaves.hasMoreElements()){
            String key = listaClaves.nextElement();
            Alumno alumno = (Alumno)listaPersonas.get(key);
            if(persona.getMedia()==10){
                System.out.println(persona.getNombre());
            }
        }

        Collection<Persona> elementos = listaPersonas.values();
        for (Persona persona:elementos) {
            System.out.println(persona.getNombre());
        }
    }
}
