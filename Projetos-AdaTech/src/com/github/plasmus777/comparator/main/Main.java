package com.github.plasmus777.comparator.main;

import tech.ada.poo.base.ordenador.comparator.comparator.AlunoComparator;
import tech.ada.poo.base.ordenador.comparator.model.Aluno;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Aluno> lista = new ArrayList<>();

        lista.add(new Aluno("Ana", 8.5f));
        lista.add(new Aluno("José", 7f));
        lista.add(new Aluno("Arthur", 5.3f));
        lista.add(new Aluno("Zafara", 10f));
        lista.add(new Aluno("Renata", 6f));
        lista.add(new Aluno("Giovanni", 3.5f));

        System.out.println(Arrays.toString(lista.toArray()));

        //->nota->nome
        //Collections.sort(lista);

        //->nome->nota
        Comparator<Aluno> c = new AlunoComparator();
        Collections.sort(lista, c);

        System.out.println(Arrays.toString(lista.toArray()));
    }
}
