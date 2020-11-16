import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Convertidor {
    public static void main(String[] args) throws FileNotFoundException {
        //Se definen los fihceros de entrada

        String hojaEstilo = "C:\\Users\\pc\\Documents\\auxiliar_java\\nuevodir\\alumnosplantilla.xsl";
        String datosAlumno = "C:\\Users\\pc\\Documents\\auxiliar_java\\nuevodir\\alumnos.XML";
        //Definimos cual va a ser nuestro STREAM de salida
        File pageHTML = new File("C:\\Users\\pc\\Documents\\auxiliar_java\\nuevodir\\mipagina.html");
        FileOutputStream fileOS =  new FileOutputStream(pageHTML);
        //Fuente XSL
        Source estilo = new StreamSource(hojaEstilo);
        //Fuente XML
        Source datos = new StreamSource(datosAlumno);
        //Resultado de la transformacion
        Result result = new StreamResult(fileOS);
        try {
            Transformer transformer = TransformerFactory.newInstance().newTransformer(estilo);
            //Obtenemos el XML identificaado fuente de datos y resultado
            transformer.transform(datos,result);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        try {
            fileOS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
