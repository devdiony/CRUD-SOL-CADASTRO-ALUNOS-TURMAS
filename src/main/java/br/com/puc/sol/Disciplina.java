package br.com.puc.sol;

/**
 * Representa uma Disciplina (ex: Programação Orientada a Objetos).
 */
public class Disciplina {

    private String nome;
    private int cargaHoraria;

    public Disciplina(String nome, int cargaHoraria) {
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() {
        return nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }
}