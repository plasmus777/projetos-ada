package com.github.plasmus777.biblioteca.models;

import java.time.LocalDate;

public class Manuscrito extends ItemCatalogo{

    private String localOrigem;
    private String estadoConservacao;
    private boolean digitalizado;

    public Manuscrito(String titulo, String autor, LocalDate data, String localOrigem, String estadoConservacao, boolean digitalizado){
        super(titulo, autor, data);
        setLocalOrigem(localOrigem);
        setEstadoConservacao(estadoConservacao);
        setDigitalizado(digitalizado);
    }

    public boolean isDigitalizado() {
        return digitalizado;
    }

    public void setDigitalizado(boolean digitalizado) {
        this.digitalizado = digitalizado;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    public String getLocalOrigem() {
        return localOrigem;
    }

    public void setLocalOrigem(String localOrigem) {
        this.localOrigem = localOrigem;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Manuscrito)) return false;
        if(this.localOrigem == null || this.estadoConservacao == null )return false;

        Manuscrito manuscrito = (Manuscrito) obj;

        return (super.equals(obj) &&
                this.getLocalOrigem().equals(manuscrito.getLocalOrigem()) &&
                this.getEstadoConservacao().equals(manuscrito.getEstadoConservacao()) &&
                this.isDigitalizado() == manuscrito.isDigitalizado());
    }
}
