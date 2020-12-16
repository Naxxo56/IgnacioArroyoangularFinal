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

public class DialogoTres extends DialogFragment {
    private String nombre;
    DialogoTres.OnDialogoConfirmacion listener;

    public static DialogoTres newInstance(String nombre) {
        DialogoTres dialogoTres = new DialogoTres();
        Bundle bundle  = new Bundle();
        bundle.putString("nombre",nombre);
        dialogoTres.setArguments(bundle);
        return dialogoTres;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener= (OnDialogoConfirmacion) context;
        this.nombre=this.getArguments().getString("nombre");
    }
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.titulo_d3);
        builder.setMessage(String.format("%s %s %s",getResources().getString(R.string.mensaje_d3_p1),nombre,getResources().getString(R.string.mensaje_d3_p2)));
        builder.setPositiveButton(R.string.boton_continuar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoConfirmacionSelectedTres("Si");
            }
        });
        builder.setNegativeButton(R.string.boton_cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoConfirmacionSelectedTres("No");

            }
        });
        return builder.create();
    }



    public interface OnDialogoConfirmacion {
        void onDialogoConfirmacionSelectedTres(String confirmacion);
    }
}
