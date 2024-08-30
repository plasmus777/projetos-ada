package com.github.plasmus777.biblioteca.models;

import java.time.LocalDate;

public class Livro extends ItemCatalogo{

    private String isbn;
    private int numeroPaginas;
    private String editora;

    public Livro(String titulo, String autor, LocalDate data, String isbn, int numeroPaginas, String editora){
        super(titulo, autor, data);
        setIsbn(isbn);
        setNumeroPaginas(numeroPaginas);
        setEditora(editora);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Livro)) return false;
        if(this.isbn == null || this.editora == null )return false;

        Livro livro = (Livro) obj;

        return (super.equals(obj) &&
                this.getIsbn().equals(livro.getIsbn()) &&
                this.getNumeroPaginas() == livro.getNumeroPaginas() &&
                this.getEditora().equals(livro.getEditora()));
    }
}
