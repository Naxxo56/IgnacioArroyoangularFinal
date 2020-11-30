package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerEnsaladas;
import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerHamburguesas;
import com.borja.t3_elementos.utils.Ensalada;
import com.borja.t3_elementos.utils.Hamburguesa;

import java.util.ArrayList;

public class RecyclerEnsaladasActivity extends AppCompatActivity implements AdaptadorRecyclerEnsaladas.OnBotonRecyclerListener {

    private RecyclerView recyclerView;
    ArrayList<Ensalada> listaEnsaladas;
    AdaptadorRecyclerEnsaladas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_ensaladas);
        instancias();
        rellenarLista();
    }

    private void rellenarLista() {
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        listaEnsaladas.add(new Ensalada("Ensalada Cesar",126, R.drawable.cesar));
        listaEnsaladas.add(new Ensalada("Ensalada de la huerta",123, R.drawable.huerta));
        listaEnsaladas.add(new Ensalada("Ensalada queso de cabra",130, R.drawable.cabra));
        adaptador.notifyDataSetChanged();
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_ensaladas);
        listaEnsaladas = new ArrayList<>();
        adaptador = new AdaptadorRecyclerEnsaladas(RecyclerEnsaladasActivity.this,listaEnsaladas);
    }

    @Override
    public void onEnsaladaSelected(Ensalada ensalada) {
        Toast.makeText(getApplicationContext(),"Ensalada "+ ensalada.getNombre()+ " con "+ensalada.getCalorias()+" calorias",Toast.LENGTH_SHORT).show();
        Log.v("Ensalada",ensalada.getNombre()+ " con "+ensalada.getCalorias()+" calorias");
    }

    @Override
    public void onEnsaladaLongClick() {
        Toast.makeText(getApplicationContext(),"Pulsado largo",Toast.LENGTH_SHORT).show();
    }
}