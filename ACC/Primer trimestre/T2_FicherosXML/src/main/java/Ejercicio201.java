import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class Ejercicio201 {
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        File fichero = new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\FichPersona.dat");
        FileInputStream fileIn = new FileInputStream(fichero);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        Persona persona;
        Object objeto;
        //Creamos una instancia de DocumentBuilderFactory para construir el parser
        //Puede producir excepcion ParserConfigurationException
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        //Creamos un documento vacio, de nombre document con el nodo raiz PERSONA
        DocumentBuilder builder = docFactory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Persona", null);
        document.setXmlVersion("1.0");

        try {
            //Leemos persona
            while ((objeto = objIn.readObject()) != null) {
                persona = (Persona) objeto;
                System.out.println("Persona" + persona.getNombre() + "tiene" + persona.getEdad() + "años");
                //Creacion de un nodo persona (raiz)
                Element raiz = document.createElement("persona");
                //Asignamos el nodo a la raiz del documento
                document.getDocumentElement().appendChild(raiz);
                //Creacion de los hijos del nodo raiz
                //Añadimos nombre
                crearElemento("nombre", persona.getNombre().trim(), raiz, document);
                //Añadimos edad
                crearElemento("edad", Integer.toString(persona.getEdad()), raiz, document);
            }
        } catch (EOFException | ClassNotFoundException eof) {

        }
        //Creamos la fuente XML a partir del documento
        Source source = new DOMSource(document);

        //Asignamos el resultado al fichero EmpleadosDOM.XML
        Result result = new StreamResult(new File("C:\\Users\\Usuario DAM2\\Documents\\auxiliar_java\\PersonasDOM.XML.dat"));

        //Se obtiene un TransformerFactory para realizar la transformacion del documento a fichero
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        //Para mostrar el documento por pantalla,podemos especidicar como resultado el canal de salida
        Result console = new StreamResult(System.out);
        transformer.transform(source, result);
        objIn.close();
    }

    public static void crearElemento(String datoPersona, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoPersona);//creamos hijo
        Text text = document.createTextNode(valor);//asignamos valor
        raiz.appendChild(elem);//ligamos el elemento hijo al raiz
        elem.appendChild(text);//ligamos el valor al elemento hijo
        System.out.println("Generando..." + datoPersona + "con valor:" + valor);
    }
}
