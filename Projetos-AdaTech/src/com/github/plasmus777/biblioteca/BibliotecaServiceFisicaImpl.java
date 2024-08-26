package com.github.plasmus777.biblioteca;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceFisica;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaServiceFisicaImpl extends BibliotecaServiceImpl implements BibliotecaServiceFisica {

    @Override
    public void reservar() {
        System.out.println("Um livro foi reservado.");
    }

    @Override
    public void emprestar(){
        System.out.println("Um livro foi emprestado.");
    }

    @Override
    public void devolver(){
        System.out.println("Um livro foi devolvido.");
    }

    @Override
    public void cadastrar() {

    }

    @Override
    public void consultar(){
        System.out.println("Um livro foi consultado.");
    }
}
