package com.example.versionesactivity.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.versionesactivity.R;
import com.example.versionesactivity.Utils.Version;

import java.util.List;

public class AdaptadorVersiones extends RecyclerView.Adapter<AdaptadorVersiones.HolderVersion> {

    List<Version> listaVersiones;
    Context context;
    OnVersionListener listener;

    public AdaptadorVersiones(List<Version> listaVersiones, Context context) {
        this.listaVersiones = listaVersiones;
        this.context = context;
        this.listener = (OnVersionListener) context;
    }

    @NonNull
    @Override
    public HolderVersion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_version_fila, parent, false);
        return new HolderVersion(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderVersion holder, int position) {
        final Version version = listaVersiones.get(position);
        holder.getNombre().setText(version.getNombre());
        holder.getImagen().setImageResource(version.getLogo());
        holder.getLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onVersionSelected(version);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaVersiones.size();
    }

    public interface OnVersionListener {
        void onVersionSelected(Version version);

    }

    class HolderVersion extends RecyclerView.ViewHolder {

        private TextView nombre;
        private ImageView imagen;
        private LinearLayout layout;

        public HolderVersion(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombre_version_fila);
            imagen = itemView.findViewById(R.id.imagen_version_fila);
            layout = itemView.findViewById(R.id.item_fila);
        }

        public LinearLayout getLayout() {
            return layout;
        }

        public TextView getNombre() {
            return nombre;
        }

        public ImageView getImagen() {
            return imagen;
        }
    }
}
