package com.example.amst10;

public class Libro {
    /*String titulo,autor,editorial,categoria,sinopsis;
    public Libro(String titulo,String autor,String editorial,String categoria,String sinopsis){
        this.autor=autor;
        this.editorial=editorial;
        this.titulo=titulo;
        this.categoria=categoria;
        this.sinopsis=sinopsis;
    }*/
    private String titulo;
    private String descripcion;
    private int imgResource;
    private String autor;
    private String editorial;

    public String getAutor() {
        return autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImgResource() {
        return imgResource;
    }

    public void setImgResource(int imgResource) {
        this.imgResource = imgResource;
    }

    /*public ItemList(String titulo, String descripcion, int imgResource){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.imgResource=imgResource;

    }*/

}
