package com.curso.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.curso.petagram.R;
import com.curso.petagram.adapter.FotoAdaptador;
import com.curso.petagram.pojo.Foto;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Foto> galeria;

    RecyclerView recyclerViewGrid;
    CircularImageView circularImageView;
    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        recyclerViewGrid = (RecyclerView) v.findViewById(R.id.rvPerfilGrid);
        circularImageView = (CircularImageView) v.findViewById(R.id.civPerfil) ;
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);

        recyclerViewGrid.setLayoutManager(glm);

        inicializarGrid();
        inicializarAdaptador();

        return v;
    }

    private void inicializarGrid() {
        galeria = new ArrayList<Foto>();

        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "1", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "2", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "3", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "4", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "5", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "6", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "7", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "8", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "9", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "10", R.drawable.filled_bone));
        galeria.add(new Foto("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", "11", R.drawable.filled_bone));
    }

    private void inicializarAdaptador() {
        FotoAdaptador adaptador = new FotoAdaptador(getContext(),galeria);

        Picasso picasso = Picasso.with(getContext());
        picasso.load("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg").fit().into(circularImageView);;

        recyclerViewGrid.setAdapter(adaptador);
    }

}
