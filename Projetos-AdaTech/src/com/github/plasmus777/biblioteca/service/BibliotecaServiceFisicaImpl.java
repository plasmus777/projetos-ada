package com.github.plasmus777.biblioteca.service;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceFisica;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepository;

public class BibliotecaServiceFisicaImpl extends BibliotecaServiceImpl implements BibliotecaServiceFisica {

    public BibliotecaServiceFisicaImpl(BibliotecaRepository bibliotecaRepository){
        super(bibliotecaRepository);
    }

    @Override
    public void emprestar(ItemCatalogo itemCatalogo){
        System.out.println("Um item foi emprestado.");
    }

    @Override
    public void devolver(ItemCatalogo itemCatalogo){
        System.out.println("Um item foi devolvido.");
    }

    @Override
    public void cadastrar(ItemCatalogo itemCatalogo) {

    }
}
