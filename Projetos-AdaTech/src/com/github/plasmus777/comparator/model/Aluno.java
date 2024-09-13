package com.github.plasmus777.comparator.model;

public class Aluno implements Comparable<Aluno> {

    private String nome;
    private float nota;

    public Aluno(String nome, float nota){
        setNome(nome);
        setNota(nota);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return getNome() + "-" + getNota();
    }

    @Override
    public int compareTo(Aluno aluno) {
        int nota = (Float.compare(this.getNota(), aluno.getNota()));

        if(nota == 0){
            return this.getNome().compareTo(aluno.getNome());
        } else return nota;
    }
}
