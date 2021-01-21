package com.nacho.t06_fragments.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nacho.t06_fragments.R;

import org.w3c.dom.Text;

public class FragmentFuncional extends Fragment implements View.OnClickListener {

    private Button botonFr1, botonFr2, botonFr3, botonBuscarFrag;
    private EditText editFrBuscar;
    private View view;
    private OnFragmentFuncionalListener listener;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void acciones() {
        botonFr1.setOnClickListener(this);
        botonFr2.setOnClickListener(this);
        botonFr3.setOnClickListener(this);
        botonBuscarFrag.setOnClickListener(this);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            this.listener = (OnFragmentFuncionalListener) context;
        }catch (ClassCastException e){
            Log.v("casteo","No se puede hacer este casteo");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_fragment_funcional, container, false);
        return view;
    }

    public void instancias() {
        botonFr1 = view.findViewById(R.id.button_ir_f1);
        botonFr2 = view.findViewById(R.id.button_ir_f2);
        botonFr3 = view.findViewById(R.id.button_ir_f3);
        botonBuscarFrag = view.findViewById(R.id.b_buscar);
        editFrBuscar = view.findViewById(R.id.edit_buscar);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_ir_f1:
                listener.comunicarPulsacion("f1");
                break;
            case R.id.button_ir_f2:
                listener.comunicarPulsacion("f2");
                break;
            case R.id.button_ir_f3:
                listener.comunicarPulsacion("f3");
                break;
            case R.id.b_buscar:
                listener.buscarFragment(editFrBuscar.getText().toString());
                break;
        }
    }

    public interface OnFragmentFuncionalListener {

        void comunicarPulsacion(String tag);

        void buscarFragment(String tag);

    }
}
