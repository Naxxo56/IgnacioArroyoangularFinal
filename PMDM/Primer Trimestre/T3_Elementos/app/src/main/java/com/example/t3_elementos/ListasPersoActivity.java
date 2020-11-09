package com.example.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.t3_elementos.Adaptadores.AdaptadorLista;
import com.example.t3_elementos.utils.Coche;

import java.util.ArrayList;
import java.util.List;

public class ListasPersoActivity extends AppCompatActivity {

    private Spinner spinnerMarcas;
    private ListView listViewCoches;

    private ArrayList<Coche> listaCoches;
    private ArrayList listaMarcas;

    private AdaptadorLista adaptadorListaPerso;
    private ArrayAdapter adaptadorSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas_perso);
        instancias();
        rellenarListas();
    }

    private void rellenarListas() {

        spinnerMarcas.setAdapter(adaptadorSpinner);
        listaMarcas.add("Ford");
        listaMarcas.add("Seat");
        listaMarcas.add("Volskwagen");
        listaMarcas.add("Mercedes");
        listaMarcas.add("Audi");
        listaMarcas.add("Volvo");
        adaptadorSpinner.notifyDataSetChanged();

        listViewCoches.setAdapter(adaptadorListaPerso);
        listaCoches.add(new Coche("Focus", "Ford", 100, 0));
        listaCoches.add(new Coche("C90", "Volvo", 200, 0));
        listaCoches.add(new Coche("C60", "Volvo", 250, 0));
        listaCoches.add(new Coche("A3", "Audi", 120, 0));
        listaCoches.add(new Coche("A4", "Audi", 120, 0));
        listaCoches.add(new Coche("A6", "Audi", 120, 0));
        listaCoches.add(new Coche("A3", "Audi", 120, 0));
        listaCoches.add(new Coche("C220", "Mercedes", 120, 0));
        listaCoches.add(new Coche("CLA220", "Mercedes", 120, 0));
        listaCoches.add(new Coche("C220", "Mercedes", 120, 0));
        listaCoches.add(new Coche("Leon", "Leon", 90, 0));
        listaCoches.add(new Coche("Golf", "Golf", 100, 0));
        listaCoches.add(new Coche("Fiesta", "Scenic", 200, 0));
        adaptadorListaPerso.notifyDataSetChanged();
    }

    private void instancias() {
        spinnerMarcas = findViewById(R.id.spinner_perso);
        listViewCoches = findViewById(R.id.lista_perso);

        listaCoches = new ArrayList();
        listaMarcas = new ArrayList();

        adaptadorSpinner = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaMarcas);
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        adaptadorListaPerso = new AdaptadorLista(listaCoches, getApplicationContext());
    }
}