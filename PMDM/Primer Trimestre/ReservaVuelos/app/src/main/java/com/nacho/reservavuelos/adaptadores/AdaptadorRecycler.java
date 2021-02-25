package com.nacho.reservavuelos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nacho.reservavuelos.R;
import com.nacho.reservavuelos.utils.Pais;

import java.util.List;

public class AdaptadorRecycler extends RecyclerView.Adapter<AdaptadorRecycler.MiHolderPais> {

    Context context;
    List<Pais> listaPaises;
    OnPaisRecyclerListener listener;

    public AdaptadorRecycler(Context context, List<Pais> listaPaises) {
        this.context = context;
        this.listaPaises = listaPaises;
        listener = (OnPaisRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolderPais onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
        MiHolderPais holder = new MiHolderPais(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderPais holder, int position) {
        final Pais paisActual = listaPaises.get(position);

        holder.getBotonDetalle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onPaisSelected(paisActual);
            }
        });
        holder.getBotonDetalle().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                listener.onPaisLongSelected();
                return true;
            }
        });
        holder.getOrigenDestino().setText(paisActual.getNombre());
        holder.getImagenPais().setImageResource(paisActual.getImagen());

    }

    @Override
    public int getItemCount() {
        return listaPaises.size();
    }

    public interface OnPaisRecyclerListener {
        void onPaisSelected(Pais pais);

        void onPaisLongSelected();
    }

    class MiHolderPais extends RecyclerView.ViewHolder {

        TextView origenDestino;
        ImageView imagenPais;
        Button botonDetalle;

        public MiHolderPais(@NonNull View itemView) {
            super(itemView);
            origenDestino = itemView.findViewById(R.id.texto_paisida_paisvuelta);
            imagenPais = itemView.findViewById(R.id.imagen_recycler_pais);
            botonDetalle = itemView.findViewById(R.id.boton_detalle_recycler);
        }

        public TextView getOrigenDestino() {
            return origenDestino;
        }

        public ImageView getImagenPais() {
            return imagenPais;
        }

        public Button getBotonDetalle() {
            return botonDetalle;
        }
    }
}
