package com.github.plasmus777.biblioteca.service;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaService;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepository;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepositoryImpl;

import java.util.ArrayList;

public abstract class BibliotecaServiceImpl implements BibliotecaService {

    BibliotecaRepository bibliotecaRepository;

    public void setBibliotecaRepository(BibliotecaRepository bibliotecaRepository){
        this.bibliotecaRepository = bibliotecaRepository;
    }

    @Override
    public ArrayList<ItemCatalogo> consultar(String nomeItem){
        return bibliotecaRepository.consultar(nomeItem);
    }
}
