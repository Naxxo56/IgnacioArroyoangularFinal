package com.example.t3_elementos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.t3_elementos.R;
import com.example.t3_elementos.utils.Coche;

import java.util.ArrayList;

public class AdaptadorLista extends BaseAdapter {

    ArrayList<Coche> listaElementos;
    int[] logos = new int[]{R.drawable.alfa, R.drawable.audi, R.drawable.ford, R.drawable.bmw, R.drawable.luxury, R.drawable.mercedes, R.drawable.normal, R.drawable.opel, R.drawable.peugeot, R.drawable.seat, R.drawable.sport, R.drawable.volvo, R.drawable.vw,};
    Context context;

    public AdaptadorLista(ArrayList lista, Context context) {
        this.listaElementos = lista;
        this.context = context;
    }

    //cuantas filas tiene la lista o spinner
    @Override
    public int getCount() {
        return listaElementos.size();
    }

    //retorna el objeto de cada fila
    @Override
    public Object getItem(int position) {
        return listaElementos.get(position);
    }

    //retorna el id del elemento que esta en una posición
    @Override
    public long getItemId(int position) {
        return position;
    }

    //retorna la vista de la fila ya pintada
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textMarca, textModelo;

        convertView = LayoutInflater.from(context).inflate(R.layout.item_fila_lista, parent, false);

        Coche cocheActual = listaElementos.get(position);

        textMarca = convertView.findViewById(R.id.marca_lista_perso);
        textModelo = convertView.findViewById(R.id.modelo_lista_perso);

        textMarca.setText(cocheActual.getMarca());
        textModelo.setText(cocheActual.getModelo());


        return convertView;


    }
}
