package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerHamburguesas;
import com.borja.t3_elementos.utils.Hamburguesa;

import java.util.ArrayList;

public class RecyclerHamburguesasActivity extends AppCompatActivity implements AdaptadorRecyclerHamburguesas.OnBotonRecyclerListener{

    private RecyclerView recyclerView;
    ArrayList<Hamburguesa> listaHamburguesa;
    AdaptadorRecyclerHamburguesas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_hamburguesas);
        instancias();
        rellenarLista();
    }


    private void rellenarLista() {

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        listaHamburguesa.add(new Hamburguesa("Big Mac","Ternera",320,R.drawable.bg));
        listaHamburguesa.add(new Hamburguesa("Double Big Mac","Ternera",430, R.drawable.download1));
        listaHamburguesa.add(new Hamburguesa("McPollo","Pollo",431, R.drawable.download2));
        listaHamburguesa.add(new Hamburguesa("American Style Chicken","Pollo",203,R.drawable.download3));
        listaHamburguesa.add(new Hamburguesa("Signature Collection","Ternera",456,R.drawable.download4));
        listaHamburguesa.add(new Hamburguesa("McRoyal Deluxe","Ternera",432,R.drawable.download5));
        listaHamburguesa.add(new Hamburguesa("CBO","Pollo",192,R.drawable.download6));
        listaHamburguesa.add(new Hamburguesa("Cuarto de libra","Ternera",245,R.drawable.download7));

        adaptador.notifyDataSetChanged();

    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_hamburguesas);
        listaHamburguesa = new ArrayList<>();
        adaptador = new AdaptadorRecyclerHamburguesas(RecyclerHamburguesasActivity.this,listaHamburguesa);
    }

    @Override
    public void onCocheSelected(Hamburguesa hamburguesa) {
        Toast.makeText(getApplicationContext(),"Hamburguesa: "+hamburguesa.getNombre()+" con carne de "+hamburguesa.getCarne()+" y con "+hamburguesa.getCalorias()+" calorias",Toast.LENGTH_SHORT).show();
        Log.v("Hamburguesa",hamburguesa.getNombre()+" con carne de: "+hamburguesa.getCarne()+" y con "+hamburguesa.getCalorias()+" calorias");

    }

    @Override
    public void onCocheLongClick() {
        Toast.makeText(getApplicationContext(),"Pulsado largo",Toast.LENGTH_SHORT).show();
    }
}