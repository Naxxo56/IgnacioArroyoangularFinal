package EjerciciosEvaluables;

import com.thoughtworks.xstream.XStream;
import java.io.*;

public class Ejercicio205 {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\departamentos.dat");
        FileInputStream fileIn = new FileInputStream(fichero);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        System.out.println("Comenzando proceso de creacion de XML");
        //Creamos objeto lista departamentos
        ListaDepartamentos listaDep = new ListaDepartamentos();
        //Creamos departamentos
        Departamento dep = null;

        try {
            //per=(Persona)objIn.readObject()
            //while(per!=null){}
            while ((dep = (Departamento) objIn.readObject()) != null) {
                //Añadimos el departamento a la lista
                listaDep.add(dep);
            }
        } catch (EOFException | ClassNotFoundException eof) {

        } finally {
            objIn.close();
        }
        System.out.println("...Xstream power...");
        //Usamos XSTREAM
        try {
            //Instanciamos XSTREAM
            XStream xstream = new XStream();
            /*
            En general, las etiquetas XML se corresponden con el nombre de los atributos de la clase
            pero se pueden cambiar utilizanmdo el metodo alias().
            En este caso, cambiamos el de la clase ListaDepartamento y el de la clase Departamento.
             */

            //Creamos las etiquetas para el fichero XML

            xstream.alias("Lista de departamentos", ListaDepartamentos.class);
            xstream.alias("Datos del departamento", Departamento.class);

            //  Quitar etiqueta "lista" (que es un atributo de la clase ListaDepartamentos)
            xstream.addImplicitCollection(ListaDepartamentos.class, "listaDep");

            //Generar el fichero Departamento.XML a partir de una lista de objetos.
            //Insertamos los objetos de un XML: toXML (objeto, OutputStream)

            xstream.toXML(listaDep, new FileOutputStream("C:\\Users\\digim\\Documents\\auxiliar_java\\Departamento.xml"));
            System.out.println("...Fichero XML  creado");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
