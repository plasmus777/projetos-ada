package com.github.plasmus777.biblioteca.main;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceFisica;
import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceVirtual;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepository;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepositoryImpl;
import com.github.plasmus777.biblioteca.service.BibliotecaServiceFisicaImpl;
import com.github.plasmus777.biblioteca.service.BibliotecaServiceVirtualImpl;

public class Main {
    public static void main(String[] args) {
        BibliotecaRepository repository = new BibliotecaRepositoryImpl();

        BibliotecaServiceFisica bibliotecaFisica = new BibliotecaServiceFisicaImpl(repository);

        BibliotecaServiceVirtual bibliotecaVirtual = new BibliotecaServiceVirtualImpl(repository);
    }
}
