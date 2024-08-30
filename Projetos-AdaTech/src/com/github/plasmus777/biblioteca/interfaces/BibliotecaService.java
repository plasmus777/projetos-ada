package com.github.plasmus777.biblioteca.interfaces;

import com.github.plasmus777.biblioteca.models.ItemCatalogo;

import java.util.ArrayList;

public interface BibliotecaService {

    void reservar(ItemCatalogo itemCatalogo);

    ArrayList<ItemCatalogo> consultar(String nomeItem);

}
