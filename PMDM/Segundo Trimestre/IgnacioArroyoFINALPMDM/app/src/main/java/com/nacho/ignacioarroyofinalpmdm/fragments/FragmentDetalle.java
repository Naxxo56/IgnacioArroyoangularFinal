package com.nacho.ignacioarroyofinalpmdm.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.nacho.ignacioarroyofinalpmdm.R;
import com.nacho.ignacioarroyofinalpmdm.adaptadores.AdaptadorEquipos;
import com.nacho.ignacioarroyofinalpmdm.dialogo.DialogoEquipo;
import com.nacho.ignacioarroyofinalpmdm.utils.Equipo;
import com.nacho.ignacioarroyofinalpmdm.utils.Liga;

public class FragmentDetalle extends Fragment{

    private View view;
    Equipo equipo;
    private ImageView imagen;
    private TextView descripcion, nombreEquipos;
    private Button botonRed, botonFav;


    public static FragmentDetalle newInstance(Equipo equipo) {

        Bundle args = new Bundle();
        args.putSerializable("equipo", equipo);
        FragmentDetalle fragment = new FragmentDetalle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            equipo = (Equipo) getArguments().getSerializable("equipo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_detalle_equipo, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        meterDatos();
        acciones();
    }

    private void acciones() {
        botonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogoEquipo dialogoEquipo =  DialogoEquipo.newInstance(equipo);
                dialogoEquipo.show(getFragmentManager(),"dialogo");
            }
        });
    }

    private void meterDatos() {
        Glide.with(getContext()).load(equipo.getBanner()).into(imagen);
        nombreEquipos.setText(equipo.getNombre());
        descripcion.setText(equipo.getDescripcion());
    }

    private void instancias() {
        imagen = view.findViewById(R.id.imagen_detalle);
        descripcion = view.findViewById(R.id.descripcion);
        nombreEquipos = view.findViewById(R.id.texto_detalle);
        botonRed = view.findViewById(R.id.boton_redes);
        botonFav = view.findViewById(R.id.boton_favoritos);
    }


}
