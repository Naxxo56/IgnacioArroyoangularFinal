package com.example.fragmentscorreo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.fragmentscorreo.adaptadores.AdaptadorTecnologiasRecycler;
import com.example.fragmentscorreo.dialogos.DialogoAddTecnologia;
import com.example.fragmentscorreo.fragments.FragmentListaTecnologias;
import com.example.fragmentscorreo.utils.Tecnologias;

public class TecnologiasActivity extends AppCompatActivity implements DialogoAddTecnologia.OnDialogoAddListener {

    private FragmentManager fm;
    private FragmentTransaction ft;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologias);
        instancias();
        personalizarToolbar();



        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.replace(R.id.sitio_master, new FragmentListaTecnologias(), "lista");
        ft.commit();
    }

    private void personalizarToolbar() {
        this.setSupportActionBar(toolbar);
    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar_support);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_add:
                DialogoAddTecnologia dialogoAddTecnologia = new DialogoAddTecnologia();
                dialogoAddTecnologia.show(getSupportFragmentManager(),"dialogo_add");
                break;
        }
        return true;
    }

    @Override
    public void onTecnologiaAdd(Tecnologias tecnologias) {
        //Toast.makeText(getApplicationContext(), tecnologias.getNombre(), Toast.LENGTH_SHORT).show();
        FragmentListaTecnologias fragmentListaTecnologias = (FragmentListaTecnologias) getSupportFragmentManager().findFragmentByTag("lista");
        fragmentListaTecnologias.addTecnologia(tecnologias);
    }
}