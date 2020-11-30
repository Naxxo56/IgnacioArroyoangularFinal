package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerCafe;
import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerHamburguesas;
import com.borja.t3_elementos.utils.Cafe;
import com.borja.t3_elementos.utils.Hamburguesa;

import java.util.ArrayList;

public class RecyclerCafeActivity extends AppCompatActivity implements AdaptadorRecyclerCafe.OnBotonRecyclerListener {

    private RecyclerView recyclerView;
    ArrayList<Cafe> listaCafe;
    AdaptadorRecyclerCafe adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_cafe);
        instancias();
        rellenarLista();
    }

    private void rellenarLista() {
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        listaCafe.add(new Cafe("Espresso",121,R.drawable.espres));
        listaCafe.add(new Cafe("Capuccino",430, R.drawable.capuccino));
        listaCafe.add(new Cafe("Con leche",431, R.drawable.leche));
        listaCafe.add(new Cafe("Americano",203,R.drawable.americano));
        listaCafe.add(new Cafe("Vienes",12,R.drawable.vienes));

        adaptador.notifyDataSetChanged();
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_cafe);
        listaCafe = new ArrayList<>();
        adaptador = new AdaptadorRecyclerCafe(RecyclerCafeActivity.this,listaCafe);
    }

    @Override
    public void onCafeSelected(Cafe cafe) {
        Toast.makeText(getApplicationContext(),"Cafe "+cafe.getNombre()+ " con "+cafe.getCalorias()+" calorias",Toast.LENGTH_SHORT).show();
        Log.v("Cafe",cafe.getNombre()+ " con  "+cafe.getCalorias()+ " calorias");
    }

    @Override
    public void onCafeLongClick() {
        Toast.makeText(getApplicationContext(),"Pulsado largo",Toast.LENGTH_SHORT).show();
    }
}