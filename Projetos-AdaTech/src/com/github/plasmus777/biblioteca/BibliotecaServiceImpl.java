package com.github.plasmus777.biblioteca;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaService;
import com.github.plasmus777.biblioteca.modelos.ItemCatalogo;

import java.util.ArrayList;
import java.util.List;

public abstract class BibliotecaServiceImpl implements BibliotecaService {

    List<ItemCatalogo> itens = new ArrayList<ItemCatalogo>();

}
