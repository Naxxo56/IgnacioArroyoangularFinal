package com.nacho.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.nacho.examenpmdm.utils.Restaurante;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerUno, spinnerDos, spinnerTres;
    private ArrayList<String> listaComida;
    private ArrayList<String> listaLocalidad;
    private ArrayList listaValoracion;
    private ArrayList<Restaurante> listaRestaurante;
    private ArrayAdapter adaptadorUno;
    private ArrayAdapter adaptadorDos;
    private ArrayAdapter adaptadorTres;
    private Button botonVerResultados;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarDatos();
        configurarSpinner();
        acciones();
    }

    private void rellenarDatos() {
        listaRestaurante.add(new Restaurante("Italiano1", "Madrid", 4, "Italiano", 9111));
        listaRestaurante.add(new Restaurante("Italiano2", "Alcobendas", 7, "Italiano", 9222));
        listaRestaurante.add(new Restaurante("Italiano3", "Pozuelo", 9, "Italiano", 9333));
        listaRestaurante.add(new Restaurante("Italiano4", "Majadahonda", 3, "Italiano", 9444));
        listaRestaurante.add(new Restaurante("Italiano5", "Madrid", 9, "Italiano", 9555));
        listaRestaurante.add(new Restaurante("Mediterraneo1", "Madrid", 6, "Mediterranea", 9666));
        listaRestaurante.add(new Restaurante("Mediterraneo2", "Alcobendas", 7, "Mediterranea", 9777));
        listaRestaurante.add(new Restaurante("Mediterraneo3", "Pozuelo", 5, "Mediterranea", 9123));
        listaRestaurante.add(new Restaurante("Mediterraneo4", "Majadahonda", 2, "Mediterranea", 9234));
        listaRestaurante.add(new Restaurante("Chino1", "Madrid", 10, "Chino", 9345));
        listaRestaurante.add(new Restaurante("Chino2", "Alcobendas", 5, "Chino", 9456));
        listaRestaurante.add(new Restaurante("Chino3", "Pozuelo", 6, "Chino", 9567));
        listaRestaurante.add(new Restaurante("Japones1", "Alcorcón", 10, "Japones", 8123));
        listaRestaurante.add(new Restaurante("Japones2", "Alcobendas", 5, "Japones", 7123));
        listaRestaurante.add(new Restaurante("Japones3", "Alcorcón", 6, "Japones", 6234));

        for (Restaurante restaurante : listaRestaurante) {
            listaComida.add(restaurante.getNombre());
            listaValoracion.add(restaurante.getValoracion());
            listaLocalidad.add(restaurante.getDireccion());
        }
    }

    private void configurarSpinner() {
        spinnerUno.setAdapter(adaptadorUno);
        spinnerDos.setAdapter(adaptadorDos);
        spinnerTres.setAdapter(adaptadorTres);
    }

    private void acciones() {
        botonVerResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),RestauranteActivity.class);
                startActivity(intent);
            }
        });

        spinnerUno.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerDos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerTres.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void instancias() {
        spinnerUno = findViewById(R.id.spinnerUno);
        listaComida = new ArrayList<>();
        adaptadorUno = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaComida);
        spinnerDos = findViewById(R.id.spinnerDos);
        listaLocalidad = new ArrayList<>();
        adaptadorDos = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaLocalidad);
        spinnerTres = findViewById(R.id.spinnerTres);
        listaValoracion = new ArrayList<>();
        adaptadorTres = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaValoracion);
        botonVerResultados = findViewById(R.id.botonVerResultados);
        listaRestaurante = new ArrayList<>();
    }
}