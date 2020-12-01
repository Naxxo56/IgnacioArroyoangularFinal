package com.nacho.ignacioarroyomayoexamenfinal.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nacho.ignacioarroyomayoexamenfinal.R;
import com.nacho.ignacioarroyomayoexamenfinal.utils.Elementos;

import java.util.ArrayList;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolder>{

    ArrayList<Elementos> listaElementos;
    Context context;

    public AdaptadorRecycler(ArrayList<Elementos> listaElementos, Context context) {
        this.listaElementos = listaElementos;
        this.context = context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(context).inflate(R.layout.item_fila_recycler,parent,false);
        MiHolder holder = new MiHolder(vista);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Elementos elementoActual = listaElementos.get(position);
        holder.getNombre().setText(elementoActual.getNombre());
        holder.getEquipo().setText(elementoActual.getEquipo());
        holder.getImagen().setImageResource(elementoActual.getImagen());

    }

    @Override
    public int getItemCount() {
        return listaElementos.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        private TextView nombre, equipo;
        private ImageView imagen;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_recycler_perso);
            equipo = itemView.findViewById(R.id.equipo_recycler_perso);
            imagen = itemView.findViewById(R.id.imagen_recycler_perso);
        }

        public TextView getNombre() {
            return nombre;
        }

        public TextView getEquipo() {
            return equipo;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }
}
