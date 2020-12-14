package com.nacho.t04_dialogos.dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.nacho.t04_dialogos.R;

public class DialogoPersonalizado extends DialogFragment {

    private View view;
    private Button botonDialogo;
    private EditText editNombre, editPass;
    private CheckBox checkDialogo;
    private OnDia

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_layout, null);
        try{
            listener = context;
        }catch (ClassCastException e){
            Toast.makeText(getContext(),"No se puede castear",Toast.LENGTH_SHORT).show();
        }

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setView(R.layout.dialogo_layout);
        builder.setView(view);

        botonDialogo = view.findViewById(R.id.boton_dialogo);
        editNombre = view.findViewById(R.id.edit_nombre);
        editPass = view.findViewById(R.id.edit_contraseña);
        checkDialogo = view.findViewById(R.id.check_dialogo);

        return builder.create();
    }

    @Override
    public void onResume() {
        super.onResume();
        botonDialogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre= editNombre.getText().toString(),pass = editPass.getText().toString();
                if(nombre.isEmpty() || pass.isEmpty()){
                    Toast.makeText(getContext(), "Algun dato es vacio", Toast.LENGTH_SHORT).show();
                }else{
                   listener.onDialogoPersoSelected
                }
                dismiss();
            }
        });
    }

    public interface onDialogoPerso{
        void onDialogoPersoSelected();
        
    }
}
