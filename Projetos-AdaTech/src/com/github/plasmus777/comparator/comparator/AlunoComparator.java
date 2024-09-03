package com.github.plasmus777.comparator.comparator;

import tech.ada.poo.base.ordenador.comparator.model.Aluno;

import java.util.Comparator;

public class AlunoComparator implements Comparator<Aluno> {
    @Override
    public int compare(Aluno a1, Aluno a2) {
        int nome = a1.getNome().compareTo(a2.getNome());

        if (nome == 0) {
            return Float.compare(a1.getNota(), a2.getNota());
        }
        return nome;
    }
}
