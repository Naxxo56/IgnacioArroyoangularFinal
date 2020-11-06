import java.util.ArrayList;
import java.util.List;

public class ListaPersonas {
    public ListaPersonas() {

    }

    private List<Persona> lista = new ArrayList<Persona>();

    //Añadimos persona
    public void add(Persona per) {
        lista.add(per);
    }

    //Devolvemos la listas personas
    public List<Persona> getListaPersonas() {
        return lista;
    }

}
