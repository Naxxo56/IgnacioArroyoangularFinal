package com.nacho.ignacioarroyofinalpmdm.dialogo;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.nacho.ignacioarroyofinalpmdm.R;
import com.nacho.ignacioarroyofinalpmdm.utils.Equipo;

public class DialogoEquipo extends DialogFragment {

    private Equipo equipo;
    private View view;
    private TextView textoInsta, textoTwitter, textoFace, textoWeb;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getArguments() != null) {
            equipo = (Equipo) this.getArguments().getSerializable("equipo");
        }
        view = View.inflate(context, R.layout.item_redes_sociales, null);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        instancias();
        rellenarDialogo();
        return builder.create();
    }

    private void rellenarDialogo() {
        textoInsta.setText(equipo.getInsta());
        textoTwitter.setText(equipo.getTw());
        textoFace.setText(equipo.getFb());
        textoWeb.setText(equipo.getWeb());
    }

    private void instancias() {
         textoInsta = view.findViewById(R.id.texto_insta);
         textoTwitter = view.findViewById(R.id.texto_twit);
         textoFace = view.findViewById(R.id.texto_face);
         textoWeb = view.findViewById(R.id.texto_internet);
    }

    public static DialogoEquipo newInstance(Equipo equipo) {
        Bundle args = new Bundle();
        args.putSerializable("equipo", equipo);
        DialogoEquipo dialogoEquipo = new DialogoEquipo();
        dialogoEquipo.setArguments(args);
        return dialogoEquipo;
    }


}
