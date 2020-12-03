package com.borja.t3_elementos.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.borja.t3_elementos.R;

import com.borja.t3_elementos.utils.Helado;

import java.util.List;

public class AdaptadorRecyclerHelados extends RecyclerView.Adapter<AdaptadorRecyclerHelados.MiHolderHelados> {
    Context context;
    List<Helado> listaHelados;
    OnBotonRecyclerListener listener;

    public AdaptadorRecyclerHelados(Context context, List<Helado> listaHelados) {
        this.context = context;
        this.listaHelados = listaHelados;
        this.listener = (AdaptadorRecyclerHelados.OnBotonRecyclerListener) context;
    }

    public interface OnBotonRecyclerListener {
        void onHeladoSelected(Helado helado);
        void onHeladoLongClick();
    }

    @NonNull
    @Override
    public MiHolderHelados onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_helados_recycler, parent, false);
        MiHolderHelados holder = new MiHolderHelados(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderHelados holder, int position) {

        final Helado heladoActual = listaHelados.get(position);
        holder.getNombre().setText(heladoActual.getNombre());
        holder.getImagen().setImageResource(heladoActual.getImagen());
        holder.getBtnDetalle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ejecuto algo algo
                listener.onHeladoSelected(heladoActual);
            }
        });

        holder.getBtnDetalle().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onHeladoLongClick();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaHelados.size();
    }

    class MiHolderHelados extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView imagen;
        Button btnDetalle;

        public MiHolderHelados(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_nombre_recycler);
            imagen = itemView.findViewById(R.id.imagen_helados_recycler);
            btnDetalle = itemView.findViewById(R.id.boton_detalle_recycler);
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }

        public Button getBtnDetalle() {
            return btnDetalle;
        }

    }

}
