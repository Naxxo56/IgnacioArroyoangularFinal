package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerBebidas;
import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerHamburguesas;
import com.borja.t3_elementos.utils.Bebida;
import com.borja.t3_elementos.utils.Cafe;
import com.borja.t3_elementos.utils.Hamburguesa;

import java.util.ArrayList;

public class RecyclerBebidasActivity extends AppCompatActivity implements AdaptadorRecyclerBebidas.OnBotonRecyclerListener {

    private RecyclerView recyclerView;
    ArrayList<Bebida> listaBebidas;
    AdaptadorRecyclerBebidas adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_bebidas);
        instancias();
        rellenarLista();
    }

    private void rellenarLista() {
        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));
        listaBebidas.add(new Bebida("CocaCola", 10, R.drawable.coca));
        listaBebidas.add(new Bebida("Fanta", 1, R.drawable.fanta));
        listaBebidas.add(new Bebida("Nestea", 0, R.drawable.nestea));
        listaBebidas.add(new Bebida("Tonica", 11, R.drawable.sweps));
        listaBebidas.add(new Bebida("Trina", 15, R.drawable.trinaranju));
        listaBebidas.add(new Bebida("Sprite", 14, R.drawable.sprite));
        adaptador.notifyDataSetChanged();
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_bebidas);
        listaBebidas = new ArrayList<>();
        adaptador = new AdaptadorRecyclerBebidas(RecyclerBebidasActivity.this, listaBebidas);
    }

    @Override
    public void onBebidaSelected(Bebida bebida) {
        Toast.makeText(getApplicationContext(),"Bebida "+ bebida.getNombre() + " con " + bebida.getCalorias()+" calorias",Toast.LENGTH_SHORT).show();
        Log.v("Bebida", bebida.getNombre() + " con " + bebida.getCalorias()+" calorias");
    }

    @Override
    public void onBebidaLongClick() {
        Toast.makeText(getApplicationContext(), "Pulsado largo", Toast.LENGTH_SHORT).show();
    }
}