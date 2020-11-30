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
import com.borja.t3_elementos.utils.Cafe;
import com.borja.t3_elementos.utils.Hamburguesa;


import java.util.List;

public class AdaptadorRecyclerCafe extends RecyclerView.Adapter<AdaptadorRecyclerCafe.MiHolderCafe> {
    Context context;
    List<Cafe> listaCafe;
    OnBotonRecyclerListener listener;

    public AdaptadorRecyclerCafe(Context context, List<Cafe> listaCafe) {
        this.context = context;
        this.listaCafe = listaCafe;
        this.listener = (OnBotonRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolderCafe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_cafe_recycler, parent, false);
        MiHolderCafe holder = new MiHolderCafe (view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderCafe holder, int position) {

        final Cafe cafeActual = listaCafe.get(position);
        holder.getNombre().setText(cafeActual.getNombre());
        holder.getImagen().setImageResource(cafeActual.getImagen());
        holder.getBtnDetalle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ejecuto algo algo
                listener.onCafeSelected(cafeActual);
            }
        });
        holder.getBtnDetalle().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onCafeLongClick();
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaCafe.size();
    }

    public interface OnBotonRecyclerListener {
        void onCafeSelected(Cafe cafe);

        void onCafeLongClick();
    }

    class MiHolderCafe extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView imagen;
        Button btnDetalle;

        public MiHolderCafe(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_nombre_recycler);
            imagen = itemView.findViewById(R.id.imagen_cafe_recycler);
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
