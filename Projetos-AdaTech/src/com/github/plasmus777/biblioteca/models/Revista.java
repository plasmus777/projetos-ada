package com.github.plasmus777.biblioteca.models;

import java.time.LocalDate;

public class Revista extends ItemCatalogo{

    private int numeroEdicao;
    private String mesPublicacao;
    private String categoria;

    public Revista(String titulo, String autor, LocalDate data, int numeroEdicao, String mesPublicacao, String categoria){
        super(titulo, autor, data);
        setNumeroEdicao(numeroEdicao);
        setMesPublicacao(mesPublicacao);
        setCategoria(categoria);
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMesPublicacao() {
        return mesPublicacao;
    }

    public void setMesPublicacao(String mesPublicacao) {
        this.mesPublicacao = mesPublicacao;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public void setNumeroEdicao(int numeroEdicao) {
        this.numeroEdicao = numeroEdicao;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Revista)) return false;
        if(this.mesPublicacao == null || this.categoria == null )return false;

        Revista revista = (Revista) obj;

        return (super.equals(obj) &&
                this.getNumeroEdicao() == revista.getNumeroEdicao() &&
                this.getMesPublicacao().equals(revista.getMesPublicacao()) &&
                this.getCategoria().equals(revista.getCategoria()));
    }
}
