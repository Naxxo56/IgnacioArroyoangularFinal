package com.nacho.t06_fragments.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.nacho.t06_fragments.R;
import com.nacho.t06_fragments.utils.Persona;

public class FragmentDetalle extends Fragment {

    private View view;

    public static FragmentDetalle newInstance(Persona persona) {

        Bundle bundle = new Bundle();
        FragmentDetalle fragment = new FragmentDetalle();
        bundle.putSerializable("persona",persona);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_detalle_layout, container, false);
        return view;
    }
}
