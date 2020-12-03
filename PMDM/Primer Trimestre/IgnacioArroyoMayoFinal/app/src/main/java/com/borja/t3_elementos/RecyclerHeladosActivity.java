package com.borja.t3_elementos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerHamburguesas;
import com.borja.t3_elementos.adaptadores.AdaptadorRecyclerHelados;
import com.borja.t3_elementos.utils.Hamburguesa;
import com.borja.t3_elementos.utils.Helado;

import java.util.ArrayList;

public class RecyclerHeladosActivity extends AppCompatActivity implements AdaptadorRecyclerHelados.OnBotonRecyclerListener{

    private RecyclerView recyclerView;
    ArrayList<Helado> listaHelados;
    AdaptadorRecyclerHelados adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_helados);
        instancias();
        rellenarLista();
    }

    private void rellenarLista() {

        recyclerView.setAdapter(adaptador);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
        listaHelados.add(new Helado("McFlurry oreo",520,R.drawable.oreo));
        listaHelados.add(new Helado("McFlurry twix",433, R.drawable.twix));
        listaHelados.add(new Helado("McFlurry msm",531, R.drawable.msm));
        listaHelados.add(new Helado("McFlurry fresa",403,R.drawable.fresa));
        adaptador.notifyDataSetChanged();
    }

    private void instancias() {
        recyclerView = findViewById(R.id.recycler_helados);
        listaHelados = new ArrayList<>();
        adaptador = new AdaptadorRecyclerHelados(RecyclerHeladosActivity.this,listaHelados);
    }

    @Override
    public void onHeladoSelected(Helado helado) {
        Toast.makeText(getApplicationContext(),"Helado: "+ helado.getNombre()+ " con "+helado.getCalorias()+" calorias",Toast.LENGTH_SHORT).show();
        Log.v("Helado",helado.getNombre()+ " con "+helado.getCalorias()+" calorias");
    }

    @Override
    public void onHeladoLongClick() {
        Toast.makeText(getApplicationContext(),"Pulsado largo",Toast.LENGTH_SHORT).show();
    }
}