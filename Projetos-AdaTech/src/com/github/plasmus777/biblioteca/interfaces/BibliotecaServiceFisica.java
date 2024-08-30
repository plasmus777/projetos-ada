package com.github.plasmus777.biblioteca.interfaces;

import com.github.plasmus777.biblioteca.models.ItemCatalogo;

public interface BibliotecaServiceFisica extends BibliotecaService{

    void emprestar(ItemCatalogo itemCatalogo);

    void devolver(ItemCatalogo itemCatalogo);

    void cadastrar(ItemCatalogo itemCatalogo);
}
