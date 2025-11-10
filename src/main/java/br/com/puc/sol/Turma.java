package br.com.puc.sol;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma Turma (uma oferta de uma Disciplina em um semestre).
 * Esta classe é o "coração" dos relacionamentos, ligando
 * Aluno, Professor e Disciplina.
 */
public class Turma {

    // Relacionamentos de Associação
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;
    private String semestre;

    public Turma(Disciplina disciplina, Professor professor, String semestre) {
        this.disciplina = disciplina;
        this.professor = professor;
        this.semestre = semestre;
        this.alunos = new ArrayList<>();
    }

    // Métodos para gerenciar os relacionamentos (CRUD em memória)

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
        System.out.println("Aluno " + aluno.getNome() + " matriculado na turma de " + this.disciplina.getNome());
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
        System.out.println("Aluno " + aluno.getNome() + " removido da turma de " + this.disciplina.getNome());
    }

    public void listarAlunos() {
        System.out.println("--- Alunos da Turma " + this.disciplina.getNome() + " (" + this.semestre + ") ---");
        System.out.println("Professor: " + this.professor.getNome());
        for (Aluno a : this.alunos) {
            System.out.println("- " + a.getNome() + " (Matrícula: " + a.getMatricula() + ")");
        }
    }

    // Getters para acessar os dados encapsulados
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }

    public String getSemestre() {
        return semestre;
    }
}