package com.example.fragmentscorreo.fragments;

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

import com.example.fragmentscorreo.R;
import com.example.fragmentscorreo.adaptadores.AdaptadorTecnologiasRecycler;
import com.example.fragmentscorreo.utils.Tecnologias;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FragmentListaTecnologias extends Fragment {

    private View view;
    private RecyclerView recyclerTecnologias;
    private AdaptadorTecnologiasRecycler adaptadorTecnologiasRecycler;
    private ArrayList<Tecnologias> listaInicial;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listaInicial = new ArrayList<>();
        listaInicial.add(new Tecnologias("Angular", R.drawable.angular, "Descripcion..."));
        listaInicial.add(new Tecnologias("Mysql", R.drawable.mysql, "Descripcion..."));
        listaInicial.add(new Tecnologias("Java", R.drawable.java, "Descripcion..."));
        listaInicial.add(new Tecnologias("HTML", R.drawable.html, "Descripcion..."));
        listaInicial.add(new Tecnologias("PHP", R.drawable.php, "Descripcion..."));
        listaInicial.add(new Tecnologias("Python", R.drawable.python, "Descripcion..."));
        adaptadorTecnologiasRecycler = new AdaptadorTecnologiasRecycler(listaInicial, getContext());
        adaptadorTecnologiasRecycler.notifyDataSetChanged();
    }

    public void addTecnologia(Tecnologias tecnologias) {
        adaptadorTecnologiasRecycler.notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_lista_tecnologia_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        iniciarRecycler();

    }

    private void iniciarRecycler() {
        recyclerTecnologias.setAdapter(adaptadorTecnologiasRecycler);
        recyclerTecnologias.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    private void instancias() {
        recyclerTecnologias = view.findViewById(R.id.recycler_tecnologia);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
