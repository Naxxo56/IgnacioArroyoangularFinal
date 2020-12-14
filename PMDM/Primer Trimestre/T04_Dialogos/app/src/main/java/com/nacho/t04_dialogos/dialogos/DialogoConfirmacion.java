package com.nacho.t04_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoConfirmacion extends DialogFragment {

    OnDialogoConfirmacion listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (OnDialogoConfirmacion) context;
        } catch (ClassCastException e) {
            Log.v("casteo", "No se ha podido castear");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("¿Estas seguro?");
        builder.setMessage("Por favor indica si quieres cerrar la aplicacion");
        builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoConfirmacionSelected("Si");
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoConfirmacionSelected("No");
            }
        });
        builder.setNeutralButton("No se", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Toast.makeText(getContext(),"SEGURO  QUE NO QUIERO CERRAR",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return builder.create();
    }

    public interface OnDialogoConfirmacion {
        void onDialogoConfirmacionSelected(String confirmacion);
    }
}
