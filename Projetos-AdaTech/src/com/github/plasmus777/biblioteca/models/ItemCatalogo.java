package com.github.plasmus777.biblioteca.models;

import java.time.LocalDate;

public abstract class ItemCatalogo {

    private int id;
    private static int ID_ATUAL;
    private String titulo;
    private String autor;
    private LocalDate data;
    private boolean reservado;
    private String nomeLocatario;

    public ItemCatalogo(String titulo, String autor, LocalDate data){
        this.id = ID_ATUAL++;
        setTitulo(titulo);
        setAutor(autor);
        setData(data);
    }

    public boolean isReservado(){
        return reservado;
    }

    public void setReservado(boolean reservado){
        this.reservado = reservado;
    }

    public void setNomeLocatario(String nomeLocatario){
        this.nomeLocatario = nomeLocatario;
    }

    public String getNomeLocatario(){
        return nomeLocatario;
    }

    public int getId(){
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof ItemCatalogo)) return false;
        if(this.titulo == null || this.autor == null )return false;

        ItemCatalogo cat = (ItemCatalogo) obj;

        return (this.getTitulo().equals(cat.getTitulo()) &&
                this.getAutor().equals(cat.getAutor()) &&
                this.getData().equals(cat.getData()));
    }
}
