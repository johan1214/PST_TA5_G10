package com.example.amst10.model;

public class ItemList {
    private String titulo;
    private String descripcion;
    private int imgResource;
    private String autor;
    private String editorial;
    private String categoria;
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

    public ItemList(int imgResource,String titulo,String autor,String editorial,String categoria,String descripcion){
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.imgResource=imgResource;
        this.autor=autor;
        this.editorial=editorial;
        this.categoria=categoria;

    }

}
