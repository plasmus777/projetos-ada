package com.github.plasmus777.biblioteca.service;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceFisica;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;

public class BibliotecaServiceFisicaImpl extends BibliotecaServiceImpl implements BibliotecaServiceFisica {

    @Override
    public void emprestar(ItemCatalogo itemCatalogo){
        System.out.println("Um livro foi emprestado.");
    }

    @Override
    public void devolver(ItemCatalogo itemCatalogo){
        System.out.println("Um livro foi devolvido.");
    }

    @Override
    public void cadastrar(ItemCatalogo itemCatalogo) {

    }
}
