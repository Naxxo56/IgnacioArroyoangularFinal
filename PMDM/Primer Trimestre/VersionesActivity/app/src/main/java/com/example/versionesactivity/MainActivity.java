package com.example.versionesactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.versionesactivity.Adaptadores.AdaptadorVersiones;
import com.example.versionesactivity.Utils.Version;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdaptadorVersiones.OnVersionListener {

    RecyclerView recyclerVersiones;
    AdaptadorVersiones adaptador;
    ArrayList<Version> listaVersiones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        rellenarVersiones();
    }

    private void rellenarVersiones() {
        recyclerVersiones.setAdapter(adaptador);
        recyclerVersiones.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.VERTICAL, false));

        listaVersiones.add(new Version("Oreo", "1", "3",
                "nvegmgwerg", R.drawable.android8));
        listaVersiones.add(new Version("Oreo", "1", "3",
                "nvegmgwerg", R.drawable.android8));
        listaVersiones.add(new Version("Oreo", "1", "3",
                "nvegmgwerg", R.drawable.android8));
        listaVersiones.add(new Version("Oreo", "1", "3",
                "nvegmgwerg", R.drawable.android8));
        listaVersiones.add(new Version("Oreo", "1", "3",
                "nvegmgwerg", R.drawable.android8));
        listaVersiones.add(new Version("Oreo", "1", "3",
                "nvegmgwerg", R.drawable.android8));

        adaptador.notifyDataSetChanged();
    }

    private void instancias() {
        recyclerVersiones = findViewById(R.id.recycler_versiones);
        listaVersiones = new ArrayList<>();
        adaptador = new AdaptadorVersiones(listaVersiones, this);
    }

    @Override
    public void onVersionSelected(Version version) {
        Intent intent = new Intent();
        intent.putExtra("version", version);
        startActivity(intent);
    }
}