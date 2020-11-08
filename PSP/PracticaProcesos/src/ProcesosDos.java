import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ProcesosDos {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();
        String comando="CMD /C DIR";
        Process p=null;
        try
        {
            p=r.exec(comando);
            InputStream is=p.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(is));
            String linea;
            while ((linea = br.readLine())!=null)
                System.out.println(linea);
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        int exitVal;
        try{
            exitVal=p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
