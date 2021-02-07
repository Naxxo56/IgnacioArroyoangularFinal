package com.example.fragmentscorreo.dialogos;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.fragmentscorreo.R;
import com.example.fragmentscorreo.utils.Tecnologias;

public class DialogoAddTecnologia extends DialogFragment {

    private Context context;
    private EditText editNombre, editDescripcion;
    private Button botonAdd;
    private OnDialogoAddListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        listener= (OnDialogoAddListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View v = LayoutInflater.from(context).inflate(R.layout.layout_dialogo_add, null);

        editNombre = v.findViewById(R.id.text_tecnologia_add);
        editDescripcion = v.findViewById(R.id.edit_tecnologia_des);
        botonAdd = v.findViewById(R.id.button_tec_add);

        builder.setView(v);
        return builder.create();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        botonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!editDescripcion.getText().toString().isEmpty() && !editNombre.getText().toString().isEmpty()) {
                    String nombre = editNombre.getText().toString();
                    String descripcion = editDescripcion.getText().toString();
                    Tecnologias tecnologias = new Tecnologias(nombre, R.drawable.img_tec, descripcion);
                    listener.onTecnologiaAdd(tecnologias);

                    Toast.makeText(context, "Add correcto", Toast.LENGTH_SHORT).show();
                    dismiss();
                } else {
                    Toast.makeText(context, "Hay algo vacio", Toast.LENGTH_SHORT).show();
                    dismiss();

                }

            }
        });
    }

    public interface OnDialogoAddListener{
        void onTecnologiaAdd(Tecnologias tecnologias);
    }
}
