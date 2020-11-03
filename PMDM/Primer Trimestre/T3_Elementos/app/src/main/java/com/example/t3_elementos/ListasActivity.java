package com.example.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.t3_elementos.utils.Coche;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView lista;
    ArrayList<Coche> listaDatos;
    ArrayAdapter adaptadorLista;
    private Spinner spinnerCoches;
    ArrayAdapter adaptadorSpinner;
    ArrayList listaSpinnerCoches;
    private Button botonFiltrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listas);
        instancias();
        rellenarDatos();
        acciones();
    }

    private void acciones() {
        lista.setOnItemClickListener(this);
        botonFiltrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cvSelect = Integer.valueOf(adaptadorSpinner.getItem(spinnerCoches.getSelectedItemPosition()).toString());
                listaDatos.clear();
                adaptadorLista.notifyDataSetChanged();
                for (Coche coche : listaDatos) {
                    if(coche.getCv()>=cvSelect){
                        listaDatos.add(coche);
                        adaptadorLista.notifyDataSetChanged();
                    }
                }
            }
        });
    }

    private void rellenarDatos() {
        listaDatos.add(new Coche("Focus", "Ford", 100, 5460));
        listaDatos.add(new Coche("Seat", "Ford", 200, 530));
        listaDatos.add(new Coche("Leon", "Ford", 1020, 502));
        listaDatos.add(new Coche("Laguna", "Ford", 1030, 510));
        listaDatos.add(new Coche("Ibiza", "Ford", 1500, 507));
        listaDatos.add(new Coche("Bugga", "Ford", 1600, 506));
        listaDatos.add(new Coche("Focus", "Ford", 1080, 580));
    }

    private void instancias() {
        //instancio
        lista = findViewById(R.id.lista_simple);
        listaDatos = new ArrayList();
        adaptadorLista = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listaDatos);
        //seteo
        lista.setAdapter(adaptadorLista);
        //instancio
        spinnerCoches = findViewById(R.id.spinner_lista_coches);
        listaSpinnerCoches = new ArrayList();
        //añado los datos al spinner mediante un for de 10 en 10
        for (int i = 60; i < 301; i += 10) {
            listaSpinnerCoches.add(i);
            adaptadorSpinner.notifyDataSetChanged();
        }
        adaptadorSpinner = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaSpinnerCoches);
        //seteo
        spinnerCoches.setAdapter(adaptadorSpinner);
        //mejora la vista del spinner
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        botonFiltrar.findViewById(R.id.boton_filtrar);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        //Log.v("lista",String.valueOf(position));
        Coche coche = (Coche) adaptadorLista.getItem(position);
        //Log.v("lista", String.valueOf(coche.getCv()));
        Toast.makeText(getApplicationContext(), String.valueOf(coche.getCv()), Toast.LENGTH_SHORT).show();
    }
}