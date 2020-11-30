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
import com.borja.t3_elementos.utils.Bebida;
import com.borja.t3_elementos.utils.Cafe;

import java.util.List;

public class AdaptadorRecyclerBebidas extends RecyclerView.Adapter<AdaptadorRecyclerBebidas.MiHolderBebidas> {
    Context context;
    List<Bebida> listaBebidas;
    OnBotonRecyclerListener listener;
    public AdaptadorRecyclerBebidas(Context context, List<Bebida> listaBebidas) {
        this.context = context;
        this.listaBebidas = listaBebidas;
        this.listener = (OnBotonRecyclerListener)context;
    }

    @NonNull
    @Override
    public MiHolderBebidas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_bebidas_recycler, parent, false);
        MiHolderBebidas holder = new MiHolderBebidas(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderBebidas holder, int position) {
        final Bebida bebidaActual = listaBebidas.get(position);
        holder.getNombre().setText(bebidaActual.getNombre());
        holder.getImagen().setImageResource(bebidaActual.getImagen());
        holder.getBtnDetalle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ejecuto algo algo
                listener.onBebidaSelected(bebidaActual);
            }
        });
        holder.getBtnDetalle().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onBebidaLongClick();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaBebidas.size();
    }

    class MiHolderBebidas extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView imagen;
        Button btnDetalle;

        public MiHolderBebidas(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_nombre_recycler);
            imagen = itemView.findViewById(R.id.imagen_bebidas_recycler);
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

    public interface OnBotonRecyclerListener {
        void onBebidaSelected(Bebida bebida);

        void onBebidaLongClick();
    }
}
