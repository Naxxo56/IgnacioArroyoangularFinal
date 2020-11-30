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
import com.borja.t3_elementos.utils.Hamburguesa;

import java.util.List;

public class AdaptadorRecyclerHamburguesas extends RecyclerView.Adapter<AdaptadorRecyclerHamburguesas.MiHolderCoches> {

    Context context;
    List<Hamburguesa> listaHamburguesas;
    OnBotonRecyclerListener listener;

    public AdaptadorRecyclerHamburguesas(Context context, List<Hamburguesa> listaHamburguesas) {
        this.context = context;
        this.listaHamburguesas = listaHamburguesas;
        this.listener = (OnBotonRecyclerListener) context;
    }

    @NonNull
    @Override
    public MiHolderCoches onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_hamburguesa_recycler, parent, false);
        MiHolderCoches holder = new MiHolderCoches(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiHolderCoches holder, int position) {

        final Hamburguesa cocheActual = listaHamburguesas.get(position);
        holder.getModelo().setText(cocheActual.getNombre());
        holder.getImagen().setImageResource(cocheActual.getImagen());
        holder.getBtnDetalle().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             // ejecuto algo algo
                listener.onCocheSelected(cocheActual);
            }
        });

        holder.getBtnDetalle().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onCocheLongClick();
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaHamburguesas.size();
    }


    public interface OnBotonRecyclerListener{
        void onCocheSelected(Hamburguesa hamburguesa);
        void onCocheLongClick();
    }

    class MiHolderCoches extends RecyclerView.ViewHolder {

        TextView nombre;
        ImageView imagen;
        Button btnDetalle;

        public MiHolderCoches(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_nombre_recycler);
            imagen = itemView.findViewById(R.id.imagen_hamburguesas_recycler);
            btnDetalle = itemView.findViewById(R.id.boton_detalle_recycler);
        }

        public TextView getModelo() {
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
