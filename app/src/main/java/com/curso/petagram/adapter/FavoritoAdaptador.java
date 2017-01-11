package com.curso.petagram.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.curso.petagram.pojo.Mascota;
import com.curso.petagram.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by quevivalapauli on 7/1/17.
 */

public class FavoritoAdaptador extends RecyclerView.Adapter<FavoritoAdaptador.FavoritoViewHolder> {

        private ArrayList<Mascota> mascotasFavoritas;
        private static Context context;
        public FavoritoAdaptador(Context context, ArrayList<Mascota> mascotasFavoritas) {
            this.context = context;
            this.mascotasFavoritas = mascotasFavoritas;
        }


        public static class FavoritoViewHolder extends RecyclerView.ViewHolder{

            private ImageView foto;
            private TextView nombre;
            private TextView favoritos;
            private ImageView filled;

            public FavoritoViewHolder(View itemView) {
                super(itemView);

                foto = (ImageView) itemView.findViewById(R.id.ivMascota);
                nombre = (TextView) itemView.findViewById(R.id.tvNombre);
                favoritos = (TextView) itemView.findViewById(R.id.tvFavoritos);
                filled = (ImageView) itemView.findViewById(R.id.ivFilled);
            }
        }

        @Override
        public FavoritoAdaptador.FavoritoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_favoritos,parent,false);
            return new FavoritoAdaptador.FavoritoViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final FavoritoAdaptador.FavoritoViewHolder favoritoViewHolder, final int position) {
            final Mascota mascota;

            mascota = mascotasFavoritas.get(position);
            Picasso picasso = Picasso.with(context);
            picasso.load(mascota.getFoto()).fit().into( favoritoViewHolder.foto);

            favoritoViewHolder.nombre.setText(mascota.getNombre());
            favoritoViewHolder.favoritos.setText(mascota.getFavoritos());
            favoritoViewHolder.filled.setImageResource(mascota.getFilled());
        }

        @Override
        public int getItemCount() {
            return mascotasFavoritas.size();
            //return 0;
        }

}
