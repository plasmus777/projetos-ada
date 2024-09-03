package com.github.plasmus777.biblioteca.service;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaService;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepository;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepositoryImpl;

import java.util.ArrayList;

public abstract class BibliotecaServiceImpl implements BibliotecaService {

    BibliotecaRepository bibliotecaRepository;

    public BibliotecaServiceImpl(BibliotecaRepository bibliotecaRepository){
        setBibliotecaRepository(bibliotecaRepository);
    }

    public void setBibliotecaRepository(BibliotecaRepository bibliotecaRepository){
        this.bibliotecaRepository = bibliotecaRepository;
    }

    @Override
    public ArrayList<ItemCatalogo> consultar(String nomeItem){
        return bibliotecaRepository.consultar(nomeItem);
    }

    @Override
    public ItemCatalogo reservar(ItemCatalogo itemCatalogo) {
        ArrayList<ItemCatalogo> itens = bibliotecaRepository.consultar(itemCatalogo.getTitulo());

        if(itens == null || itens.isEmpty()) {
            System.out.println("Não foi possível encontrar o item especificado.");
            return null;
        }

        boolean reservado = false;
        ItemCatalogo item = null;
        for(ItemCatalogo i: itens){
            if(i.equals(itemCatalogo)){
                if(!i.isReservado()){                    i.setReservado(true);
                    item = i;
                    reservado = true;
                    break;
                }
            }
        }

        if(!reservado){
            System.out.println("Não foi possível reservar o item especificado.");
        }else{
            System.out.println("O item \"" + item.getTitulo() + "\" foi reservado com sucesso.");
        }

        return item;
    }
}
