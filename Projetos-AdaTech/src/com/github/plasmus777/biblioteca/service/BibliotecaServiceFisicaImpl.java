package com.github.plasmus777.biblioteca.service;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceFisica;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepository;

public class BibliotecaServiceFisicaImpl extends BibliotecaServiceImpl implements BibliotecaServiceFisica {

    public BibliotecaServiceFisicaImpl(BibliotecaRepository bibliotecaRepository){
        super(bibliotecaRepository);
    }

    @Override
    public void emprestar(ItemCatalogo itemCatalogo, String nomeLocatario){
        if(itemCatalogo.isReservado()){
            System.out.println("O item " + itemCatalogo.getTitulo() + " já foi reservado.");
        } else{
            itemCatalogo.setReservado(true);
            itemCatalogo.setNomeLocatario(nomeLocatario);
            System.out.println("O item " + itemCatalogo.getTitulo() + " foi emprestado com sucesso.");
        }
    }

    @Override
    public void devolver(ItemCatalogo itemCatalogo){
        if(itemCatalogo.isReservado()){
            itemCatalogo.setReservado(false);
            itemCatalogo.setNomeLocatario(null);
            System.out.println("O item " + itemCatalogo.getTitulo() + " foi devolvido ao catálogo.");
        } else {
            System.out.println("O item " + itemCatalogo.getTitulo() + " não foi emprestado e, portanto, não pode ser devolvido.");
        }
    }

    @Override
    public void cadastrar(ItemCatalogo itemCatalogo) {
        super.bibliotecaRepository.cadastrar(itemCatalogo);
    }
}
