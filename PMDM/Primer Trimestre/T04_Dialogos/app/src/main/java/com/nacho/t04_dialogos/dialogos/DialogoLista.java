package com.nacho.t04_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoLista extends DialogFragment {

    OnDialogoLista listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (DialogoLista.OnDialogoLista) context;
        } catch (ClassCastException e) {
            Log.v("casteo", "No se ha podido castear");
        }
    }

    //sera llamado cuando cree un objeto de la clase
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final String [] opciones = {"Opcion1","Opcion2","Opcion3"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getContext(), opciones[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setTitle("Dialogo listas");

        return builder.create();
    }

    public interface OnDialogoLista{
        void onDialogoListaSelected(String opcion);
    }
}
