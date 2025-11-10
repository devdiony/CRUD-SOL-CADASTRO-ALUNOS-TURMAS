package br.com.puc.sol;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um Curso (ex: Engenharia de Software).
 * Esta classe demonstra o CONCEITO de Associação (um Curso "tem" Disciplinas).
 */
public class Curso {

    private String nome;

    /**
     * CONCEITO: Associação (Composição).
     * Um Curso é composto por uma lista de Disciplinas.
     * Usamos List (uma Interface) e inicializamos com ArrayList (uma Classe concreta)
     * para manter a flexibilidade.
     */
    private List<Disciplina> gradeCurricular;

    public Curso(String nome) {
        this.nome = nome;
        this.gradeCurricular = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        this.gradeCurricular.add(disciplina);
        System.out.println("Disciplina " + disciplina.getNome() + " adicionada ao curso " + this.nome);
    }

    public void listarDisciplinas() {
        System.out.println("--- Disciplinas do Curso: " + this.nome + " ---");
        for (Disciplina d : this.gradeCurricular) {
            System.out.println("- " + d.getNome() + " (" + d.getCargaHoraria() + "h)");
        }
    }
}