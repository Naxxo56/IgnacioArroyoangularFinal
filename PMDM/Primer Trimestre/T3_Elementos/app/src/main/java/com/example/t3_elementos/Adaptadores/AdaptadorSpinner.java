package com.example.t3_elementos.Adaptadores;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {
    ArrayList listaMarcas;
    Context context;

    public AdaptadorSpinner(ArrayList listaMarcas, Context context) {
        this.listaMarcas = listaMarcas;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaMarcas.size();
    }

    @Override
    public Object getItem(int i) {
        return listaMarcas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        return convertView;
    }
}
