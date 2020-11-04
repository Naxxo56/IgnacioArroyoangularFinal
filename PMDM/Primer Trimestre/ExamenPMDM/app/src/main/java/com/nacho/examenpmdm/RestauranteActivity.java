package com.nacho.examenpmdm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.nacho.examenpmdm.utils.Restaurante;

public class RestauranteActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listaRestaurantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);
        //instancias();
        //rellenarDatos();
        //acciones();
    }

    private void rellenarDatos() {
        Bundle bundle = getIntent().getExtras();
        String tipoRec = bundle.getString("tipo");
        String ubicacionRec = bundle.getString("ubicacion");
        int valoracionRec = bundle.getInt("valoracion");
    }



    private void acciones() {
        listaRestaurantes.setOnItemClickListener(this);
    }

    private void instancias() {
        listaRestaurantes.findViewById(R.id.listaRestaurantes);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

    }
}