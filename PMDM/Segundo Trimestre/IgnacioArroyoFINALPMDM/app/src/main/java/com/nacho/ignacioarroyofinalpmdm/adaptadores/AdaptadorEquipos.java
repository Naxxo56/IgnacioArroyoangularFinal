package com.nacho.ignacioarroyofinalpmdm.adaptadores;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nacho.ignacioarroyofinalpmdm.R;
import com.nacho.ignacioarroyofinalpmdm.utils.Equipo;
import com.nacho.ignacioarroyofinalpmdm.utils.Liga;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MiHolder> {

    private Context context;
    private ArrayList<Equipo> listaEquipo;
    private OnEquipoListener listener;

    public AdaptadorEquipos(Context context) {
        this.context = context;
        listaEquipo = new ArrayList();
        listener = (OnEquipoListener) context;
    }

    public void rellenarLista(Equipo equipo) {
        listaEquipo.add(equipo);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_equipo, parent, false);
        return new MiHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {
        final Equipo equipoActual = listaEquipo.get(position);
        Glide.with(context).load(equipoActual.getEscudo()).into(holder.imagenEquipo);
        holder.botonDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onEquipoSelected(equipoActual);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaEquipo.size();
    }

    public interface OnEquipoListener {
        void onEquipoSelected(Equipo equipo);
    }

    class MiHolder extends RecyclerView.ViewHolder {
        private ImageView imagenEquipo;
        private Button botonDetalle;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            imagenEquipo = itemView.findViewById(R.id.imagen_equipo_recycler);
            botonDetalle = itemView.findViewById(R.id.boton_detalle_recycler);
        }

        public ImageView getImagenEquipo() {
            return imagenEquipo;
        }

        public Button getBotonDetalle() {
            return botonDetalle;
        }
    }

}
