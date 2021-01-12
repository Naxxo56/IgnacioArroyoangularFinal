package com.nacho.t06_fragments.fragments;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nacho.t06_fragments.R;

public class FragmentHeader extends Fragment {

    private Button botonCabecera;
    private View view;
    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.layout_fragment_header, container, false);
        return view;
    }

    public void instancias() {
        botonCabecera = view.findViewById(R.id.button_cabecera);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    public void acciones() {
        botonCabecera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(context, "Boton cabecera pulsado", Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(), "Boton cabecera pulsado", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
