package com.curso.petagram.pojo;

/**
 * Created by quevivalapauli on 9/1/17.
 */

public class Foto {
    private String foto;
    private String favoritos;
    private int filled;

    public Foto(String foto, String favoritos, int filled) {
        this.foto = foto;
        this.favoritos = favoritos;
        this.filled = filled;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(String favoritos) {
        this.favoritos = favoritos;
    }

    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }
}
