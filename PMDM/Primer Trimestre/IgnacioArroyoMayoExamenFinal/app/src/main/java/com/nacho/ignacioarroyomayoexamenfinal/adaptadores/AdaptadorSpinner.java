package com.nacho.ignacioarroyomayoexamenfinal.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nacho.ignacioarroyomayoexamenfinal.R;
import com.nacho.ignacioarroyomayoexamenfinal.utils.Clase;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {
    ArrayList<Clase> listaClase;
    Context context;

    public AdaptadorSpinner(ArrayList listaClase, Context context) {
        this.listaClase = listaClase;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaClase.size();
    }

    @Override
    public Object getItem(int position) {
        return listaClase.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_fila_spinner,parent,false);

        Clase cosaActual = listaClase.get(position);
        TextView nombre = convertView.findViewById(R.id.texto_spinner);
        nombre.setText(cosaActual.getCosa());

        return convertView;
    }
}
