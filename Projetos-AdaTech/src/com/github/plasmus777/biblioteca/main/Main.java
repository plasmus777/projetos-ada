package com.github.plasmus777.biblioteca.main;

import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceFisica;
import com.github.plasmus777.biblioteca.interfaces.BibliotecaServiceVirtual;
import com.github.plasmus777.biblioteca.models.ItemCatalogo;
import com.github.plasmus777.biblioteca.models.Livro;
import com.github.plasmus777.biblioteca.models.Manuscrito;
import com.github.plasmus777.biblioteca.models.Revista;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepository;
import com.github.plasmus777.biblioteca.repository.BibliotecaRepositoryImpl;
import com.github.plasmus777.biblioteca.service.BibliotecaServiceFisicaImpl;
import com.github.plasmus777.biblioteca.service.BibliotecaServiceVirtualImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        BibliotecaRepository repository = new BibliotecaRepositoryImpl();

        BibliotecaServiceFisica bibliotecaFisica = new BibliotecaServiceFisicaImpl(repository);

        BibliotecaServiceVirtual bibliotecaVirtual = new BibliotecaServiceVirtualImpl(repository);

        ItemCatalogo i1 = new Livro("Livro Novo", "Autor 1", LocalDate.now(), "123456", 200, "Editora 1");
        ItemCatalogo i2 = new Manuscrito("Manuscrito Antigo", "Desconhecido 2", LocalDate.now(), "País qualquer", "Petrificado", false);
        ItemCatalogo i3 = new Revista("Revista Popular", "Autores 3", LocalDate.now(), 536, "Fevereiro", "Moda");

        //Apenas a biblioteca física pode cadastrar novos itens
        bibliotecaFisica.cadastrar(i1);
        bibliotecaFisica.cadastrar(i2);
        bibliotecaFisica.cadastrar(i3);

        //Tanto as bibliotecas virtual e física podem realizar consultas
        System.out.println(bibliotecaVirtual.consultar("rev"));//Virtual
        System.out.println(bibliotecaFisica.consultar("li"));//Física

        //Além disso, as bibliotecas virtual e física também podem reservar itens
        bibliotecaVirtual.reservar(bibliotecaVirtual.consultar("li").getFirst());//Reserva o primeiro (e único) livro
        bibliotecaFisica.reservar(bibliotecaFisica.consultar("ma").getFirst());//Reserva o primeiro (e único) manuscrito

        //No caso da biblioteca física é possível emprestar itens
        //No exemplo abaixo, Ronaldo obteve a Revista Popular emprestada.
        bibliotecaFisica.emprestar(bibliotecaFisica.consultar("re").getFirst(), "Ronaldo");

        //Um empréstimo do mesmo item para Helena não será possível, pois já foi reservado
        bibliotecaFisica.emprestar(bibliotecaFisica.consultar("re").getFirst(), "Helena");

        //Ronaldo terminou de ler a revista e a devolveu
        bibliotecaFisica.devolver(bibliotecaFisica.consultar("re").getFirst());

        //Logo, Helena poderá obter a revista com sucesso
        bibliotecaFisica.emprestar(bibliotecaFisica.consultar("re").getFirst(), "Helena");

    }
}
