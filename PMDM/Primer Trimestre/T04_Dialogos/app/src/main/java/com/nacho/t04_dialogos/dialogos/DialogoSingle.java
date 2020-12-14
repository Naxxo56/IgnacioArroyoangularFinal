package com.nacho.t04_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nacho.t04_dialogos.R;
import com.nacho.t04_dialogos.adaptadores.AdaptadorDialogo;
import com.nacho.t04_dialogos.utils.Equipo;

import java.util.ArrayList;

public class DialogoSingle extends DialogFragment {

    OnDialogoSingle listener;
    private int posicion;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try{
            listener = (OnDialogoSingle) context;
        }catch (ClassCastException e){
            Log.v("casteo","No se ha podido castear");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final String [] opciones = {"Opcion1","Opcion2","Opcion3"};
        final ArrayList<Equipo> listaEquipos = new ArrayList();
        listaEquipos.add(new Equipo("Barcelona","LaLiga", R.drawable.barcelonaa));
        listaEquipos.add(new Equipo("Valencia","LaLiga",R.drawable.valencia));
        listaEquipos.add(new Equipo("Madrid","LaLiga",R.drawable.madrid));
        builder.setTitle("Dialogo lista single");
        /*
        builder.setSingleChoiceItems(opciones, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //listener.onDialogoSingleSelected(opciones[i]);
                //dismiss();
                posicion = i;
            }
        });
         */
        /*
        ArrayAdapter adapter = new ArrayAdapter(getContext(),android.R.layout.simple_list_item_checked,listaEquipos);

        builder.setSingleChoiceItems(adapter, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                posicion=i;
            }
        });
         */

        AdaptadorDialogo adaptadorDialogo = new AdaptadorDialogo(getContext(),listaEquipos);
        builder.setSingleChoiceItems(adaptadorDialogo, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoEquipoSingleListener(listaEquipos.get(i));
                dismiss();
            }
        });

        builder.setPositiveButton("Comunicar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //listener.onDialogoSingleSelected(opciones[posicion]);
                listener.onDialogoEquipoSingleListener(listaEquipos.get(posicion));
            }
        });
        return builder.create();
    }
    public interface OnDialogoSingle{
        void onDialogoSingleSelected(String opcion);
        void onDialogoEquipoSingleListener(Equipo equipo);
    }
}
