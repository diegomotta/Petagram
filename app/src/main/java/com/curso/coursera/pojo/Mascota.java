package com.curso.coursera.pojo;

/**
 * Created by quevivalapauli on 27/12/16.
 */

public class Mascota{
    private String foto;
    private int bone;
    private String nombre;
    private String favoritos;
    private int filled;

    public Mascota(String foto, int bone, String nombre, String favoritos, int filled) {
        this.foto = foto;
        this.bone = bone;
        this.nombre = nombre;
        this.favoritos = favoritos;
        this.filled = filled;
    }



    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getBone() {
        return bone;
    }

    public void setBone(int bone) {
        this.bone = bone;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
