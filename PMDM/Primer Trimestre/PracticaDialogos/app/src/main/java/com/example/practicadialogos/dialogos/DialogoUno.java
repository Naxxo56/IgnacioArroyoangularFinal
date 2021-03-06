package com.example.practicadialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.practicadialogos.R;

public class DialogoUno extends DialogFragment {

    OnDialogoConfirmacion listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnDialogoConfirmacion) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.titulo_d1);
        builder.setMessage(R.string.mensaje_d1);
        builder.setPositiveButton(R.string.boton_si, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoConfirmacionSelected("Si");
            }
        });
        builder.setNegativeButton(R.string.boton_no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoConfirmacionSelected("No");
            }
        });
        return builder.create();
    }

    public interface OnDialogoConfirmacion {
        void onDialogoConfirmacionSelected(String confirmacion);
    }
}
