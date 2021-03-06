package com.curso.coursera.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.curso.coursera.R;
import com.curso.coursera.adapter.MascotaAdaptador;
import com.curso.coursera.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> mascotasFavoritas;

    private RecyclerView listaMascotas;

    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();

        inicializarListaFavoritas();



        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(getContext(),mascotas, mascotasFavoritas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("https://www.petdarling.com/articulos/wp-content/uploads/2015/05/moquillo-en-perros-1.jpg", R.drawable.bone, "Tales", "0", R.drawable.filled_bone));
        mascotas.add(new Mascota("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQweTf6jghuG1LVFf6I1CBQnRZQ-Mi3tOrY3F89X6nPC8YX9HiSsA",R.drawable.bone, "Sofocles", "0", R.drawable.filled_bone));
        mascotas.add(new Mascota("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQ800ir5MUkEiCcwXZVoPhfD1wbWcATY_p-E_sI-tU5kfIboA_3Pg", R.drawable.bone, "Confucio", "0", R.drawable.filled_bone));
        mascotas.add(new Mascota("https://mott.pe/noticias/wp-content/uploads/2016/03/ovejero-shetland.jpg", R.drawable.bone, "Platón", "0", R.drawable.filled_bone));
        mascotas.add(new Mascota("https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcQYl9IF5lvbhAotrMlAglQpNScgAhOFWmirWggDh2eB7KhIHeL5BQ", R.drawable.bone, "Pitágoras", "0", R.drawable.filled_bone));
;
    }


    public void inicializarListaFavoritas(){

        mascotasFavoritas = new ArrayList<Mascota>();

    }



    public void sendDataToFavorites(Intent intentMFavoritas){
        int size = mascotasFavoritas.size();

        for(int i = size-1; i >= 0; i--){

            intentMFavoritas.putExtra("mascotasFoto" + String.valueOf(size-1-i), mascotasFavoritas.get(i).getFoto());
            intentMFavoritas.putExtra("mascotasNombre" + String.valueOf(size-1-i), mascotasFavoritas.get(i).getNombre());
            intentMFavoritas.putExtra("mascotasFavorito" + String.valueOf(size-1-i), mascotasFavoritas.get(i).getFavoritos());
        }
        intentMFavoritas.putExtra("size", size);
    }

    public void receiveDataFromMainActivity(Intent data){
        int size;
        Bundle extras;
        String nombre, favoritos;

        inicializarListaMascotas();

        extras = data.getExtras();

        size = (int) extras.getInt("size");

        for(int i=0; i<size-1;i++){

            nombre = (String)extras.get("mascotasNombre" + String.valueOf(i));
            favoritos = (String)extras.get("mascotasFavorito" + String.valueOf(i));

            for(int j=0;j<mascotas.size()-1;j++){

                if(nombre.equals(mascotas.get(j).getNombre())){
                    mascotas.get(j).setFavoritos(favoritos);
                }
            }
        }
    }



}
