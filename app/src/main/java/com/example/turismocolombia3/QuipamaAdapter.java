package com.example.turismocolombia3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.turismocolombia3.Modelos.Granada;
import com.example.turismocolombia3.Modelos.Quipama;
import com.squareup.picasso.Picasso;

import java.util.List;

public class QuipamaAdapter extends RecyclerView.Adapter<QuipamaAdapter.QuipamaViewHolder> {
    List<Quipama> quipama;

    public QuipamaAdapter(List<Quipama> granada){
        this.quipama = granada;
    }

    @Override
    public int getItemCount() {
        return quipama.size();
    }

    @Override
    public QuipamaViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card, viewGroup, false);
        QuipamaViewHolder quipamaViewHolder = new QuipamaViewHolder(v);
        return quipamaViewHolder;
    }

    @Override
    public void onBindViewHolder(QuipamaViewHolder QuipamaViewHolder, int i) {
        QuipamaViewHolder.nombre_sitio.setText(quipama.get(i).getNombre_sitio());
        QuipamaViewHolder.lugar.setText(quipama.get(i).getLugar());
        QuipamaViewHolder.descripcion.setText(quipama.get(i).getDescripcion());
        String url = "https://www.datos.gov.co/views/aq9g-b755/files/"+quipama.get(i).getImagen();
        Picasso.get()
                .load(url)
                .into(QuipamaViewHolder.imagen);
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public static class QuipamaViewHolder extends RecyclerView.ViewHolder {
        TextView nombre_sitio;
        TextView lugar;
        TextView descripcion;
        ImageView imagen;

        QuipamaViewHolder(View itemView) {
            super(itemView);
            nombre_sitio = itemView.findViewById(R.id.nombre);
            lugar = itemView.findViewById(R.id.lugar);
            descripcion = itemView.findViewById(R.id.detalle);
            imagen = itemView.findViewById(R.id.imageViewAll);
        }
    }

}
