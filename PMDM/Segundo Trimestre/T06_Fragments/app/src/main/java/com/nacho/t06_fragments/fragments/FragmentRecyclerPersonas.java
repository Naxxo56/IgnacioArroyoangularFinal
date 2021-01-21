package com.nacho.t06_fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nacho.t06_fragments.R;
import com.nacho.t06_fragments.adapters.AdaptadorRecyclerPersonas;
import com.nacho.t06_fragments.utils.Persona;

import java.util.ArrayList;

public class FragmentRecyclerPersonas extends Fragment {

    private RecyclerView recyclerPersonas;
    private View view;
    private ArrayList<Persona> listaPersonas;
    private AdaptadorRecyclerPersonas adaptadorRecycler;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        rellenarAdapter(context);
    }

    private void rellenarAdapter(Context context) {
        listaPersonas = new ArrayList();
        listaPersonas.add(new Persona("Nacho","Arroyo",R.drawable.hombre));
        listaPersonas.add(new Persona("Pedro","Herrera",R.drawable.hombre));
        listaPersonas.add(new Persona("Roberto","Gomez",R.drawable.hombre));
        listaPersonas.add(new Persona("Dani","Sol",R.drawable.hombre));
        listaPersonas.add(new Persona("Celia","Arroyo",R.drawable.mujer));
        listaPersonas.add(new Persona("Marta","Arroyo",R.drawable.mujer));
        adaptadorRecycler= new AdaptadorRecyclerPersonas(listaPersonas,context);
        adaptadorRecycler.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_recycler_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        rellenarRecycler();
    }

    private void rellenarRecycler() {
        recyclerPersonas.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
        recyclerPersonas.setAdapter(adaptadorRecycler);
    }



    private void instancias() {
        recyclerPersonas = view.findViewById(R.id.recycler_personas);
    }
}
