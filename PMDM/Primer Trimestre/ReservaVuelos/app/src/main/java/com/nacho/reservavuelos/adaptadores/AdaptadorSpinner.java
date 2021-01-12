package com.nacho.reservavuelos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.nacho.reservavuelos.R;
import com.nacho.reservavuelos.utils.Pais;

import java.util.ArrayList;

public class AdaptadorSpinner extends BaseAdapter {

    ArrayList<Pais> listaPais;
    Context context;

    public AdaptadorSpinner(ArrayList listaPais, Context context) {
        this.listaPais = listaPais;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaPais.size();
    }

    @Override
    public Object getItem(int i) {
        return listaPais.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.item_spinner, parent, false);

        Pais paisActual = listaPais.get(position);
        ImageView imagenPais = convertView.findViewById(R.id.imagen_vuelo_spinner);
        TextView nombrePais = convertView.findViewById(R.id.texto_pais_spinner);
        //Glide.with(context).load(paisActual.getImagenURL()).into(imagenPais);
        nombrePais.setText(paisActual.getNombre());
        imagenPais.setImageResource(paisActual.getImagen());
        //System.out.println(paisActual.toString());
        //imagenPais.setImageDrawable(paisActual.getImagenURL());
        //imagenPais.setImageURI((paisActual.getImagenURL()));
        //imagenPais.setImageResource(paisActual.getImagenURL());
        return convertView;
    }
}
