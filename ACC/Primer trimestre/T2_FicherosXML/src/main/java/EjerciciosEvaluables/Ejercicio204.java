package EjerciciosEvaluables;

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

public class Ejercicio204 {
    public static void main(String[] args) throws IOException, ParserConfigurationException, TransformerException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\departamentos.dat");

        String nombre, localidad;
        int id;

        FileInputStream fileIn = new FileInputStream(fichero);
        ObjectInputStream objIn = new ObjectInputStream(fileIn);

        Departamento departamento;
        Object objeto;
        //Creamos una instancia de DocumentBuilderFactory para construir el parser
        //Puede producir excepcion ParserConfigurationException
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        //Creamos un documento vacio, de nombre document con el nodo raiz DEPARTAMENTO
        DocumentBuilder builder = docFactory.newDocumentBuilder();
        DOMImplementation implementation = builder.getDOMImplementation();
        Document document = implementation.createDocument(null, "Departamento", null);
        document.setXmlVersion("1.0");

        try {
            //Leemos persona
            while ((objeto = objIn.readObject()) != null) {
                departamento = (Departamento) objeto;
                System.out.println("Departamento con nombre:" + departamento.getNombre() + "cuya localidad es" + departamento.getLocalidad() + "con un id de:" + departamento.getId());
                //Creacion de un nodo departamento (raiz)
                Element raiz = document.createElement("Departamento");
                //Asignamos el nodo a la raiz del documento
                document.getDocumentElement().appendChild(raiz);
                //Creacion de los hijos del nodo raiz

                crearElemento("nombre", departamento.getNombre().trim(), raiz, document);
                crearElemento("localidad", departamento.getLocalidad().trim(), raiz, document);
                crearElemento("id", Integer.toString(departamento.getId()), raiz, document);
            }
        } catch (EOFException | ClassNotFoundException eof) {

        }
        //Creamos la fuente XML a partir del documento
        Source source = new DOMSource(document);

        //Asignamos el resultado al fichero DepartamentoDOM.XML
        Result result = new StreamResult(new File("C:\\Users\\digim\\Documents\\auxiliar_java\\departamentoDOM.XML.dat"));

        //Se obtiene un TransformerFactory para realizar la transformacion del documento a fichero
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.transform(source, result);
        //Para mostrar el documento por pantalla,podemos especidicar como resultado el canal de salida
        Result console = new StreamResult(System.out);
        transformer.transform(source, result);
        objIn.close();
    }

    public static void crearElemento(String dato, String valor, Element raiz, Document document) {
        Element elem = document.createElement(dato);//creamos hijo
        Text text = document.createTextNode(valor);//asignamos valor
        raiz.appendChild(elem);//ligamos el elemento hijo al raiz
        elem.appendChild(text);//ligamos el valor al elemento hijo
        System.out.println("Generando..." + dato + " con valor: " + valor);
    }
}
