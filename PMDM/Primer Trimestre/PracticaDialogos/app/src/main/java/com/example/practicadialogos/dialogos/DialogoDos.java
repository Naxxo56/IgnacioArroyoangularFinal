package com.example.practicadialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.practicadialogos.R;

public class DialogoDos extends DialogFragment {
    private View view;
    private EditText editNombre;
    DialogoDos.OnDialogoConfirmacion listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_nombre, null);
        listener = (OnDialogoConfirmacion) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(R.string.titulo_d2);
        builder.setMessage(R.string.mensaje_d2);
        builder.setView(view);

        editNombre = view.findViewById(R.id.edit_nombre);


        builder.setPositiveButton(R.string.boton_continuar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!editNombre.getText().toString().isEmpty()) {
                    listener.onDialogoConfirmacionSelectedDos(editNombre.getText().toString());
                } else {
                    Toast.makeText(getContext(), "Fallo al comunicar", Toast.LENGTH_SHORT).show();
                }

            }
        });
        builder.setNegativeButton(R.string.boton_cancelar, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onDialogoConfirmacionSelectedDos("No");
            }
        });

        return builder.create();
    }

    public interface OnDialogoConfirmacion {
        void onDialogoConfirmacionSelectedDos(String confirmacion);
    }
}
