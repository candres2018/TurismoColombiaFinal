package com.example.turismocolombia3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.turismocolombia3.Modelos.Mosquera;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MosqueraAdapter extends RecyclerView.Adapter<MosqueraAdapter.MosqueraViewHolder> {
    List<Mosquera> mosquera;

    public MosqueraAdapter(List<Mosquera> mosquera){
        this.mosquera = mosquera;
    }

    @Override
    public int getItemCount() {
        return mosquera.size();
    }

    @Override
    public MosqueraViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        MosqueraViewHolder mosqueraViewHolder = new MosqueraViewHolder(v);
        return mosqueraViewHolder;
    }

    @Override
    public void onBindViewHolder(MosqueraViewHolder MosqueraViewHolder, int i) {
        MosqueraViewHolder.sitios_turisticos.setText(mosquera.get(i).getSitios_turisticos());
        MosqueraViewHolder.ubicacion.setText(mosquera.get(i).getUbicacion());
        MosqueraViewHolder.descripci_n.setText(mosquera.get(i).getDescripci_n());
        String url = "https://www.datos.gov.co/views/yf8m-7cq5/files/"+mosquera.get(i).getImagen();
        Picasso.get()
                .load(url)
                .into(MosqueraViewHolder.imagen);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class MosqueraViewHolder extends RecyclerView.ViewHolder {
        TextView sitios_turisticos;
        TextView ubicacion;
        TextView descripci_n;
        ImageView imagen;

        MosqueraViewHolder(View itemView) {
            super(itemView);
            sitios_turisticos = itemView.findViewById(R.id.nombre);
            ubicacion = itemView.findViewById(R.id.lugar);
            descripci_n = itemView.findViewById(R.id.detalle);
            imagen = itemView.findViewById(R.id.imageViewAll);
        }
    }

}
