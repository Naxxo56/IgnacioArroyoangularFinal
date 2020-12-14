package com.nacho.t04_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nacho.t04_dialogos.R;
import com.nacho.t04_dialogos.utils.Equipo;

import java.util.ArrayList;

public class DialogoMultiple extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Dialogo seleccion multiple");

        final ArrayList<Equipo> listaEquipos = new ArrayList();
        listaEquipos.add(new Equipo("Barcelona","LaLiga", R.drawable.barcelonaa));
        listaEquipos.add(new Equipo("Valencia","LaLiga",R.drawable.valencia));
        listaEquipos.add(new Equipo("Madrid","LaLiga",R.drawable.madrid));
        boolean [] seleccionados = {false,true,true};
        String [] equiposNombre = {"Barsa","Valencia","Madrid"};
        builder.setMultiChoiceItems(equiposNombre, seleccionados, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {

            }
        });
        /*
        builder.setPositiveButton("Comunicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

         */

        return builder.create();
    }
}
