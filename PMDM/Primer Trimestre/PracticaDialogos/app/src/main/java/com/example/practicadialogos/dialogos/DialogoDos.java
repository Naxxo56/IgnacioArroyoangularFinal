package com.example.practicadialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

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
        builder.setTitle("Dialogo Dos");
        builder.setMessage("Introduce tu nombre");
        builder.setView(view);
        editNombre = view.findViewById(R.id.edit_nombre);

        return builder.create();
    }

    public interface OnDialogoConfirmacion {
        void onDialogoConfirmacionSelectedDos(String confirmacion);
    }
}
