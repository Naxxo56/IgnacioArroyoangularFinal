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
import com.borja.t3_elementos.utils.Ensalada;
import com.borja.t3_elementos.utils.Hamburguesa;


import java.util.List;

public class AdaptadorRecyclerEnsaladas extends RecyclerView.Adapter<AdaptadorRecyclerEnsaladas.MiHolderEnsaladas> {

    Context context;
    List<Ensalada> listaEnsalada;
    OnBotonRecyclerListener listener;

    public AdaptadorRecyclerEnsaladas(Context context, List<Ensalada> listaEnsalada) {
        this.context = context;
        this.listaEnsalada = listaEnsalada;
        this.listener= (OnBotonRecyclerListener) context;

    }

    @NonNull
    @Override
    public MiHolderEnsaladas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_ensaladas_recycler, parent, false);
        AdaptadorRecyclerEnsaladas.MiHolderEnsaladas holder = new MiHolderEnsaladas(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderEnsaladas holder, int position) {

        final Ensalada ensaladaActual = listaEnsalada.get(position);
        holder.getNombre().setText(ensaladaActual.getNombre());
        holder.getImagen().setImageResource(ensaladaActual.getImagen());
        holder.getBtnDetalle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEnsaladaSelected(ensaladaActual);
            }
        });

        holder.getBtnDetalle().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onEnsaladaLongClick();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaEnsalada.size();
    }

    public interface OnBotonRecyclerListener{
        void onEnsaladaSelected(Ensalada ensalada);
        void onEnsaladaLongClick();
    }

    class MiHolderEnsaladas extends RecyclerView.ViewHolder{

        TextView nombre;
        ImageView imagen;
        Button btnDetalle;

        public MiHolderEnsaladas(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_nombre_recycler);
            imagen = itemView.findViewById(R.id.imagen_ensaladas_recycler);
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
