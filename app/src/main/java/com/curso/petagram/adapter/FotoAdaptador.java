package com.curso.petagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.curso.petagram.R;
import com.curso.petagram.pojo.Foto;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by quevivalapauli on 9/1/17.
 */

public class FotoAdaptador extends RecyclerView.Adapter<FotoAdaptador.FotoViewHolder> {

    private final ArrayList<Foto> galeria;
    private static Context context;
    public FotoAdaptador(Context context,ArrayList<Foto> galeria) {
        this.context = context;
        this.galeria = galeria;
    }

    public class FotoViewHolder extends RecyclerView.ViewHolder {

        private ImageView foto,filled;
        private TextView favoritos;

        public FotoViewHolder(View itemView) {
            //Asociar cada elemento del XML a su objeto java de vista
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.ivThumb);
            favoritos = (TextView) itemView.findViewById(R.id.tvThumbFavoritos);
            filled = (ImageView) itemView.findViewById(R.id.ivThumbFilled);

        }
    }

    @Override
    public FotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Asocia el layout de una cardView al adaptador
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_thumbnail,parent,false);
        return new FotoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FotoViewHolder fotoViewHolder, int position) {
        Picasso picasso = Picasso.with(context);
        picasso.load(galeria.get(position).getFoto()).fit().into(fotoViewHolder.foto);;
        fotoViewHolder.favoritos.setText(galeria.get(position).getFavoritos());
        fotoViewHolder.filled.setImageResource(galeria.get(position).getFilled());
    }

    @Override
    public int getItemCount() {
        return galeria.size();
    }

}
