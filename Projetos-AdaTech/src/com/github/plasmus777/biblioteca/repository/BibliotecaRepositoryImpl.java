package com.github.plasmus777.biblioteca.repository;

import com.github.plasmus777.biblioteca.models.ItemCatalogo;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaRepositoryImpl implements BibliotecaRepository{

    private List<ItemCatalogo> itens = new ArrayList<ItemCatalogo>();

    @Override
    public ItemCatalogo cadastrar(ItemCatalogo item) {
        itens.add(item);
        System.out.println("-----Item cadastrado-----");
        System.out.println("Título: " + item.getTitulo());
        System.out.println("Autor: " + item.getAutor());
        System.out.println("Data: " + item.getData());
        System.out.println("-------------------------");
        return item;
    }

    @Override
    public ArrayList<ItemCatalogo> consultar(String nomeItem) {
        ArrayList<ItemCatalogo> busca = new ArrayList<>();
        if(this.itens == null || itens.isEmpty()){
            System.out.println("O catálogo está vazio!");
            return busca;
        }

        for(ItemCatalogo item : itens){
            if(item.getTitulo().toLowerCase().contains(nomeItem.toLowerCase())){
                busca.add(item);
            }
        }

        return busca;
    }

    @Override
    public ItemCatalogo atualizar(ItemCatalogo itemCatalogo) {

        if(!itemCatalogo.isReservado()){
            itemCatalogo.setReservado(true);
            System.out.println("O livro " + itemCatalogo.getTitulo() + " está indisponível para reserva.");
        } else {
            itemCatalogo.setReservado(false);
            System.out.println("O livro " + itemCatalogo.getTitulo() + " está disponível para reserva.");
        }

        return itemCatalogo;
    }
}
