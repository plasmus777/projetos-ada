package com.github.plasmus777.biblioteca;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceVirtual;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaServiceVirtualImpl extends BibliotecaServiceImpl implements BibliotecaServiceVirtual {

    @Override
    public void reservar() {
        System.out.println("Um livro foi reservado.");
    }

    @Override
    public void consultar() {
        System.out.println("Um livro foi consultado.");
    }
}
