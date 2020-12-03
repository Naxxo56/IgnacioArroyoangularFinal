package EjerciciosEvaluables;

import java.util.ArrayList;
import java.util.List;

public class ListaDepartamentos {

    public ListaDepartamentos() {

    }

    private List<Departamento> listaDep = new ArrayList<Departamento>();

    public void add(Departamento departamento) {
        listaDep.add(departamento);
    }

    public List<Departamento> getDepartamentp() {
        return listaDep;
    }

}
