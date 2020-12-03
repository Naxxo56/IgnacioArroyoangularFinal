package com.nacho.ignacioarroyomayoexamenfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.nacho.ignacioarroyomayoexamenfinal.adaptadores.AdaptadorRecycler;
import com.nacho.ignacioarroyomayoexamenfinal.adaptadores.AdaptadorSpinner;
import com.nacho.ignacioarroyomayoexamenfinal.utils.Clase;
import com.nacho.ignacioarroyomayoexamenfinal.utils.Elementos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaRecycler;
    private AdaptadorRecycler adaptadorRecycler;
    private ArrayList<Elementos> listaElementos;

    private Spinner spinner;
    private ArrayList<Clase> listaClase;
    private AdaptadorSpinner adaptadorSpinner;

    /*
    private Spinner spinner;
    private ArrayAdapter adaptadorUno;
    private ArrayList<String> lista;

     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        //rellenarDatos();
        rellenarLista();
        rellenarRecycler();
    }

    private void rellenarLista() {
        spinner.setAdapter(adaptadorSpinner);
        listaClase.add(new Clase("Futbol"));
        listaClase.add(new Clase("Juegos"));
        listaClase.add(new Clase("Series"));
        adaptadorSpinner.notifyDataSetChanged();
    }
/*
    private void rellenarDatos() {
        spinner.setAdapter(adaptadorUno);
        lista.add("Futbol");
        lista.add("Series");
        lista.add("Juegos");
    }

 */

    private void instancias() {
        listaRecycler = findViewById(R.id.recycler);
        listaElementos = new ArrayList();
        adaptadorRecycler = new AdaptadorRecycler(listaElementos,getApplicationContext());
        //spinner=findViewById(R.id.spinner_principal);
        //lista = new ArrayList<>();
        //adaptadorUno = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, lista);
        spinner = findViewById(R.id.spinner_principal);
        listaClase = new ArrayList();
        adaptadorSpinner = new AdaptadorSpinner(listaClase,getApplicationContext());
    }

    private void rellenarRecycler() {
        listaRecycler.setAdapter(adaptadorRecycler);

        listaRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        listaElementos.add(new Elementos("Messi", "FC. Barcelona", R.drawable.messi));
        listaElementos.add(new Elementos("Ronaldo", "Brasil", R.drawable.ronaldo));
        listaElementos.add(new Elementos("Maradona", "Argentina", R.drawable.maradona));
        listaElementos.add(new Elementos("Zidane", "Francia", R.drawable.zidane));
        listaElementos.add(new Elementos("Metal Gear", "Sigilo", R.drawable.metal));
        listaElementos.add(new Elementos("Gran Turismo", "Coches", R.drawable.gt));
        listaElementos.add(new Elementos("God Of War", "Plataformas", R.drawable.god));
        listaElementos.add(new Elementos("Final Fantasy X", "Rol", R.drawable.ffx));
        listaElementos.add(new Elementos("Stranger Things", "Fantastica", R.drawable.stranger));
        listaElementos.add(new Elementos("Lost", "Fantastica", R.drawable.lost));
        listaElementos.add(new Elementos("Juego de tronos", "Histórica", R.drawable.tronos));
        listaElementos.add(new Elementos("La casa de papel", "Accion", R.drawable.papel));

        adaptadorRecycler.notifyDataSetChanged();
    }
}