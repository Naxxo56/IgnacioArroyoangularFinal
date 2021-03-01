package com.nacho.ignacioarroyofinalpmdm.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nacho.ignacioarroyofinalpmdm.R;
import com.nacho.ignacioarroyofinalpmdm.utils.Liga;

import java.util.ArrayList;
import java.util.List;


public class AdaptadorLiga extends RecyclerView.Adapter<AdaptadorLiga.MiHolder> {

    private Context context;
    private ArrayList<Liga> listaLigas;
    private OnLigaListener listener;

    public AdaptadorLiga(Context context) {
        this.context = context;
        this.listaLigas = new ArrayList<>();
        this.listener = (OnLigaListener) context;
    }

    @NonNull
    @Override
    public MiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_liga, parent, false);
        return new MiHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MiHolder holder, int position) {

        final Liga ligaActual = listaLigas.get(position);
        holder.getNombreLiga().setText(ligaActual.getNombreLiga());

        holder.getNombreLiga().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onLigaSelected(ligaActual);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaLigas.size();
    }

    public interface OnLigaListener {
        void onLigaSelected(Liga liga);
    }

    public void rellenarLista(Liga liga) {
        listaLigas.add(liga);
        notifyDataSetChanged();
    }

    class MiHolder extends RecyclerView.ViewHolder {
        private TextView nombreLiga;

        public MiHolder(@NonNull View itemView) {
            super(itemView);
            nombreLiga = itemView.findViewById(R.id.texto_nombre_recycler);
        }

        public TextView getNombreLiga() {
            return nombreLiga;
        }
    }


}
