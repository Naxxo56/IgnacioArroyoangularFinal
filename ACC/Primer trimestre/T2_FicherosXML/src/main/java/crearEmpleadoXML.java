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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class crearEmpleadoXML {
    public static void main(String[] args) throws IOException {
        File fichero = new File("C:\\Users\\digim\\Documents\\auxiliar_java\\Aleatorios.dat");
        RandomAccessFile rafile = new RandomAccessFile(fichero,"r");
        //declaramos las variables contenidas
        int id,departamento;
        double salario;
        char[]nombre = new char[10];
        char aux;
        String apellido;
        //Acceso aleatorio, variable para situar el puntero del fichero
        long posicion =0;
        //Creamos una instancia de DocumentBuilderFactory para construir el parser
        //Puede producir excepcion ParserConfigurationExcepcion
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        try{
            //Creamos un documento vacío, de nombre document, con el nodo raíz EMPLEADOS
            DocumentBuilder builder = docFactory.newDocumentBuilder();
            DOMImplementation implementation = builder.getDOMImplementation();
            //E.g, createDocument(namespaceURI,qualifiedNameStr,documentType);
            Document document = implementation.createDocument(null,"Empleados",null);
            document.setXmlVersion("1.0"); //Asignamos version de XML
            //Una vez creado el documento, recorremos el fichero con los datos del empleado y por cada
            //registro creamos un nodo empleado con 4 hijos(id,apellido,dep,salario)
            //cada nodo hijo tendra su valor(e.g,1,FERNANDEZ,10,1000.45)
            //el nombre de la etiquita en XML
            for (;;){
                //nos posicionamos en el lugar del fichero adecuado
                rafile.seek(posicion);
                //obtenemos el id del empleado
                id =rafile.readInt();
                //obtenemos el nombre del empleado
                for (int i = 0; i <nombre.length ; i++) {
                    aux = rafile.readChar();//Recorremos 1 a 1 los caracteres del nombre del empleado
                    nombre[i] = aux;//asinacion a char[]
                }
                //convertimos a String el arrayt con nombre
                apellido=new String(nombre);
                //obtenemos el departamento
                departamento = rafile.readInt();
                //obtenemos salario
                salario=rafile.readDouble();

                //el id es valido si es mayor que 1
                if(id>0){
                    //Creacion de uin nodo empleado
                    Element raiz = document.createElement("empleado");
                    //asignamos nodo
                    document.getDocumentElement().appendChild(raiz);
                    //creacion de hijos

                    //añadimos id
                    CrearElemento("id",Integer.toString(id),raiz,document);
                    //añadimos apellido
                    CrearElemento("apellido",apellido.trim(),raiz,document);
                    //añadimos departamento
                    CrearElemento("departamento",Integer.toString(departamento),raiz,document);
                    //añadimos salario
                    CrearElemento("salario",Double.toString(salario),raiz,document);
                }
                //establecemos nuevo punto de lectura para el siguiente registro
                posicion+=36;
                //si llegamos al finel del fichero salimos del for
                if(rafile.getFilePointer()==rafile.length()){
                    break;
                }
            }
            //Creamos la fuente XML a partir del documento
            Source source = new DOMSource(document);
            //asignamos el resultado al fichero EMPLEADOSDOM.xml
            Result result = new StreamResult(new java.io.File("C:\\Users\\digim\\Documents\\" +
                    "auxiliar_java\\EmpleadosDOM.XML"));
            //se obtiene un transformerFactory para realizar la transformacion del documento a fichero
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source,result);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        finally {
            rafile.close();
        }

    }

    private static void CrearElemento(String datoEmpleado, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmpleado);//creamos hijo
        Text text = document.createTextNode(valor);//asignamos valor
        raiz.appendChild(elem);//ligamos el elemento hijo al raiz
        elem.appendChild(text);//ligamos el valor al elemento hijo
    }
}
