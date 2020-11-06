import com.thoughtworks.xstream.XStream;

import java.io.*;

public class EscribirPersonas {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\FichPersona.dat");
        FileInputStream fileIn = new FileInputStream(fichero);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        System.out.println("Comenzando proceso de creacion de XML");
        //Creamos objeto lista personas
        ListaPersonas listaPer = new ListaPersonas();
        //Creamos personas
        Persona per = null;

        try {
            //per=(Persona)objIn.readObject()
            //while(per!=null){}
            while ((per = (Persona) objIn.readObject()) != null) {
                //Añadimos la persona a la lista
                listaPer.add(per);
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
            En este caso, cambiamos el de la clase ListaPersona y el de la clase Persona.
             */

            //Creamos las etiquetas para el fichero XML

            xstream.alias("ListaPersonasMunicipio", ListaPersonas.class);
            xstream.alias("DatosPersona", Persona.class);

            //  Quitar etiqueta "lista" (que es un atributo de la clase ListaPersonas)
            xstream.addImplicitCollection(ListaPersonas.class, "lista");

            //Generar el fichero Personas.XML a partir de una lista de objetos.
            //Insertamos los objetos de un XML: toXML (objeto, OutputStream)

            xstream.toXML(listaPer, new FileOutputStream("C:\\Users\\digim\\Documents\\auxiliar_java\\Persona.xml"));
            System.out.println("...Fichero XML  creado");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
