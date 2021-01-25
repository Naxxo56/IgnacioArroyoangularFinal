package com.nacho.t06_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.nacho.t06_fragments.adapters.AdaptadorRecyclerPersonas;
import com.nacho.t06_fragments.fragments.FragmentDetalle;
import com.nacho.t06_fragments.fragments.FragmentRecyclerPersonas;
import com.nacho.t06_fragments.fragments.FragmentUno;
import com.nacho.t06_fragments.utils.Persona;

public class SecondActivity extends AppCompatActivity implements AdaptadorRecyclerPersonas.OnPersonaItemListener {

    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();

        ft.replace(R.id.sitio_fragments_recycler, new FragmentRecyclerPersonas(), "fRecycler");
        ft.addToBackStack("fRecycler");

        ft.commit();
    }

    @Override
    public void onPersonaSelected(Persona persona) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        ft.replace(R.id.sitio_fragments_recycler, new FragmentDetalle.newInstance(persona), "fUno");
        ft.addToBackStack("fUno");
        ft.commit();
    }
}