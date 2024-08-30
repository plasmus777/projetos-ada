package com.github.plasmus777.biblioteca.service;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceVirtual;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;

public class BibliotecaServiceVirtualImpl extends BibliotecaServiceImpl implements BibliotecaServiceVirtual {

    @Override
    public void reservar(ItemCatalogo itemCatalogo) {
        System.out.println("Um livro foi reservado.");
    }
}
