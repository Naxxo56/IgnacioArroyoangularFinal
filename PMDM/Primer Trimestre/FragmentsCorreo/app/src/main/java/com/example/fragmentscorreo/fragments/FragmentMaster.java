package com.example.fragmentscorreo.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentscorreo.R;

public class FragmentMaster extends Fragment {

    private Button botonMaster;
    private View view;
    private OnFragmentMasterListener listener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        listener = (OnFragmentMasterListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_master_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        instancias();
        acciones();
    }

    private void acciones() {
        botonMaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(), "Pulsado desde master", Toast.LENGTH_SHORT).show();
                listener.onFragmentMasterSelected();
            }
        });
    }

    private void instancias() {
        botonMaster = view.findViewById(R.id.boton_master);
    }

    public interface OnFragmentMasterListener {
        void onFragmentMasterSelected();
    }
}
