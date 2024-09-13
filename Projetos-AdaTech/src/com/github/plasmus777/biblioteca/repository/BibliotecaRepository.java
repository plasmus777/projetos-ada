package com.github.plasmus777.biblioteca.repository;

import com.github.plasmus777.biblioteca.models.ItemCatalogo;

import java.util.ArrayList;

public interface BibliotecaRepository {

    ItemCatalogo cadastrar(ItemCatalogo item);
    ArrayList<ItemCatalogo> consultar(String nomeItem);
    ItemCatalogo atualizar(ItemCatalogo itemCatalogo);
}
