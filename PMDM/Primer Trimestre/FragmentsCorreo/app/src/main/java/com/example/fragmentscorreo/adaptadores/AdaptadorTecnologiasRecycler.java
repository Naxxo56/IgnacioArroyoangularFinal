package com.example.fragmentscorreo.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentscorreo.R;
import com.example.fragmentscorreo.utils.Tecnologias;

import java.util.List;

public class AdaptadorTecnologiasRecycler extends RecyclerView.Adapter<AdaptadorTecnologiasRecycler.MiHolder> {

    List<Tecnologias> listaTecnologias;
    Context context;

    public AdaptadorTecnologiasRecycler(List<Tecnologias> listaTecnologias, Context context) {
        this.listaTecnologias = listaTecnologias;
        this.context = context;
    }

    public void addTecnologia(Tecnologias tecnologias) {
        this.listaTecnologias.add(tecnologias);
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tecnologia_recycler, parent, false);

        return new MiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        Tecnologias tecnologia = listaTecnologias.get(position);
        holder.getImagen().setImageResource(tecnologia.getImagen());
        holder.getNombre().setText(tecnologia.getNombre());
    }

    @Override
    public int getItemCount() {
        return listaTecnologias.size();
    }

    class MiHolder extends RecyclerView.ViewHolder {

        ImageView imagen;
        TextView nombre;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_recycler);
            nombre = itemView.findViewById(R.id.texto_recycler);
        }

        public ImageView getImagen() {
            return imagen;
        }

        public void setImagen(ImageView imagen) {
            this.imagen = imagen;
        }

        public TextView getNombre() {
            return nombre;
        }

        public void setNombre(TextView nombre) {
            this.nombre = nombre;
        }
    }

}
