package br.com.puc.sol;

/**
 * CONCEITO: Abstração e Classe Abstrata.
 * Esta classe 'Pessoa' é abstrata porque ela representa um conceito geral (uma pessoa)
 * que não existe de forma concreta no sistema (você não cadastra uma "Pessoa",
 * mas sim um "Aluno" ou "Professor").
 * Ela serve como um "molde" para as subclasses.
 */

public abstract class Pessoa {

    /**
     * CONCEITO: Encapsulamento.
     * Os atributos são 'protected' para que as classes filhas (Aluno, Professor)
     * possam acessá-los diretamente, mas classes de outros pacotes não.
     * 'private' também seria uma opção, usando getters/setters.
     */
    protected String nome;
    protected String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    /**
     * CONCEITO: Polimorfismo (via Abstração).
     * Este é um método abstrato. Ele define O QUE deve ser feito (exibir um perfil),
     * mas não COMO.
     * Cada subclasse (Aluno, Professor) será OBRIGADA a implementar sua própria
     * versão deste método, permitindo que tratemos ambos como "Pessoa" e
     * chamemos o 'exibirPerfil()' correto.
     */
    public abstract void exibirPerfil();
}