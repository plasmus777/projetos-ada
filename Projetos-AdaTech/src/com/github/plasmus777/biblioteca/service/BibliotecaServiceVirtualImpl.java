package com.github.plasmus777.biblioteca.service;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceVirtual;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepository;

public class BibliotecaServiceVirtualImpl extends BibliotecaServiceImpl implements BibliotecaServiceVirtual {
    public BibliotecaServiceVirtualImpl(BibliotecaRepository bibliotecaRepository){
        super(bibliotecaRepository);
    }
}
